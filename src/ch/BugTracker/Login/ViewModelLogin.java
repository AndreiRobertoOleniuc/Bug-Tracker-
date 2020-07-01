/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Login;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelLogin implements PropertyChangeListener{
    private ModelLogin model;
    private BooleanProperty check= new SimpleBooleanProperty();
    public ViewModelLogin(ModelLogin model) {
        this.model = model;
    }
    public BooleanProperty getCheck() {
        return check;
    }
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch(pce.getPropertyName()){
            case "check":
                check.set((boolean)pce.getNewValue());
                break;
        }
    }
    
    public void checkPass(String email,String pass){
        model.checkLogin(email, pass);
    }

    public void startBugTracker() {
        model.startBugtracker();
    }
}
