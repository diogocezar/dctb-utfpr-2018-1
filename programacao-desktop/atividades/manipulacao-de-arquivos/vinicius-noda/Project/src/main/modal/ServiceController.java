/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.GUIController;
import main.objects.transations.Service;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class ServiceController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField valueTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void register(){
        if(Validate.validateEmpty("Name", nameTextField.getText())){
            Validate.validateName(nameTextField.getText());
        }
        if(Validate.validateEmpty("Valor",valueTextField.getText())){
            Validate.validateAddressNumber(valueTextField.getText());
        }
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            Service serv = new Service(nameTextField.getText(),
                    Float.parseFloat(valueTextField.getText()));
            System.out.println(serv);
        }
    }
    
    @FXML
    public void back() {
        GUIController.getInstance().closeModal();
    }
}
