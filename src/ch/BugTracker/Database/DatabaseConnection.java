/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andrei Oleniuc
 */
public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String DB_CONNECTION_STRING = "jdbc:mysql://localhost/bugtracker";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private java.sql.Connection cn = null;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public java.sql.Connection createConnection() throws SQLException, ClassNotFoundException {
        if (cn == null) {
            Class.forName(DRIVER);
            cn = (java.sql.Connection) DriverManager.getConnection(DB_CONNECTION_STRING, USERNAME, PASSWORD);
        }
        return cn;
    }

    public void closeConnection() throws SQLException {
        cn.close();
        cn = null;
    }
}
