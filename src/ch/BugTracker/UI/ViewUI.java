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
import com.jfoenix.controls.JFXButton;
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
    private TableView<Bugs> table2;
    @FXML
    private TableColumn<Bugs, String> nCL;
    @FXML
    private TableColumn<Bugs, Date> dCL;
    @FXML
    private TableColumn<Bugs, String> prLCL;
    @FXML
    private TableColumn<Bugs, String> stCL;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton addBugBtn;
    @FXML
    private JFXButton manageBugsBtn;
    @FXML
    private JFXButton manageWorkerBtn;
    @FXML
    private JFXButton signBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            updateData();
        } catch (SQLException ex) {
            Logger.getLogger(ViewUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        nCL.setCellValueFactory(new PropertyValueFactory<>("name"));
        dCL.setCellValueFactory(new PropertyValueFactory<>("datum"));
        prLCL.setCellValueFactory(new PropertyValueFactory<>("programmingL"));
        stCL.setCellValueFactory(new PropertyValueFactory<>("status"));
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
        table2.setItems(data);
    }
    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void sort(ActionEvent event) {
    }

    @FXML
    private void home(ActionEvent event) {
    }

    @FXML
    private void addBug(ActionEvent event) {
    }

    @FXML
    private void manageBugs(ActionEvent event) {
    }

    @FXML
    private void manageWorker(ActionEvent event) {
    }

    @FXML
    private void signOut(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        vm.signOut();
    }
    
    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(ActionEvent event) {
    }
}
