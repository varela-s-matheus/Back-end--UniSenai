package com.senai.BackendUniSenai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "doctor_schedule")
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int doctor_id;

    private int day_of_week;

    private LocalTime start_time_first_period;

    private LocalTime end_time_first_period;

    private LocalTime start_time_second_period;

    private LocalTime end_time_second_period;
}
