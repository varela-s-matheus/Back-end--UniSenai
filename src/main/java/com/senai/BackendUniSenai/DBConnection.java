package com.senai.BackendUniSenai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Back-end--UniSenai";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin123";

    //mysql://avnadmin:AVNS_uTgu5hnEEUblC5UMwFT@mysql-3713c38-estudante-b32f.e.aivencloud.com:10268/defaultdb?ssl-mode=REQUIRED

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Driver do banco de dados não localizado.");

        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao acessar o banco: " + ex.getMessage());

        }
    }
}
