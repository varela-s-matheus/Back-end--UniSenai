package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.Patient;
import com.senai.BackendUniSenai.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable int id) {
        return ResponseEntity.ok(patientService.findPatientById(id));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @PostMapping
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.add(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> delete(@PathVariable int id) {
        return patientService.delete(id);
    }

}
