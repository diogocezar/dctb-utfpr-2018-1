/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ecaanchesjr
 */
public class GUIController {
    private Stage mainStage;
    private Stage modalStage;
    
    private Parent indexParent;
    private Parent actionParent;
    private Parent queryService;
    private Parent queryGenericTransaction;
    private Parent queryPerson;
    private Parent queryBrand;
    private Parent queryStock;
    private Parent querySupplier;
    private Parent registerCustomer;
    private Parent registerEmployee;
    private Parent registerService;
    private Parent registerSupplier;
    private Parent registerProduct;
    private Parent modalService;
    private Parent modalAddService;
    private Parent modalAddProduct;
    private Parent modalRegisterService;
    private Parent modalRegisterBrand;
    private Parent modalUpdateService;
    
    private Scene nowScene;
    private Scene previousScene;
    private Scene modalScene;
    
    private Stack<Scene> executionStack;
    
    private GUIController() {
        executionStack = new Stack<>();
    }
    
    public static GUIController getInstance() {
        return GUIControllerHolder.INSTANCE;
    }
    
    private static class GUIControllerHolder {

        private static final GUIController INSTANCE = new GUIController();
    }
    
    public void startApp(Stage stage) {
        mainStage = stage;
        modalStage = new Stage();
        modalStage.initOwner(mainStage);
        modalStage.initModality(Modality.APPLICATION_MODAL);
        
        mainStage.setMinWidth(1280);
        mainStage.setMinHeight(720);
        
        try {
            indexParent = FXMLLoader.load(getClass().getResource("register/EmployeeRegister.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nowScene = new Scene(indexParent);
        
        executionStack.push(nowScene);
        
        mainStage.setScene(nowScene);
        mainStage.show();
    }
    
  
  
    public void showInformationEraseAlert() {
        Alert aboutInfo = new Alert(Alert.AlertType.CONFIRMATION);
        
        aboutInfo.setTitle("Operação de remoção");
        aboutInfo.setHeaderText("Remoção bem sucedida!");
        aboutInfo.setContentText("Operação de remoção concluída!");
        
        DialogPane diagPanel = aboutInfo.getDialogPane();
        diagPanel.getStylesheets().add(getClass().getResource("css/alert.css").toExternalForm());
        aboutInfo.showAndWait();
    }
    
    public void showInformationAlert(String msg) {
        Alert informationDiag;
        if(msg.isEmpty()) {
            informationDiag = new Alert(Alert.AlertType.CONFIRMATION);
            informationDiag.setTitle("Operação bem sucedida");
            informationDiag.setHeaderText("Confirmação de operação!");
            informationDiag.setContentText("Operação realizada com sucesso!");
        } else {
            informationDiag = new Alert(Alert.AlertType.ERROR);
            informationDiag.setTitle("Operação falhou");
            informationDiag.setHeaderText("Falha de operação");
            informationDiag.setContentText(msg);
        }
        DialogPane diagPanel = informationDiag.getDialogPane();
        diagPanel.getStylesheets().add(getClass().getResource("css/alert.css").toExternalForm());
        informationDiag.showAndWait();
    }
    
    public void showAboutInformationAlert() {
        Alert aboutInfo = new Alert(Alert.AlertType.INFORMATION);
        
        aboutInfo.setTitle("Sobre o Software");
        aboutInfo.setHeaderText("Sistema de Gerênciamento para Lojas de Informática.");
        aboutInfo.setContentText("Software desenvolvido como trabalho prático para a \ndiscíplina de Programação Desktop.\n");
        
        DialogPane diagPanel = aboutInfo.getDialogPane();
        diagPanel.getStylesheets().add(getClass().getResource("css/alert.css").toExternalForm());
        aboutInfo.showAndWait();
    }
        
    
    public void closeModal() {
        modalStage.close();
    }
    
    public void backToPrevious() {
        executionStack.pop();
        nowScene = executionStack.peek();
        mainStage.setScene(nowScene);
        mainStage.show();
    } 
}
