/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Andrei Oleniuc
 */
public class Commands {

    private final DatabaseConnection jdbc = DatabaseConnection.getInstance();
    private ArrayList<Users> allUser = new ArrayList<>();
    private ArrayList<Bugs> allBugs = new ArrayList<>();
    private ArrayList<Administration> allAdmini = new ArrayList<>();

    public void updateData() throws SQLException, ClassNotFoundException {
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs1 = st.executeQuery("Select * from user");
        while (rs1.next()) {
            int id = rs1.getInt(1);
            String prename = rs1.getString(2);
            String surname = rs1.getString(3);
            String email = rs1.getString(4);
            String password = rs1.getString(5);
            allUser.add(new Users(id, prename, surname, email, password));
        }
        conn.close();
        jdbc.closeConnection();
        updateBugs();
        updateAdministration();
    }

    public void updateBugs() throws SQLException, ClassNotFoundException {
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs2 = st.executeQuery("Select * from bugs");
        while (rs2.next()) {
            int id = rs2.getInt(1);
            String name = rs2.getString(2);
            String state = rs2.getString(3);
            Date datum = rs2.getDate(4);
            String language = rs2.getString(5);
            allBugs.add(new Bugs(id, name, state, datum, language));
            System.out.println(datum);
        }
        conn.close();
        jdbc.closeConnection();
    }

    public void updateAdministration() throws SQLException, ClassNotFoundException {
        Connection conn = jdbc.createConnection();
        Statement st = conn.createStatement();
        ResultSet rs2 = st.executeQuery("Select * from verwaltung");
        while (rs2.next()) {
            int id = rs2.getInt(1);
            int idUser = rs2.getInt(2);
            int idBug = rs2.getInt(3);
            allAdmini.add(new Administration(id, idUser, idBug));
        }
        conn.close();
        jdbc.closeConnection();
    }

    public ArrayList<Users> getAllUser() {
        return allUser;
    }

    public ArrayList<Bugs> getAllBugs() {
        return allBugs;
    }

    public ArrayList<Administration> getAllAdmini() {
        return allAdmini;
    }

    public void updateUserPass(int id, String password) throws SQLException, ClassNotFoundException {
        Map<Integer, Users> map = new HashMap<Integer, Users>();
        allUser.forEach((u) -> {
            map.put(u.getIdUser(), u);
        });
        if (map.containsKey(id)) {
            int idU = map.get(id).getIdUser();
            allUser.get(idU - 1).setPassword(password);
            Connection conn = jdbc.createConnection();
            Statement st = conn.createStatement();
            String change = "update user set password = " + password + " where idUser ='" + id + "';";
            st.execute(change);
            conn.close();
            jdbc.closeConnection();
        }
    }
    public boolean checkLogin(String email,String password){
        for(int i = 0; i<allUser.size();i++){
            if(email.equals(allUser.get(i).getEmail())){
                if(password.equals(allUser.get(i).getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

}
