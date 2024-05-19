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

    @Column(name = "user_type")
    private char userType;

    @Column(name = "register_id")
    private int registerId;

    private String password;

    @JsonBackReference
    @Transient
    private String email;

    public void addUser(int register_id, String password, char user_type) {
        this.setRegisterId(register_id);
        this.setPassword(password);
        this.setUserType(user_type);
    }
}
