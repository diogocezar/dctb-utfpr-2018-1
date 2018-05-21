/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pokemonregister.Controller.PokemonHomeController;

/**
 *
 * @author ecsanchesjr
 */
public class PokemonRegister extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/PokemonHome.fxml"));
        Parent root = loader.load();
        
        PokemonHomeController homeController = (PokemonHomeController) loader.getController();
        homeController.setMainStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
//        Parent root = FXMLLoader.load(getClass().getResource("View/PokemonHome.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
