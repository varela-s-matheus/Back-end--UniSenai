package com.senai.BackendUniSenai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int doctor_id;

    private int patient_id;

    private Date schedule_date;

    private LocalTime initial_time;

    private LocalTime final_time;

    @Enumerated(EnumType.STRING)
    private ServiceType service_type;

    private boolean send_alert;
}
