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
    private String crm_advice;
    private String crm_number;
    private String crm_province;
    private String cpf;
    private String phone;
    private String email;
    private String cbo;
}
