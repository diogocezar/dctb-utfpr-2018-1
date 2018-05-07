/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modal;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.GUIController;
import main.objects.transations.Service;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class UpdateServiceController implements Initializable {
    
    @FXML
    private TextField textFieldServiceName;
    @FXML
    private TextField textFieldValue;
    @FXML
    private ComboBox comboBoxState;
    @FXML
    private ComboBox comboBoxEmployee;
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
        textFieldValue.setText("56.41");
        textFieldValue.setDisable(true);
        beginDate.setDisable(true);
    }    
    
    @FXML
    private void update(){
        if(Validate.validateEmpty("Name", textFieldServiceName.getText())){
            Validate.validateAddressNumber(textFieldServiceName.getText());
        }
        LocalDate localdate = beginDate.getValue();
        Validate.validateEmpty("Data de início",localdate==null?"":localdate.toString());
        
        localdate = endDate.getValue();
        Validate.validateEmpty("Data de fim",localdate==null?"":localdate.toString());
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            Service serv= new Service(Integer.parseInt(textFieldServiceName.getText()));
            serv.setFinishDate(endDate.getValue());
            System.out.println(serv);
        }
    }
    
    public void setEdit() {
        //change labels and load data from object
        textFieldServiceName.setText("01324");
        textFieldValue.setText("1222200000.00");
        beginDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
    }
    
    @FXML
    public void closeModal() {
        GUIController.getInstance().closeModal();
    }
}
