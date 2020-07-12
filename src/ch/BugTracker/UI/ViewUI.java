/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker.UI;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewUI implements Initializable {
    private ViewModelUI vm;
    @FXML
    private TableView<Bugs> tabelle;
    private ObservableList<Bugs> data = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data.add(new Bugs("HA Log","Open",new Date(21,02,2002),"Python","Andrei"));
        
        TableColumn<Bugs,String> name= new TableColumn<>("name");
        name.setMinWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        TableColumn<Bugs,String> status= new TableColumn<>("status");
        status.setMinWidth(100);
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        
        TableColumn<Bugs,Date> datum= new TableColumn<>("date");
        datum.setMinWidth(100);
        datum.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        
        TableColumn<Bugs,String> proL= new TableColumn<>("proL");
        proL.setMinWidth(100);
        proL.setCellValueFactory(new PropertyValueFactory<>("programmingLanguage"));
        
        TableColumn<Bugs,String> assignment= new TableColumn<>("assignment");
        assignment.setMinWidth(100);
        assignment.setCellValueFactory(new PropertyValueFactory<>("assignment"));
        
        tabelle.getColumns().addAll(name,status,datum,proL,assignment);
        tabelle.setItems(data);
    }    
    public void bind(){
        
    }
    public void setViewModel(ViewModelUI vm){
        this.vm = vm;
    }

    @FXML
    private void putdataIn(ActionEvent event) {
    }

}
