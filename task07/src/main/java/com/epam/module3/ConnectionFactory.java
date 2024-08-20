package com.epam.module3;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/file_share_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static ConnectionFactory instance;

    private ConnectionFactory() { }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
