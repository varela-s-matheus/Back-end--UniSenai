package com.senai.BackendUniSenai.controller;

import com.senai.BackendUniSenai.model.Schedule;
import com.senai.BackendUniSenai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Schedule>> findAllSchedules() {
        return scheduleService.findAllSchedules();
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
