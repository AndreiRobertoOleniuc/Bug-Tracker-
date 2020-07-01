/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelUI implements PropertyChangeListener{
    private ModelUI model;

    public ViewModelUI(ModelUI model) {
        this.model = model;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }
    
}
