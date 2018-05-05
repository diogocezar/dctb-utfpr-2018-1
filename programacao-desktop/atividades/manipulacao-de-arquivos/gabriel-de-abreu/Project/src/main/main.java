/*
 * To change this license header, choose License Headers in main Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.utils.Validate;

/**
 *
 * @author ecaanchesjr
 */
public class main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        GUIController.getInstance().startApp(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
