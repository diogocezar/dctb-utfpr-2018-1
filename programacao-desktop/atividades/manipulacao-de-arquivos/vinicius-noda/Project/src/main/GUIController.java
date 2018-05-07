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
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.modal.BrandController;
import main.modal.UpdateServiceController;
import main.query.BrandQueryController;
import main.query.GenericTransactionQueryController;
import main.query.PersonQueryController;
import main.query.ServiceQueryController;
import main.query.StockQueryController;
import main.register.CustomerRegisterController;
import main.register.EmployeeRegisterController;
import main.register.ProductRegisterController;
import main.register.SupplierRegisterController;

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
            indexParent = FXMLLoader.load(getClass().getResource("register/CustomerRegister.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nowScene = new Scene(indexParent);
        
        executionStack.push(nowScene);
        
        mainStage.setScene(nowScene);
        mainStage.show();
    }
    
    public void showMainActionScreen(String actionType,boolean edit) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Template.fxml"));
            actionParent = loader.load();
            TemplateController controller = (TemplateController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(actionParent);
            controller.setActionType(actionType);
            controller.setInformation();
            if(edit){
                controller.setEdit();
            }
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showGenericTransationQuery(String transactionType) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/GenericTransactionQuery.fxml"));
            queryGenericTransaction = loader.load();
            GenericTransactionQueryController controller = (GenericTransactionQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(queryGenericTransaction);
            if(transactionType.contains("Consulta")){
                transactionType=transactionType.replace("Consulta", "");
            }            
            controller.setTransactionType(transactionType);
            controller.setInformation();
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showServiceQuery() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/ServiceQuery.fxml"));
            queryService = loader.load();
            ServiceQueryController controller = (ServiceQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(queryService);
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showBrandQuery() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/BrandQuery.fxml"));
            queryBrand = loader.load();
            BrandQueryController controller = (BrandQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(queryBrand);
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showStockQuery() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/StockQuery.fxml"));
            queryStock = loader.load();
            StockQueryController controller = (StockQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(queryStock);
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showPersonQuery(String personType) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/PersonQuery.fxml"));
            queryPerson = loader.load();
            PersonQueryController controller = (PersonQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(queryPerson);
            if(personType.contains("Consulta")){
                personType=personType.replace("Consulta", "");
            }         
            controller.setPersonType(personType);
            controller.setInformation();
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showSupplierQuery() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("query/SupplierQuery.fxml"));
            querySupplier = loader.load();
            //PersonQueryController controller = (PersonQueryController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(querySupplier);
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showCustomerRegister(boolean edit) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register/CustomerRegister.fxml"));
            registerCustomer = loader.load();
            CustomerRegisterController controller = (CustomerRegisterController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(registerCustomer);
            executionStack.push(nowScene);
            if(edit){
                controller.setEdit();
            } 
                
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showEmployeeRegister(boolean edit) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register/EmployeeRegister.fxml"));
            registerEmployee = loader.load();
            EmployeeRegisterController controller = (EmployeeRegisterController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(registerEmployee);
            if(edit){
                controller.setEdit();
            }
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showProductRegister(boolean edit) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register/ProductRegister.fxml"));
            registerProduct = loader.load();
            ProductRegisterController controller = (ProductRegisterController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(registerProduct);
            if(edit){
                controller.setEdit();
            }
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showSupplierRegister(boolean edit) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register/SupplierRegister.fxml"));
            registerSupplier = loader.load();
            SupplierRegisterController controller = (SupplierRegisterController) loader.getController();
            previousScene = nowScene;
            nowScene = new Scene(registerSupplier);
            if(edit) {
                controller.setEdit();
            }
            executionStack.push(nowScene);
            mainStage.setScene(nowScene);
            mainStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* MODALS */
    public void showModalService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/Service.fxml"));
            modalService = loader.load();
            //ServiceController controller = (ServiceController) loader.getController();
            modalScene = new Scene(modalService);
            modalStage.setScene(modalScene);
            
            
            
            modalStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showModalAddService(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/AddService.fxml"));
            modalService = loader.load();
            //ServiceController controller = (ServiceController) loader.getController();
            modalScene = new Scene(modalService);
            modalStage.setScene(modalScene);
            
            
            modalStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showModalUpdateService() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/UpdateService.fxml"));
            modalService = loader.load();
            UpdateServiceController controller = (UpdateServiceController) loader.getController();
            modalScene = new Scene(modalService);
            modalStage.setScene(modalScene);
            
            controller.setEdit();
            
            modalStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showModalAddProduct() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/AddProduct.fxml"));
            modalService = loader.load();
            //ServiceController controller = (ServiceController) loader.getController();
            modalScene = new Scene(modalService);
            modalStage.setScene(modalScene);
            
            modalStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showModalRegisterBrand() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/Brand.fxml"));
            modalRegisterBrand = loader.load();
            BrandController controller = (BrandController) loader.getController();
            modalScene = new Scene(modalRegisterBrand);
            modalStage.setScene(modalScene);

            controller.setAction("Registrar");
            controller.setContent();
            
            modalStage.show();
         } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void showModalAddBrand() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modal/Brand.fxml"));
            modalRegisterBrand = loader.load();
            BrandController controller = (BrandController) loader.getController();
            modalScene = new Scene(modalRegisterBrand);
            modalStage.setScene(modalScene);

            controller.setAction("Adicionar");
            controller.setContent();

            modalStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
