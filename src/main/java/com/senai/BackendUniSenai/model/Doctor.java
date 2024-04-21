package com.senai.BackendUniSenai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private char sex;

    @Column(length = 6)
    private String crm_advice;

    @Column(length = 6)
    private String crm_number;

    @Column(length = 2)
    private String crm_province;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String phone;

    private String email;

    @Column(length = 10)
    private String cbo;
}
