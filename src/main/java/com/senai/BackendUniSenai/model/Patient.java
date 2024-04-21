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

    @Column(length = 14)
    private String cpf;

    @Column(length = 9)
    private String rg;

    private String mother_name;

    private String social_name;

    @Column(length = 20)
    private String phone;

    private String email;

    @Column(length = 8)
    private String cep;

    private String address;

    private int number;

    private String neighborhood;

    private String city;

    @Column(length = 2)
    private String province;
}
