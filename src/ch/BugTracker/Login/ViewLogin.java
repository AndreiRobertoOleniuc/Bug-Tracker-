/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.Login;

import ch.BugTracker.Database.Commands;
import ch.BugTracker.Main;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewLogin implements Initializable {
    private ViewModelLogin vm;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void bind(){
        
    }
    public void setVm(ViewModelLogin vm) throws SQLException, ClassNotFoundException {
        this.vm = vm;
    }

// Password vergleich Logik
//    Map<String, Talent> map = new HashMap<String, Talent>();
//
//for(Talent t : ListA)
//{
//    t.put(t.id, t);
//}
//
//for(Talent t : ListB)
//{
//    if(map.containsKey(t.id))
//    {
//        t.isSelected = true;
//    }
//} 
    
}
