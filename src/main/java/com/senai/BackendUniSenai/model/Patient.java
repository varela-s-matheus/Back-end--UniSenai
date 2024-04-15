package com.senai.BackendUniSenai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    private int id;
    private String nome;
    private char sexo;
    private String data_nascimento;
    private String cpf;
    private String rg;
    private String nome_mae;
    private String nome_social;
    private String telefone;
    private String email;
    private String cep;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;

    public Patient() {
    }

    public Patient(int id, String nome, char sexo, String data_nascimento, String cpf, String rg, String nome_mae, String nome_social, String telefone, String email, String cep, int numero, String bairro, String cidade, String uf) {
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
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

}
