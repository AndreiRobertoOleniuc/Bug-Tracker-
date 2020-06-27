/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Login;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelLogin implements PropertyChangeListener{
    private ModelLogin model;

    public ViewModelLogin(ModelLogin model) {
        this.model = model;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }
    
}
