/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Login;

import ch.BugTracker.Main;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Andrei Oleniuc
 */
public class ModelLogin {
    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private Main mainApp;
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }    
}
