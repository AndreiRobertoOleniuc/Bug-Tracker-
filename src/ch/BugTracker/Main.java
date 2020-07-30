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
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Andrei Oleniuc
 */
public class Main extends Application {
    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/ViewLogin.fxml"));
        Parent root;
        root = loader.load();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
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
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void startBugTracker() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/ViewUI.fxml"));
        Parent root;
        root = loader.load();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
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

    public void startLogin() throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login/ViewLogin.fxml"));
        Parent root;
        root = loader.load();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
        ViewLogin view = loader.getController();
        ModelLogin model = new ModelLogin();
        model.setMainApp(this);
        final ViewModelLogin viewModel = new ViewModelLogin(model);
        view.setVm(viewModel);
        model.addPropertyChangeListener(viewModel);

        view.bind();

        final Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    public void startAdd()throws IOException, SQLException, ClassNotFoundException{
        
    }
    public void startManageBugs()throws IOException, SQLException, ClassNotFoundException{
        
    }
    public void startManageWorker()throws IOException, SQLException, ClassNotFoundException{
        
    }
}
