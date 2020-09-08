/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import ch.BugTracker.Database.Administration;
import ch.BugTracker.Database.Commands;
import ch.BugTracker.Database.Users;
import ch.BugTracker.Database.Bugs;
import ch.BugTracker.Main;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrei Oleniuc
 */
public class ModelUI {
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private Main mainApp;    
    private Commands sql;
    private ArrayList<Users> allUser;
    private ArrayList<Bugs> allBugs;
    private ArrayList<Administration> allAdmini;
    private String oldData= "nichts";
    
    public ModelUI() throws SQLException, ClassNotFoundException {
        sql = new Commands();
        sql.updateData();
        allUser = sql.getAllUser();
        allBugs= sql.getAllBugs();
        allAdmini = sql.getAllAdmini();
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void signOut()throws IOException, SQLException, ClassNotFoundException {
        mainApp.startLogin();
    }

    public void max() throws IOException, SQLException, ClassNotFoundException {
        mainApp.setToMax();
    }    
    public void min() throws IOException, SQLException, ClassNotFoundException {
        mainApp.setToMin();
    }
}
