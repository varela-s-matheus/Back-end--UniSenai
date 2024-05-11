package com.senai.BackendUniSenai.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @Transient
    private String email;

    public void addUser(int register_id, String password, char user_type) {
        this.setRegister_id(register_id);
        this.setPassword(password);
        this.setUser_type(user_type);
    }
}
