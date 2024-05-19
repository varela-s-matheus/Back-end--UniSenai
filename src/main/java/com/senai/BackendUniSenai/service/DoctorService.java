package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.Doctor;
import com.senai.BackendUniSenai.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity<Optional<Doctor>> findDoctorById(int id) {
        try {
            Optional<Doctor> doctor = doctorRepository.findById(id);

            if (doctor.isPresent()) {
                return ResponseEntity.ok(doctor);
            }
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<Doctor>> findAllDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    public ResponseEntity<Doctor> add(Doctor doctor) {
        try {
            if (doctor.getPassword() != null) {
                Doctor savedDoctor = doctorRepository.saveAndFlush(doctor);
                userService.add(savedDoctor.getId(), savedDoctor.getPassword(), 'd');
                return ResponseEntity.ok(savedDoctor);
            }throw new RuntimeException("Senha não informada");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Doctor> update(int id, Doctor doctor) {
        if (!doctorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado no banco de dados.");
        }
        doctor.setId(id);

        try {
            final Doctor updateDoctor = doctorRepository.save(doctor);
            return ResponseEntity.ok(updateDoctor);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Doctor> delete(int id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado no banco de dados.");
        }

        try {
            userService.deleteByRegisterIdAndUserType(id, 'd');

            doctorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
