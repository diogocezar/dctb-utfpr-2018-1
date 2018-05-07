/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modal;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.GUIController;
import main.objects.transations.Service;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class AddServiceController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField valueTextField;
    @FXML
    private DatePicker beginDate;
    @FXML
    private DatePicker endDate;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //value from database
        valueTextField.setText("56.41");
        valueTextField.setDisable(true);
    }    
    
    @FXML
    private void addService(){
        if(Validate.validateEmpty("Name", nameTextField.getText())){
            Validate.validateAddressNumber(nameTextField.getText());
        }
        LocalDate localdate = beginDate.getValue();
        Validate.validateEmpty("Data de início",localdate==null?"":localdate.toString());
        
        localdate = endDate.getValue();
        Validate.validateEmpty("Data de fim",localdate==null?"":localdate.toString());
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            Service serv = new Service(beginDate.getValue(), endDate.getValue(),
            Integer.parseInt(nameTextField.getText()));
            System.out.println(serv);
        }
    }
    
    @FXML
    public void back() {
        GUIController.getInstance().closeModal();
    }
}
