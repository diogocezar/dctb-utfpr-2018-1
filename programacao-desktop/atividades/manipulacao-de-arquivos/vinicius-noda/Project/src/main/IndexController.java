/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author ecaanchesjr
 */
public class IndexController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void showMainAction(ActionEvent evt) {
        Button btn = (Button) (evt.getSource());
        String actionType;

        if (btn.getText().equals("VENDA")) {
            actionType = "Venda";
        } else {
            actionType = "Compra";
        }

        GUIController.getInstance().showMainActionScreen(actionType, false);
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

    @FXML
    private void showAboutInformationAlert() {
        GUIController.getInstance().showAboutInformationAlert();
    }

}
