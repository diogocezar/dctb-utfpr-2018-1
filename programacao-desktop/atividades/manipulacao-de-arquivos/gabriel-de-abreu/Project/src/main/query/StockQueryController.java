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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.GUIController;
import main.objects.transations.Brand;
import main.objects.transations.Product;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class StockQueryController implements Initializable {
    @FXML
    TableView<Product> StockTable;
    @FXML
    TableColumn<Product,String> Name;
    @FXML
    TableColumn<Product,String> Brand;
    @FXML
    TableColumn<Product,Integer> Quantity;
    @FXML
    TableColumn<Product,String> BarCode;
    
    ObservableList<Product> products;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        products=FXCollections.observableArrayList();
        
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"Nvidia"));
        brands.add(new Brand(2,"Asus"));
        ArrayList<Brand> brands2 = new ArrayList<>();
        brands2.add(new Brand(2,"Asus"));
        
        Product p1= new Product("111",brands, 3, "Placa de video");
        products.add(p1);
        Product p2= new Product("222", brands2, 100, "Placa mãe");
        products.add(p2);
        
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("quantityInStock"));
        BarCode.setCellValueFactory(new PropertyValueFactory<>("barCode"));
        StockTable.setItems(products);
    }   
        
    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }
    
    @FXML
    private void detailsProduct(){
        GUIController.getInstance().showProductRegister(true);
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
