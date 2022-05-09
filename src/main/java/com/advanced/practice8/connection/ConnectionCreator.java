package com.advanced.practice8.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCreator {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;
    static {
        try {
            properties.load(new FileReader("resources\\advanced\\database.properties"));
            String driverName = (String) properties.get("db.driver");
        } catch (IOException e) {
            e.printStackTrace(); // fatal exception
        }
        DATABASE_URL = (String) properties.get("db.url");
    }
    private ConnectionCreator() {}
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, properties);
    }

}
