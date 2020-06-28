/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrei Oleniuc
 */
public class Commands {
    private final DatabaseConnection jdbc = DatabaseConnection.getInstance();
    public void selectAll() throws SQLException, ClassNotFoundException{
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from user");
        while(rs.next()){
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("Vorname: " + rs.getString(2));
            System.out.println("Nachname: " + rs.getString(3));
            System.out.println("Email: " + rs.getString(4));
            System.out.println("Password: " + rs.getString(5));
        }
        conn.close();
        jdbc.closeConnection();
    }
}
