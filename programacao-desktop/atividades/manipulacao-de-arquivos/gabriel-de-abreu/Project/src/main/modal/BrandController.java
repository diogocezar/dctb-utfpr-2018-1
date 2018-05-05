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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.GUIController;
import main.objects.transations.Brand;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class BrandController implements Initializable {
    String action;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label mainLabel;
    @FXML
    private Button actionBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void actionClick(){
        if(Validate.validateEmpty("Name", nameTextField.getText())){
            Validate.validateName(nameTextField.getText());
        }
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            Brand brand = new Brand(nameTextField.getText());
            System.out.println(brand);
        }
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public void setContent() {
        mainLabel.setText(action + " marca");
        actionBtn.setText(action);
    }
    
    @FXML
    public void back() {
        GUIController.getInstance().closeModal();
    }
}
