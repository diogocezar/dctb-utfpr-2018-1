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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.GUIController;
import main.objects.persons.Address;
import main.objects.persons.Supplier;
import main.objects.transations.Brand;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class SupplierRegisterController implements Initializable {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField CNPJTextField;
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
    private TableView<Brand> brandTable;
    
    @FXML
    private TableColumn<Brand,String> Brands;
    
    @FXML
    private ComboBox<String> City;
    @FXML
    private ComboBox<String> State;
    
    ObservableList<Brand> brands;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        brands= FXCollections.observableArrayList();
        brands.add(new Brand(1,"Nvidia"));
        brands.add(new Brand(2,"AMD"));
        brands.add(new Brand(3,"Intel"));
        brands.add(new Brand(4,"Corsair"));
        brands.add(new Brand(5,"XFX"));
        
        Brands.setCellValueFactory(new PropertyValueFactory<>("name"));
        brandTable.setItems(brands);
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
    public void register(){
        if(Validate.validateEmpty("'Nome do Cliente'", nameTextField.getText())) {
            Validate.validateName(nameTextField.getText());
        }
        if(Validate.validateEmpty("'CNPJ'", CNPJTextField.getText())) {
            Validate.validateCNPJ(CNPJTextField.getText());
        }
        if(Validate.validateEmpty("'Telefone principal'", telTextField.getText())) {
            Validate.validateTelephone(telTextField.getText());
        }
        Validate.validateEmpty("'Rua'", streetTextField.getText());
        Validate.validateEmpty("'Bairro'", districtTextField.getText());
        if(Validate.validateEmpty("'Número da casa'", numberTextField.getText())) {
            Validate.validateAddressNumber(numberTextField.getText());   
        }
        Validate.emptyTable(brandTable);
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
             Address address = new Address(streetTextField.getText(),
                    Integer.parseInt(numberTextField.getText()), districtTextField.getText(),
                    City.getValue(), State.getValue());
            ArrayList<String> telephones = new ArrayList<>();
            telephones.add(telTextField.getText());
            if (!secTelTextField.getText().isEmpty()) {
                telephones.add(secTelTextField.getText());
            }
            ArrayList<Brand> avaliableBrands = new ArrayList<>();
            avaliableBrands.add(new Brand(1,"AMD"));
            Supplier supplier = new Supplier(avaliableBrands, nameTextField.getText(), address,
                    telephones, CNPJTextField.getText());
            System.out.println(supplier);
        }
    }
 
    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }
    
    @FXML
    private void createNewBrand() {
        GUIController.getInstance().showModalRegisterBrand();
    }
    
    @FXML
    private void addBrand() {
        GUIController.getInstance().showModalAddBrand();
    }
    
    public void setEdit(){
        nameTextField.setText("Placeholder name 1");
        telTextField.setText("(43)98756-5498");
        streetTextField.setText("Placeholder street");
        numberTextField.setText("245");
        districtTextField.setText("District 13");
        
        mainLabel.setText("Detalhes de Fornecedor");
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
    private void showEmployeeRegister() {
        GUIController.getInstance().showEmployeeRegister(false);
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
