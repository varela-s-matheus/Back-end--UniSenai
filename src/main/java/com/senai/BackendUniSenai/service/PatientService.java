package com.senai.BackendUniSenai.service;

import com.senai.BackendUniSenai.model.Patient;
import com.senai.BackendUniSenai.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient findPatientById(int id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Hóspede não encontrado no banco de dados."
                ));
    }

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient add(Patient patient) {
        try {
            return patientRepository.saveAndFlush(patient);
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
