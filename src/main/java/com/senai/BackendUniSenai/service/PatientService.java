package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.Patient;
import com.senai.BackendUniSenai.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity<Optional<Patient>> findPatientById(int id) {
        try {
            Optional<Patient> patient = patientRepository.findById(id);

            if (patient.isPresent()) {
                return ResponseEntity.ok(patient);
            } throw new RuntimeException();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado no banco de dados. " + e);
        }
    }

    public ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    public ResponseEntity<Patient> add(Patient patient) {
        try {
            Patient savedPatient = patientRepository.saveAndFlush(patient);
            userService.add(savedPatient.getId(), savedPatient.getPassword(), 'p');
            return ResponseEntity.ok(savedPatient);
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Patient> update(int id, Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado no banco de dados.");
        }
        patient.setId(id);

        try {
            final Patient updatePatient = patientRepository.save(patient);
            return ResponseEntity.ok(updatePatient);
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public ResponseEntity<Patient> delete(int id){
        if (!patientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado no banco de dados.");
        }

        try {
            patientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
