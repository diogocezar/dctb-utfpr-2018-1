/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.register;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.GUIController;
import main.objects.persons.Address;
import main.objects.persons.Employee;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author ecaanchesjr
 */
public class EmployeeRegisterController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField RGTextField;
    @FXML
    private TextField CPFTextField;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passwordFieldOficial;
    @FXML
    private PasswordField passwordFieldConfirm;
    @FXML
    private TextField telTextField;
    @FXML
    private TextField secTelTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private Label mainLabel;
    @FXML
    private Button actionBtn;
    @FXML
    private ComboBox<String> City;
    @FXML
    private ComboBox<String> State;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> cities = FXCollections.observableArrayList();
        ObservableList<String> states= FXCollections.observableArrayList();
        cities.add("Cornélio Procópio");
        cities.add("Londrina");
        cities.add("São Paulo");
        
        states.add("Paraná");
        states.add("São Paulo");
        
        City.setItems(cities);
        State.setItems(states);
    }    
    
    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }
    
    @FXML
    private void register(){
        if(Validate.validateEmpty("Nome", nameTextField.getText())){
            Validate.validateName(nameTextField.getText());
        }
        if(Validate.validateEmpty("RG", RGTextField.getText())){
            Validate.validateRG(RGTextField.getText());
        }
        if(Validate.validateEmpty("CPF", CPFTextField.getText())){
            Validate.validateCPF(CPFTextField.getText());
        }
        if(Validate.validateEmpty("Telefone", telTextField.getText())){
            Validate.validateTelephone(telTextField.getText());
        }
        if(!secTelTextField.getText().isEmpty()){
            Validate.validateTelephone(secTelTextField.getText());
        }
        Validate.validateEmpty("Rua", streetTextField.getText());
        Validate.validateEmpty("Bairro", districtTextField.getText());
        if(Validate.validateEmpty("Número", numberTextField.getText())){
            Validate.validateAddressNumber(numberTextField.getText());
        }
        
        if(Validate.validateEmpty("Usuário", userTextField.getText())){
            Validate.validateName(userTextField.getText());
        }
        if(Validate.validateEmpty("Senha", passwordFieldOficial.getText())){
            Validate.validatePassword(passwordFieldOficial.getText());
        }
        if(Validate.validateEmpty("Confirma senha", passwordFieldConfirm.getText())){
            Validate.validatePassword(passwordFieldConfirm.getText());
        }
        if(!passwordFieldOficial.getText().isEmpty() && !passwordFieldConfirm.getText().isEmpty()){
            Validate.passwordMatch(passwordFieldOficial.getText(), passwordFieldConfirm.getText());
        }
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            Address address = new Address(streetTextField.getText(), 
                    Integer.parseInt(numberTextField.getText())
                    ,districtTextField.getText(), City.getValue(), State.getValue());
            ArrayList<String> telephones= new ArrayList<>();
            telephones.add(telTextField.getText());
            if(!secTelTextField.getText().isEmpty()){
                telephones.add(secTelTextField.getText());
            }
            Employee employee = new Employee(userTextField.getText(),
                    passwordFieldOficial.getText(),
                    RGTextField.getText(), 
                    nameTextField.getText(), address, telephones, CPFTextField.getText());
            System.out.println(employee);
        }
    }
    
    public void setEdit(){
        nameTextField.setText("Placeholder name 1");
        RGTextField.setText("12.654.156-8");
        CPFTextField.setText("132.165.458-45");
        userTextField.setText("Placeholder username 1");
        passwordFieldOficial.setText("placeholder 1");
        passwordFieldConfirm.setText("placeholder 1");
        telTextField.setText("(43)98756-5498");
        streetTextField.setText("Placeholder street");
        numberTextField.setText("245");
        districtTextField.setText("District 13");
        
        mainLabel.setText("Detalhe de Funcionário");
        actionBtn.setText("Salvar");
    }
         @FXML
    private void showMainActionM(ActionEvent evt) {
        MenuItem btn = (MenuItem) (evt.getSource());
        String actionType;

        if (btn.getText().equals("Registro de Vendas")) {
            actionType = "Venda";
        } else {
            actionType = "Compra";
        }

        GUIController.getInstance().showMainActionScreen(actionType, false);
    }

    @FXML
    private void showGenericTransaction(ActionEvent evt) {
        MenuItem itemName = (MenuItem) (evt.getSource());

        GUIController.getInstance().showGenericTransationQuery(itemName.getText());
    }

    @FXML
    private void showServiceQuery() {
        GUIController.getInstance().showServiceQuery();
    }
    @FXML
    private void showEmployeeRegister() {
        GUIController.getInstance().showEmployeeRegister(false);
    }

    @FXML
    private void showBrandQuery() {
        GUIController.getInstance().showBrandQuery();
    }

    @FXML
    private void showStockQuery() {
        GUIController.getInstance().showStockQuery();
    }

    @FXML
    private void showPersonQuery(ActionEvent evt) {
        MenuItem itemName = (MenuItem) (evt.getSource());

        GUIController.getInstance().showPersonQuery(itemName.getText());
    }

    @FXML
    private void showSupplierQuery() {
        GUIController.getInstance().showSupplierQuery();
    }

    @FXML
    private void showCustomerRegister() {
        GUIController.getInstance().showCustomerRegister(false);
    }
    
    @FXML
    private void showProductRegister() {
        GUIController.getInstance().showProductRegister(false);
    }

    @FXML
    private void showSupplierRegister() {
        GUIController.getInstance().showSupplierRegister(false);
    }

    @FXML
    private void showModalRegisterBrand() {
        GUIController.getInstance().showModalRegisterBrand();
    }

    @FXML
    private void showModalService() {
        GUIController.getInstance().showModalService();
    }
}
