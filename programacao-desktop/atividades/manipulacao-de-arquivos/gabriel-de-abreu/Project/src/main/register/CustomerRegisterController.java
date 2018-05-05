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
import javafx.stage.FileChooser;
import main.GUIController;
import main.objects.persons.Address;
import main.objects.persons.JuridicalPerson;
import main.objects.persons.LegalPerson;
import main.objects.persons.Person;
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
    private ToggleGroup personGroup;
    @FXML
    private Group legalGroup;

    private String personType = "legal";

    @FXML
    private ComboBox<String> City;

    @FXML
    private ComboBox<String> State;
    @FXML
    private RadioButton legal;
    @FXML
    private RadioButton Juridical;

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
        setEdit();
        // TODO
        personGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton radio = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                if (radio.getId().toString().equals("legal")) {
                    CNPJTextField.setVisible(false);
                    legalGroup.setVisible(true);
                    personType = "legal";
                } else {
                    CNPJTextField.setVisible(true);
                    legalGroup.setVisible(false);
                    personType = "juridical";
                }

            }

        });

    }

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

    private String getFilepath(String typeAllowed,String typeDescription) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(typeDescription,typeAllowed));
        return fc.showOpenDialog(null).getAbsolutePath();
    }

    private String loadFile(String typeAllowed,String typeDescription) {
        String file = getFilepath(typeAllowed,typeDescription);
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

    @FXML
    public void gravarTexto() {
        System.out.println("gravar texto");
        Person person = null;
        String content = "";
        Person genericPerson= register();
        try {
            LegalPerson lp = (LegalPerson) genericPerson;
            person = lp;
            content += lp.getCPF() + ";";
            content += lp.getRG() + ";";
        } catch (Exception e) {
            JuridicalPerson jp = (JuridicalPerson) genericPerson;
            person = jp;
            content += jp.getCNPJ() + ";";
        }
        if (person != null) {
            content += person.getName() + ";";
            content += person.getTelephones().get(0) + ";";
            content += person.getAddress().getBlock() + ";";
            content += person.getAddress().getCity() + ";";
            content += person.getAddress().getState() + ";";
            content += person.getAddress().getStreet() + ";";
            content += person.getAddress().getNumber() + ";";
        }
        writeFile(person.getName() + ".txt", content);
    }

    @FXML
    public void recuperarTexto() {
        String[] contents = loadFile("*.txt","Text Files").split(";");
        System.out.println(contents.length);
        if (contents.length == 9) {
            ArrayList<String> al = new ArrayList<>();
            al.add(contents[3]);
            Address address = new Address(contents[7], Integer.parseInt(contents[8]),
                    contents[4], contents[5], contents[6]);
            LegalPerson lp
                    = new LegalPerson(contents[1], contents[2], address,
                            al, contents[0]);
            RGTextField.setText(lp.getRG());
            CPFTextField.setText(lp.getCPF());
            setDataPerson(lp);
            legal.setSelected(true);
        } else {
            ArrayList<String> al = new ArrayList<>();
            al.add(contents[2]);
            Address address = new Address(contents[6], Integer.parseInt(contents[7]),
                    contents[3], contents[4], contents[5]);
            JuridicalPerson jp
                    = new JuridicalPerson(contents[1], address, al, contents[0]);
            CNPJTextField.setText(jp.getCNPJ());
            setDataPerson(jp);
            Juridical.setSelected(true);
        }

    }

    @FXML
    public void gravarJSON() {
        if (personType.equals("legal")) {
            writeFile(nameTextField.getText()+".json", new Gson().toJson(register(), LegalPerson.class));
        } else {
            writeFile(nameTextField.getText()+".json", new Gson().toJson(register(), JuridicalPerson.class));
        }
    }

    @FXML
    public void recuperarJSON() {
        String jsonString = loadFile("*.json","Json Files");
        Person person = null;
        try {
            LegalPerson lp = new Gson().fromJson(jsonString, LegalPerson.class);
            person = lp;
            CPFTextField.setText(lp.getCPF());
            RGTextField.setText(lp.getRG());
            if (lp.getRG() == null) {
                Juridical.setSelected(true);
            } else {
                legal.setSelected(true);
            }
        } catch (Exception e) {
            System.out.println("erro do json");

        }
        if (person != null) {
            setDataPerson(person);
        }
    }

    @FXML
    public void gravarBinario() {
        if (new File(nameTextField.getText() + ".bin").exists()) {
            new File(nameTextField.getText() + ".bin").delete();
        }

        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(new FileOutputStream(nameTextField.getText()+".bin"));
            out.writeObject(register());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void recuperarBinario() {
        ObjectInputStream in;
        Person person = null;
        try {
            in = new ObjectInputStream(new FileInputStream(getFilepath("*.bin","Binary Files")));
            Object genericPerson = in.readObject();
            try {
                LegalPerson lp = (LegalPerson) genericPerson;
                person = lp;
                CPFTextField.setText(lp.getCPF());
                RGTextField.setText(lp.getRG());
                legal.setSelected(true);
            } catch (Exception e) {
                JuridicalPerson jp = (JuridicalPerson) genericPerson;
                person = jp;
                CNPJTextField.setText(jp.getCNPJ());
                Juridical.setSelected(true);
            }
            if (person != null) {
                setDataPerson(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back() {
        GUIController.getInstance().backToPrevious();
    }

    public Person register() {
        Person person = null;
        if (Validate.validateEmpty("Nome", nameTextField.getText())) {
            Validate.validateName(nameTextField.getText());
        }
        if (((RadioButton) personGroup.getSelectedToggle()).getId().toString().equals("legal")) {
            if (Validate.validateEmpty("RG", RGTextField.getText())) {
                Validate.validateRG(RGTextField.getText());
            }
            if (Validate.validateEmpty("CPF", CPFTextField.getText())) {
                Validate.validateCPF(CPFTextField.getText());
            }
        } else {
            if (Validate.validateEmpty("CNPJ", CNPJTextField.getText())) {
                Validate.validateCNPJ(CNPJTextField.getText());
            }
        }
        if (Validate.validateEmpty("Telefone", telTextField.getText())) {
            Validate.validateTelephone(telTextField.getText());
        }
        if (!secTelTextField.getText().isEmpty()) {
            Validate.validateTelephone(secTelTextField.getText());
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
            if (!secTelTextField.getText().isEmpty()) {
                telephones.add(secTelTextField.getText());
            }
            if (personType.equals("legal")) {

                LegalPerson lp = new LegalPerson(RGTextField.getText(), nameTextField.getText(),
                        address, telephones, CPFTextField.getText());
                person = lp;
                //System.out.println(lp);
            } else {
                JuridicalPerson jp = new JuridicalPerson(nameTextField.getText(),
                        address, telephones, CNPJTextField.getText());
                person = jp;
                //System.out.println(jp);
            }
        }
        return (Person) person;
    }

    private void setDataPerson(Person person) {
        nameTextField.setText(person.getName());
        streetTextField.setText(person.getAddress().getStreet());
        districtTextField.setText(person.getAddress().getBlock());;
        City.setValue(person.getAddress().getCity());
        State.setValue(person.getAddress().getState());
        numberTextField.setText(Integer.toString(person.getAddress().getNumber()));
        telTextField.setText(person.getTelephones().get(0));
    }

    public void setEdit() {
        nameTextField.setText("Placeholder name 1");
        RGTextField.setText("12.654.156-8");
        CPFTextField.setText("132.165.458-45");
        telTextField.setText("43987565498");
        streetTextField.setText("Placeholder street");
        numberTextField.setText("245");
        districtTextField.setText("District 13");
        CNPJTextField.setText("00.000.000");
        mainLabel.setText("Detalhe de Cliente");
        State.setValue("São Paulo");
        City.setValue("São Paulo");
        //actionBtn.setText("Salvar");
    }
}
