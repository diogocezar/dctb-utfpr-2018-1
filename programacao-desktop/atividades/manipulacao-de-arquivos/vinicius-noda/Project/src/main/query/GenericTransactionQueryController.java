/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.query;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
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
import javafx.scene.control.cell.PropertyValueFactory;
import main.GUIController;
import main.objects.transations.Brand;
import main.objects.transations.Movimentation;
import main.objects.transations.Product;

/**
 * FXML Controller class
 *
 * @author ecaanchesjr
 */
public class GenericTransactionQueryController implements Initializable {

    private String transactionType;
    @FXML
    private Label genericTransactionQueryTitle;
    @FXML
    private Button genericTransationQueryBtn;
    @FXML
    private TableView<Movimentation> MovimentationTable;
    @FXML
    private TableColumn<Movimentation,Integer> Code;
    @FXML
    private TableColumn<Movimentation,String> Description;
    @FXML
    private TableColumn<Movimentation,Float> Price;
    
    ObservableList<Movimentation> movs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movs= FXCollections.observableArrayList();
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"Nvidia"));
        ArrayList<Brand> brands2 = new ArrayList<>();
        brands2.add(new Brand(2,"Asus"));
        
        Product p1= new Product("111",brands , 3, "Placa de video");
        Product p2= new Product("222", brands2, 100, "Placa mãe");
        Movimentation m = new Movimentation(p1,"Compra",3,10);
        movs.add(m);
        
        Movimentation m2= new Movimentation(p2, "Venda", 5, 12);
        movs.add(m2);
        
        Code.setCellValueFactory(new PropertyValueFactory<>("id"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Product"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        MovimentationTable.setItems(movs);
    }

    public void setInformation() {
        genericTransactionQueryTitle.setText("Consulta de " + transactionType);
        genericTransationQueryBtn.setText("Cancelar " + transactionType);
    }
    
    @FXML
    private void details(){
        GUIController.getInstance().showMainActionScreen(transactionType, true);
    }

    public void setTransactionType(String transationType) {
        this.transactionType = transationType;
    }

    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
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
