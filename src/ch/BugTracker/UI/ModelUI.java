/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import ch.BugTracker.Database.Commands;
import ch.BugTracker.Main;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

/**
 *
 * @author Andrei Oleniuc
 */
public class ModelUI {
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private Main mainApp;    
    private Commands sql;
    public ModelUI() throws SQLException, ClassNotFoundException {
        sql = new Commands();
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
    
}
