/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Login;

import ch.BugTracker.Database.Commands;
import ch.BugTracker.Main;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Andrei Oleniuc
 */
public class ModelLogin {
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private Main mainApp;    
    private final Commands sql;
    boolean old= false;

    public ModelLogin() throws SQLException, ClassNotFoundException {
        sql = new Commands();
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
    public void setMainApp(Main mainApp) throws SQLException, ClassNotFoundException {
        this.mainApp = mainApp;
        sql.updateAdministration();
        sql.updateBugs();
        sql.updateData();
    }

    public void checkLogin(String email,String password){
        boolean check = sql.checkLogin(email, password);
        changes.firePropertyChange("check", old, check);
    }

    public void startBugtracker() throws IOException, SQLException, ClassNotFoundException {
        mainApp.startBugTracker();
    }
}
