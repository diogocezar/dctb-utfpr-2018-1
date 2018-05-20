/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pokedex.Classes.Pokemon;
import pokedex.DisplayMode;
import pokedex.model.DAO.PokemonDAOMySql;

/**
 * FXML Controller class
 *
 * @author noda
 */
public class DisplayController implements Initializable {

    @FXML
    Button btnPrimary;
    @FXML
    Button btnSecondary;

    @FXML
    Label mainLabel;

    @FXML
    TextField TFName;
    @FXML
    TextField TFLevel;
    @FXML
    TextField TFHP;
    @FXML
    TextField TFAgility;
    @FXML
    TextField TFAttack;
    @FXML
    TextField TFDefense;
    @FXML
    TextField TFSAttack;
    @FXML
    TextField TFSDefense;

    private DisplayMode mode;
    private Pokemon currentPokemon;
    private IndexController controller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setOnlyText(TFLevel);
        setOnlyText(TFHP);
        setOnlyText(TFAgility);
        setOnlyText(TFAttack);
        setOnlyText(TFDefense);
        setOnlyText(TFSAttack);
        setOnlyText(TFSDefense);
        currentPokemon = null;
    }

    public void setIndexController(IndexController index){
        this.controller = index;
    }
    
    public void setDisplayMode() {
        mode = DisplayMode.CREATE;
        changeToCreate();
    }

    public void setDisplayMode(Pokemon pokemon) {
        mode = DisplayMode.DISPLAY_INFO;
        currentPokemon = pokemon;
        changeToInfo();
    }

    private void changeToInfo() {
        mainLabel.setText("Attributes");
        btnPrimary.setText("Alter");
        btnSecondary.setText("Delete");
        TFName.setDisable(true);
        setAttributes();
    }

    private void changeToCreate() {
        mainLabel.setText("New Pokemon");
        btnPrimary.setText("Create");
        btnSecondary.setText("Clean");
    }

    private void setAttributes() {
        TFName.setText(currentPokemon.getName());
        TFLevel.setText(String.valueOf(currentPokemon.getLevel()));
        TFHP.setText(String.valueOf(currentPokemon.getHp()));
        TFAgility.setText(String.valueOf(currentPokemon.getAgility()));
        TFAttack.setText(String.valueOf(currentPokemon.getAttack()));
        TFDefense.setText(String.valueOf(currentPokemon.getDefense()));
        TFSAttack.setText(String.valueOf(currentPokemon.getSpecialAttack()));
        TFSDefense.setText(String.valueOf(currentPokemon.getSpecialDefense()));
    }

    private String validate() {
        String error = "";
        if (TFName.getText().isEmpty()) {
            error += "Name can't be empty\n";
        }
        error += checkNumericInput(TFLevel, "Level");
        error += checkNumericInput(TFHP, "HP");
        error += checkNumericInput(TFAgility, "Agility");
        error += checkNumericInput(TFAttack, "Attack");
        error += checkNumericInput(TFDefense, "Defense");
        error += checkNumericInput(TFSAttack, "Special attack");
        error += checkNumericInput(TFSDefense, "Special defense");
        return error;
    }

    private void setOnlyText(TextField t) {
        t.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                t.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private boolean isNumeric(String txt) {
        for (char c : txt.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private String checkNumericInput(TextField t, String name) {
        String error = "";
        if (t.getText().isEmpty()) {
            error += name + " can't be empty\n";
        } else if (!isNumeric(t.getText())) {
            error += name + " has to be a number\n";
        }
        return error;
    }
    
    private void clean(){
        TFName.setText("");
        TFLevel.setText("");
        TFHP.setText("");
        TFAgility.setText("");
        TFAttack.setText("");
        TFDefense.setText("");
        TFSAttack.setText("");
        TFSDefense.setText("");
    }
    
    public Pokemon openPokemon(){
        return currentPokemon;
    }

    @FXML
    public void primary() {
        PokemonDAOMySql dao = new PokemonDAOMySql();
        String error = validate();
        if (!error.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText(error);
            alert.showAndWait();
            return;
        }
        Pokemon newPokemon = new Pokemon(TFName.getText(),
                    Integer.parseInt(TFLevel.getText()),
                    Integer.parseInt(TFHP.getText()),
                    Integer.parseInt(TFAgility.getText()),
                    Integer.parseInt(TFAttack.getText()),
                    Integer.parseInt(TFDefense.getText()),
                    Integer.parseInt(TFSAttack.getText()),
                    Integer.parseInt(TFSDefense.getText()));
        if (mode == DisplayMode.CREATE) {
            if(dao.getPokemon(newPokemon.getName())==null){
                dao.insert(newPokemon);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Duplicate");
                alert.setHeaderText(null);
                alert.setContentText("Pokemon "+newPokemon.getName()+" already registered");
                alert.showAndWait();
                return;
            }
        } else if (mode == DisplayMode.DISPLAY_INFO) {
            dao.update(newPokemon);
        }
        
        controller.populateTable();
        //should have the same values of the altered pokemon
        controller.callInfo(dao.getPokemon(newPokemon.getName()));
    }

    @FXML
    public void secondary() {
        if (mode == DisplayMode.CREATE) {
            clean();
        } else if (mode == DisplayMode.DISPLAY_INFO) {
            PokemonDAOMySql dao = new PokemonDAOMySql();
            dao.delete(currentPokemon);
            controller.populateTable();
            controller.callDefault();
        }
    }
    
    @FXML
    public void cancel(){
        controller.callDefault();
    }
}
