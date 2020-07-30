/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import ch.BugTracker.Database.Bugs;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Andrei Oleniuc
 */
public class ViewModelUI implements PropertyChangeListener{
    private ModelUI model;
    private ArrayList<Bugs> bugs;
    public ViewModelUI(ModelUI model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch(pce.getPropertyName()){
            default:
                System.out.println("Nichts");
                break;
        }
    }

    public void signOut() throws IOException, SQLException, ClassNotFoundException {
        model.signOut();
    }
    
}
