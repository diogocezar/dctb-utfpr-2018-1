/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pokemon.ControllerMaster;

/**
 * FXML Controller class
 *
 * @author gabriel
 */
public class IndexController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControllerMaster.getInstance();
    }    
    @FXML
    private void openRegister(){
        ControllerMaster.getInstance().openRegister();
    }
    @FXML
    private void openManagement(){
         ControllerMaster.getInstance().openEdit();
    }
    @FXML
    private void openListAll(){
        ControllerMaster.getInstance().openListAll();
    }
    
}
