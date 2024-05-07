package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.Doctor;
import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Schedule>> findScheduleById(@PathVariable int id) {
        return scheduleService.findScheduleById(id);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleService.ScheduleList>> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }

    @GetMapping("/get-doctors-availables/{date}")
    public ResponseEntity<List<ScheduleService.DoctorsAvailable>> getDoctorsAvailableByDayOfWeek(@PathVariable String date) {
        return scheduleService.getDoctorsAvailableByDayOfWeek(date);
    }

    @GetMapping("/get-hours-availables/{date}/{doctor_id}")
    public ResponseEntity<List<LocalTime>> getHoursAvailable(@PathVariable String date, @PathVariable int doctor_id) {
        return scheduleService.getHoursAvailableByDayOfWeek(date, doctor_id);
    }

    @PostMapping
    public ResponseEntity<Schedule> add(@RequestBody Schedule schedule) {
        return scheduleService.add(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable int id, @RequestBody Schedule schedule) {
        return scheduleService.update(id, schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> delete(@PathVariable int id) {
        return scheduleService.delete(id);
    }
}
