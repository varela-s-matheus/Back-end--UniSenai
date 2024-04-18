package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.DoctorSchedule;
import com.senai.BackendUniSenai.repository.DoctorScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorScheduleService {
    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public ResponseEntity<Optional<DoctorSchedule>> findDoctorScheduleById(int id) {
        try {
            Optional<DoctorSchedule> doctorSchedule = doctorScheduleRepository.findById(id);

            if (doctorSchedule.isPresent()) {
                return ResponseEntity.ok(doctorSchedule);
            } throw new RuntimeException();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados da agenda não encontrados no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<DoctorSchedule>> findAllDoctorSchedules() {
        return ResponseEntity.ok(doctorScheduleRepository.findAll());
    }

    public ResponseEntity<DoctorSchedule> add(DoctorSchedule doctorSchedule) {
        try {
            return ResponseEntity.ok(doctorScheduleRepository.saveAndFlush(doctorSchedule));
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<DoctorSchedule> update(int id, DoctorSchedule doctorSchedule) {
        if (!doctorScheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados da agenda não encontrados no banco de dados.");
        }
        doctorSchedule.setId(id);

        try {
            final DoctorSchedule updateDoctorSchedule = doctorScheduleRepository.save(doctorSchedule);
            return ResponseEntity.ok(updateDoctorSchedule);
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<DoctorSchedule> delete(int id){
        if (!doctorScheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dados da agenda não encontrados no banco de dados.");
        }

        try {
            doctorScheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
