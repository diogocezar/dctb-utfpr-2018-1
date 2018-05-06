/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.register;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.GUIController;
import main.utils.Validate;

/**
 * FXML Controller class
 *
 * @author ecaanchesjr
 */
public class EmployeeRegisterController implements Initializable {

    private final String fileNameTXT = "trabalhoInd.txt";
    private final String fileNameJSON = "trabalhoInd.json";
    private final String fileNameBIN = "trabalhoInd.bin";
    private Employee newEmp;
    
    
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
    
    private boolean register(){
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
        Validate.validateEmpty("Rua", streetTextField.getText());
        Validate.validateEmpty("Bairro", districtTextField.getText());
        if(Validate.validateEmpty("Número", numberTextField.getText())){
            Validate.validateAddressNumber(numberTextField.getText());
        }
        
        String errorMsg = Validate.getErrorMessage();
        GUIController.getInstance().showInformationAlert(errorMsg);
        if(errorMsg.isEmpty()){
            newEmp = new Employee(nameTextField.getText(), RGTextField.getText(), CPFTextField.getText(),
                                telTextField.getText(), streetTextField.getText(), Integer.parseInt(numberTextField.getText()), 
                                districtTextField.getText(), City.getValue(), State.getValue());
            System.out.println(newEmp);
            
            return(true);
        } else {
            return (false);
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
    
    /* Trabalho individual */
    private void writeFile(String file, String text) {
        if (new File(file).exists()) {
            new File(file).delete();
        }
        try {
            FileWriter w;
            w = new FileWriter(file);
            w.write(text);
            w.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro : " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("Erro : " + e.getMessage());
        }
    }
    
        private String loadFile(String file) {
        try {
            FileReader r;
            r = new FileReader(file);
            BufferedReader in = new BufferedReader(r);
            String buffer = in.readLine();
            String all = "";
            while (buffer != null) {
                all += buffer;
                buffer = in.readLine();
            }
            return all;
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }
        
    private void setData(Employee emp) {
        nameTextField.setText(emp.getName());
        RGTextField.setText(emp.getRg());
        CPFTextField.setText(emp.getCpf());
        streetTextField.setText(emp.getStreet());
        districtTextField.setText(emp.getDistrict());;
        City.setValue(emp.getCity());
        State.setValue(emp.getState());
        numberTextField.setText(Integer.toString(emp.getHouseNumber()));
        telTextField.setText(emp.getPhone());
    }
    
    @FXML
    private void saveTxt() {
        if(register()) {           
            writeFile(fileNameTXT, newEmp.toString());
        }   
    }
    
    @FXML
    private void saveJson() {
        if(register()) {
            writeFile(fileNameJSON, new Gson().toJson(newEmp, Employee.class));
        }
    }
    
    @FXML 
    private void saveBin() {
        ObjectOutputStream obj;
        if(register()) {
            try {
                obj = new ObjectOutputStream(new FileOutputStream(fileNameBIN));
                obj.writeObject(newEmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML 
    private void recTxt() {
        String contents = loadFile(fileNameTXT);
        String[] fields = contents.split(",");
        
        for(String field : fields) {
            String[] keyValue = field.split("=");
            keyValue[0] = keyValue[0].replaceAll("\\s","");
            
            switch(keyValue[0]) {
                case "name":
                    nameTextField.setText(keyValue[1]);
                    break;
                case "rg":
                    RGTextField.setText(keyValue[1]);
                    break;
                case "cpf":
                    CPFTextField.setText(keyValue[1]);
                    break;
                case "phone":
                    telTextField.setText(keyValue[1]);
                    break;
                case "street":
                    streetTextField.setText(keyValue[1]);
                    break;
                case "houseNumber":
                    numberTextField.setText(keyValue[1]);
                    break;
                case "district":
                    districtTextField.setText(keyValue[1]);
                    break;
                case "city":
                    City.setValue(keyValue[1]);
                    break;
                case "state":
                    State.setValue(keyValue[1]);
                    break;
            }
        }
    }
    
    @FXML
    private void recJson() {
        String jsonContent = loadFile(fileNameJSON);
        Employee newEmp = new Gson().fromJson(jsonContent, Employee.class);
        setData(newEmp);
    }
    
    @FXML
    private void recBin() {
        ObjectInputStream obj = null;
        try {
            obj = new ObjectInputStream(new FileInputStream(fileNameBIN));
            Object empObject = obj.readObject();
            newEmp = (Employee) empObject;
        } catch (IOException e) {
        } catch (ClassNotFoundException ex) {
            System.out.println("Error");
        }
        if(newEmp != null) {
            setData(newEmp);
        }
    }
}
