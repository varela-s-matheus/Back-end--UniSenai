package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.DoctorSchedule;
import com.senai.BackendUniSenai.service.DoctorScheduleService;
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
    private DoctorScheduleService doctorScheduleService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoctorSchedule>> findDoctorScheduleById(@PathVariable int id) {
        return doctorScheduleService.findDoctorScheduleById(id);
    }

    @GetMapping
    public ResponseEntity<List<DoctorSchedule>> findAllDoctorSchedules() {
        return doctorScheduleService.findAllDoctorSchedules();
    }

    @PostMapping
    public ResponseEntity<DoctorSchedule> add(@RequestBody DoctorSchedule doctorSchedule) {
        return doctorScheduleService.add(doctorSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorSchedule> update(@PathVariable int id, @RequestBody DoctorSchedule doctorSchedule) {
        return doctorScheduleService.update(id, doctorSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DoctorSchedule> delete(@PathVariable int id) {
        return doctorScheduleService.delete(id);
    }
}
