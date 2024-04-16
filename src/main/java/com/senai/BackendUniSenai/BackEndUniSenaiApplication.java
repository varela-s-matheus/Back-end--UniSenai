package com.senai.BackendUniSenai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class BackEndUniSenaiApplication {

	public static void main(String[] args) throws SQLException {

		DBConnection connection = new DBConnection();
		connection.getConnection();

		SpringApplication.run(BackEndUniSenaiApplication.class, args);

	}
}
