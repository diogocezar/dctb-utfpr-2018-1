/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.utils.TableProxyTransation;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class TemplateController implements Initializable {
    private String actionType;
    @FXML
    private Button registerBtnMainAction;
    @FXML
    private Button addProductBtn;
    @FXML
    private Button addServiceBtn;
    @FXML
    private Button deleteEntry;
    
    @FXML
    private Label mainActionScreenTitle;
    @FXML
    private Label FinalPrice;
    @FXML
    private TextField customerOrSupplier;
    
    @FXML
    private TableView<TableProxyTransation> Transations;
    @FXML
    private TableColumn<TableProxyTransation,String> Name;
    @FXML
    private TableColumn<TableProxyTransation,Float> Price;
    @FXML
    private TableColumn<TableProxyTransation,Integer> Quantity;
    
    ObservableList<TableProxyTransation> transations;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transations= FXCollections.observableArrayList();
        TableProxyTransation tbt = new TableProxyTransation();
        tbt.setName("Item 1");
        tbt.setPrice(200);
        tbt.setQuantity(3);
        transations.add(tbt);
        
        TableProxyTransation tbt2 = new TableProxyTransation();
        tbt2.setName("Item 2");
        tbt2.setPrice(250);
        tbt2.setQuantity(1);
        transations.add(tbt2);
        
        TableProxyTransation tbt3 = new TableProxyTransation();
        tbt3.setName("Item 3");
        tbt3.setPrice(1230);
        tbt3.setQuantity(1);
        transations.add(tbt3);
        
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Transations.setItems(transations);
        float totalvalue=0;
        for(TableProxyTransation tbtaux: transations){
            totalvalue+=tbtaux.getPrice();
        }
        FinalPrice.setText(Float.toString(totalvalue));
        
        setInformation();
    }    
    
    public void setInformation(){
        registerBtnMainAction.setText("Registrar "+actionType);
        mainActionScreenTitle.setText("Registrar "+actionType);
    }
    
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    
    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }
    
    @FXML
    public void register(){
        if(Validate.validateEmpty("Name", customerOrSupplier.getText())){
            Validate.validateName(customerOrSupplier.getText());
        }
        Validate.emptyTable(Transations);
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            
        }
    }
    
    public void setEdit(){
        mainActionScreenTitle.setText("Detalhes de "+actionType);
        
        registerBtnMainAction.setVisible(false);
        
        customerOrSupplier.setDisable(true);
        
        customerOrSupplier.setText("Custumer 01");
        
        addProductBtn.setVisible(false);
        addServiceBtn.setVisible(false);
        deleteEntry.setVisible(false);
    }
    
    @FXML
    public void showModalAddService() {
        GUIController.getInstance().showModalAddService();
    }
    
    @FXML
    public void showModalAddProduct() {
        GUIController.getInstance().showModalAddProduct();
    }
    
    @FXML
    public void deleteEntry() {
        
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
