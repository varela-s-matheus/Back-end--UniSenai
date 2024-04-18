package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.Doctor;
import com.senai.BackendUniSenai.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> findDoctorById(@PathVariable int id) {
        return doctorService.findDoctorById(id);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {
        return doctorService.add(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable int id, @RequestBody Doctor doctor) {
        return doctorService.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> delete(@PathVariable int id) {
        return doctorService.delete(id);
    }
}
