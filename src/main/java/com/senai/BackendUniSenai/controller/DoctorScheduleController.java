package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.Patient;
import com.senai.BackendUniSenai.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doctor-schedule")
public class DoctorScheduleController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> findPatientById(@PathVariable int id) {
        return patientService.findPatientById(id);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatients() {
        return patientService.findAllPatients();
    }

    @PostMapping
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        return patientService.add(patient);
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
