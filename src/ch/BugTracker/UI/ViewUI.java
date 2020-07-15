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
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewUI implements Initializable {

    private ViewModelUI vm;
    private Commands sql = new Commands();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> sta = new ArrayList<>();
    private ArrayList<Date> date = new ArrayList<>();
    private ArrayList<String> progL = new ArrayList<>();
    private ArrayList<String> assignment = new ArrayList<>();
    private ObservableList<Bugs> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Bugs> tabelle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            updateData();
        } catch (SQLException ex) {
            Logger.getLogger(ViewUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTable();
        data();
    }

    public void bind() {

    }

    public void setViewModel(ViewModelUI vm) {
        this.vm = vm;
    }

    private void updateData() throws SQLException, ClassNotFoundException {
        sql.updateData();
    }

    private void createTable() {
        TableColumn<Bugs, String> name = new TableColumn<>("Name");
        name.setMinWidth(150);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Bugs, String> status = new TableColumn<>("Status");
        status.setMinWidth(150);
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        TableColumn<Bugs, Date> datum = new TableColumn<>("Datum");
        datum.setMinWidth(150);
        datum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        TableColumn<Bugs, String> proL = new TableColumn<>("ProgrammingLanguage");
        proL.setMinWidth(250);
        proL.setCellValueFactory(new PropertyValueFactory<>("programmingL"));
//            TableColumn<Bugs, String> assignment = new TableColumn<>("assignment");
//            assignment.setMinWidth(150);
//            assignment.setCellValueFactory(new PropertyValueFactory<>("Assignment"));
        tabelle.getColumns().addAll(name, status, datum, proL);
    }

    private void data() {
        for (int i = 0; i < sql.getAllBugs().size(); i++) {
            System.out.println(sql.getAllBugs().get(i).getIdBug());
            System.out.println(sql.getAllBugs().get(i).getName());
            System.out.println(sql.getAllBugs().get(i).getDatum());
            System.out.println(sql.getAllBugs().get(i).getProgrammingL());
            System.out.println(sql.getAllBugs().get(i).getStatus());

            names.add(sql.getAllBugs().get(i).getName());
            date.add(sql.getAllBugs().get(i).getDatum());
            progL.add(sql.getAllBugs().get(i).getProgrammingL());
            sta.add(sql.getAllBugs().get(i).getStatus());

            int id = sql.getAllBugs().get(i).getIdBug();
            ArrayList<Integer> c = new ArrayList<>();
            for (Administration a : sql.getAllAdmini()) {
                if (a.getIdBug() == id) {
                    c.add(a.getIdUser());
                }
            }
            String assig = "";
            for (Users u : sql.getAllUser()) {
                for (Integer h : c) {
                    if (h == u.getIdUser()) {
                        assig += u.getSurname();
                    }
                }
            }
            System.out.println(assig);
            assig += ", ";
            data.add(sql.getAllBugs().get(i));
        }
        tabelle.setItems(data);
    }
}
