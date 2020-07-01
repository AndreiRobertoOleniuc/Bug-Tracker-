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
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Andrei Oleniuc
 */
public class ViewLogin implements Initializable {

    private ViewModelLogin vm;
    private BooleanProperty check = new SimpleBooleanProperty();
    @FXML
    private PasswordField passTxt;
    @FXML
    private TextField emailTxt;
    String email;
    String password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void bind() {
        check.bind(vm.getCheck());
    }

    public void setVm(ViewModelLogin vm) throws SQLException, ClassNotFoundException {
        this.vm = vm;
    }

    @FXML
    private void login(ActionEvent event) {
        String AllowedChars = "[a-zA-Z0-9@.]*";
        boolean invalidChecker = false;
        //Check email for unallowed chars
        try {
            if (emailTxt.getText().matches(AllowedChars)) {
                email = emailTxt.getText();
                invalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Mail ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            invalidChecker = true;
        }

        try {
            if (passTxt.getText().matches(AllowedChars)) {
                password = passTxt.getText();
                invalidChecker = false;
            } else {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein Passwort ein!", "Fehler", JOptionPane.ERROR_MESSAGE);
                invalidChecker = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bitte verwenden Sie nur Buchstaben und Zahlen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            invalidChecker = true;
        }
        if (invalidChecker == false) {
            vm.checkPass(email, password);
            if (check.getValue() == true) {
                vm.startBugTracker();
            } else {
                System.out.println("Bitte geben sie es richtig ein");
            }
        }
    }
}
