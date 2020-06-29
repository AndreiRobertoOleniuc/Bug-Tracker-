/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Database;

import java.sql.SQLException;

/**
 *
 * @author Andrei Oleniuc
 */
public class Users {
    private int idUser;
    private String prename;
    private String surname;
    private String email;
    private String password;
    
    public Users(int idUser, String prename, String surname, String email, String password) throws SQLException, ClassNotFoundException {
        this.idUser = idUser;
        this.prename = prename;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
