package com.senai.BackendUniSenai.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private char user_type;

    private int register_id;

    private String password;
}
