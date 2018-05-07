/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.register;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import main.GUIController;
import main.objects.persons.Address;
import main.objects.persons.JuridicalPerson;
import main.objects.persons.LegalPerson;
import main.utils.Bin;
import main.utils.JSON;
import main.utils.Text;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author ecaanchesjr
 */
public class CustomerRegisterController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField RGTextField;
    @FXML
    private TextField CPFTextField;
    @FXML
    private TextField CNPJTextField;
    @FXML
    private TextField telTextField;
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
    private Group legalGroup;

    private int saveMethod = 0;
    private int loadMethod = 0;

    @FXML
    private ComboBox<String> City;

    @FXML
    private ComboBox<String> State;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> cities = FXCollections.observableArrayList();
        ObservableList<String> states = FXCollections.observableArrayList();
        cities.add("Cornélio Procópio");
        cities.add("Londrina");
        cities.add("São Paulo");

        states.add("Paraná");
        states.add("São Paulo");

        City.setItems(cities);
        State.setItems(states);

//        //TODO
//        personGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//                RadioButton radio = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
//                if (radio.getId().toString().equals("legal")) {
//                    CNPJTextField.setVisible(false);
//                    legalGroup.setVisible(true);
//                    personType = "legal";
//                } else {
//                    CNPJTextField.setVisible(true);
//                    legalGroup.setVisible(false);
//                    personType = "juridical";
//                }
//
//            }
//
//        });
    }

    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }

    @FXML
    public void register() {
        if (Validate.validateEmpty("Nome", nameTextField.getText())) {
            Validate.validateName(nameTextField.getText());
        }
        if (Validate.validateEmpty("RG", RGTextField.getText())) {
            //Validate.validateRG(RGTextField.getText());
        }
        if (Validate.validateEmpty("CPF", CPFTextField.getText())) {
            //Validate.validateCPF(CPFTextField.getText());
        }

        if (Validate.validateEmpty("Telefone", telTextField.getText())) {
            Validate.validateTelephone(telTextField.getText());
        }
        Validate.validateEmpty("Rua", streetTextField.getText());
        Validate.validateEmpty("Bairro", districtTextField.getText());
        if (Validate.validateEmpty("Número", numberTextField.getText())) {
            Validate.validateAddressNumber(numberTextField.getText());
        }

        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if (errorMsg.isEmpty()) {
            Address address = new Address(streetTextField.getText(),
                    Integer.parseInt(numberTextField.getText()), districtTextField.getText(),
                    City.getValue(), State.getValue());
            ArrayList<String> telephones = new ArrayList<>();
            telephones.add(telTextField.getText());
            LegalPerson lp = new LegalPerson(RGTextField.getText(), nameTextField.getText(),
                    address, telephones, CPFTextField.getText());
            switch (saveMethod) {
                case (0): {
                    Text.save(lp.toString());
                    break;
                }
                case (1): {
                    JSON.save(lp);
                    break;
                }
                case (2): {
                    Bin.saveBin(lp);
                    break;
                }
            }
        }
    }

    public void setEdit() {
        nameTextField.setText("Placeholder name 1");
        RGTextField.setText("12.654.156-8");
        CPFTextField.setText("132.165.458-45");
        telTextField.setText("(43)98756-5498");
        streetTextField.setText("Placeholder street");
        numberTextField.setText("245");
        districtTextField.setText("District 13");

        mainLabel.setText("Detalhe de Cliente");
        actionBtn.setText("Salvar");
    }

    @FXML
    private void showMainActionM(ActionEvent evt) {
    }

    @FXML
    private void showGenericTransaction(ActionEvent evt) {
    }

    @FXML
    private void showServiceQuery() {
    }

    @FXML
    private void showBrandQuery() {
    }

    @FXML
    private void showStockQuery() {
    }

    @FXML
    private void showPersonQuery(ActionEvent evt) {
    }

    @FXML
    private void showSupplierQuery() {
    }

    @FXML
    private void showEmployeeRegister() {
    }

    @FXML
    private void showProductRegister() {
    }

    @FXML
    private void showSupplierRegister() {
    }

    @FXML
    private void showCustomerRegister() {
    }

    @FXML
    private void showModalRegisterBrand() {
    }

    @FXML
    private void showModalService() {
    }

    @FXML
    private void saveTxt() {
        saveMethod = 0;
        register();
    }

    @FXML
    private void saveJSON() {
        saveMethod = 1;
        register();
    }

    @FXML
    private void saveBin() {
        saveMethod = 2;
        register();
    }

    @FXML
    private void loadTxt() {
        LegalPerson p = Text.load();
        if( p != null){
            setFields(p);
        }
    }

    @FXML
    private void loadJSON() {
        LegalPerson p = JSON.load();
        if( p != null){
            setFields(p);
        }
    }

    @FXML
    private void loadBin() {
        LegalPerson p = Bin.loadBin();
        if (p != null) {
            setFields(p);
        }
    }

    private void setFields(LegalPerson p) {
        nameTextField.setText(p.getName());
        RGTextField.setText(p.getRG());
        CPFTextField.setText(p.getCPF());
        telTextField.setText(p.getTelephones().get(0));
        streetTextField.setText(p.getAddress().getStreet());
        numberTextField.setText(String.valueOf(p.getAddress().getNumber()));
        districtTextField.setText(p.getAddress().getBlock());
    }
}
