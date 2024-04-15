package com.senai.BackendUniSenai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private char sex;
    private Date birth_date;
    private String cpf;
    private String rg;
    private String mother_name;
    private String social_name;
    private String phone;
    private String email;
    private String cep;
    private String address;
    private int number;
    private String neighborhood;
    private String city;
    private String province;
}
