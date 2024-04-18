package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.repository.ScheduleRepository;
import com.senai.BackendUniSenai.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ResponseEntity<Optional<Schedule>> findScheduleById(int id) {
        try {
            Optional<Schedule> schedule = scheduleRepository.findById(id);

            if (schedule.isPresent()) {
                return ResponseEntity.ok(schedule);
            } throw new RuntimeException();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<Schedule>> findAllSchedules() {
        return ResponseEntity.ok(scheduleRepository.findAll());
    }

    public ResponseEntity<Schedule> add(Schedule schedule) {
        try {
            return ResponseEntity.ok(scheduleRepository.saveAndFlush(schedule));
        } catch(RuntimeException e) {
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
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Schedule> delete(int id){
        if (!scheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado no banco de dados.");
        }

        try {
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
