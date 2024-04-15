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
    private String nome;
    private char sexo;
    private Date data_nascimento;
    private String cpf;
    private String rg;
    private String nome_mae;
    private String nome_social;
    private String telefone;
    private String email;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

    public Patient() {
    }

    public Patient(int id, String nome, char sexo, Date data_nascimento, String cpf, String rg, String nome_mae,
                   String nome_social, String telefone, String email, String cep, String endereco, int numero,
                   String bairro, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.nome_mae = nome_mae;
        this.nome_social = nome_social;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

}
