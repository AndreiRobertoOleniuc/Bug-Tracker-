/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.BugTracker;

import ch.BugTracker.Database.Commands;
import ch.BugTracker.Login.ModelLogin;
import ch.BugTracker.Login.ViewLogin;
import ch.BugTracker.Login.ViewModelLogin;
import ch.BugTracker.UI.ModelUI;
import ch.BugTracker.UI.ViewModelUI;
import ch.BugTracker.UI.ViewUI;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Andrei Oleniuc
 */
public class Main extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/ViewLogin.fxml"));
        Parent root;
        root = loader.load();

        ViewLogin view = loader.getController();
        ModelLogin model = new ModelLogin();
        model.setMainApp(this);
        final ViewModelLogin viewModel = new ViewModelLogin(model);
        view.setVm(viewModel);
        model.addPropertyChangeListener(viewModel);

        view.bind();

        final Scene scene = new Scene(root);
        this.stage = stage;
        stage.setTitle("Login");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void startBugTracker() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/ViewUI.fxml"));
        Parent root;
        root = loader.load();

        ViewUI view = loader.getController();
        ModelUI model = new ModelUI();
        model.setMain(this);
        final ViewModelUI viewModel = new ViewModelUI(model);
        view.setViewModel(viewModel);
        model.addPropertyChangeListener(viewModel);

        view.bind();

        final Scene scene = new Scene(root);
        stage.setTitle("Bug Tracker");
        stage.setScene(scene);
        stage.show();
    }
    
}
