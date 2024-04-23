package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.Doctor;
import com.senai.BackendUniSenai.model.DoctorSchedule;
import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.repository.DoctorScheduleRepository;
import com.senai.BackendUniSenai.repository.ScheduleRepository;
import com.senai.BackendUniSenai.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public ResponseEntity<Optional<Schedule>> findScheduleById(int id) {
        try {
            Optional<Schedule> schedule = scheduleRepository.findById(id);

            if (schedule.isPresent()) {
                return ResponseEntity.ok(schedule);
            }
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<Schedule>> findAllSchedules() {
        return ResponseEntity.ok(scheduleRepository.findAll());
    }

    public ResponseEntity<Schedule> add(Schedule schedule) {
        try {
            return ResponseEntity.ok(scheduleRepository.saveAndFlush(schedule));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Schedule> update(int id, Schedule schedule) {
        if (!scheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado no banco de dados.");
        }
        schedule.setId(id);

        try {
            final Schedule updateSchedule = scheduleRepository.save(schedule);
            return ResponseEntity.ok(updateSchedule);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Schedule> delete(int id) {
        if (!scheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado no banco de dados.");
        }

        try {
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<List<DoctorsAvailable>> getDoctorsAvailableByDayOfWeek(String date) {
        try {
            List<DoctorsAvailable> doctorsAvailable = scheduleRepository.getDoctorsAvailableByDayOfWeek(date);
            return ResponseEntity.ok(doctorsAvailable);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<List<LocalTime>> getHoursAvailableByDayOfWeek(String date, int doctor_id) {
        try {
            DoctorSchedule doctorSchedule = doctorScheduleRepository.findDoctorScheduleByDayOfWeek(doctor_id, date); //horario de atendimento do médico
            List<Schedule> schedules = scheduleRepository.getSchedulesByDoctorIdAndDate(doctor_id, date); //consulta marcadas

            List<LocalTime> horasDisponiveis = new ArrayList<>();

            for (LocalTime initialHour = doctorSchedule.getStart_time_first_period(); initialHour.isBefore(doctorSchedule.getEnd_time_first_period()); initialHour = initialHour.plusMinutes(30)) {
                LocalTime finalInitialHour = initialHour;
                if (!schedules.stream().anyMatch(schedule -> schedule.getInitial_time().equals(finalInitialHour))) {
                    horasDisponiveis.add(initialHour);
                }
            }

            for (LocalTime initialHour = doctorSchedule.getStart_time_second_period(); initialHour.isBefore(doctorSchedule.getEnd_time_second_period()); initialHour = initialHour.plusMinutes(30)) {
                LocalTime finalInitialHour = initialHour;
                if (!schedules.stream().anyMatch(schedule -> schedule.getInitial_time().equals(finalInitialHour))) {
                    horasDisponiveis.add(initialHour);
                }
            }

            return ResponseEntity.ok(horasDisponiveis);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }


    }


    public interface DoctorsAvailable {
        int getId();

        String getName();
    }

}
