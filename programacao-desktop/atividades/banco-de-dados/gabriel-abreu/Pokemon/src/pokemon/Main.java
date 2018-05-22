/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author gabriel
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        ControllerMaster.getInstance().startApp(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
