/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pokemonregister.Model.DAO.PokemonDAO;
import pokemonregister.Model.Pokemon;

/**
 * FXML Controller class
 *
 * @author ecsanchesjr
 */
public class PokemonDisplayController implements Initializable {

    private Stage stage;
    private DisplayMode mode;
    private Pokemon pokemon;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField levelTextField;
    @FXML
    private TextField hpTextField;
    @FXML
    private TextField agiTextField;
    @FXML
    private TextField atkTextField;
    @FXML
    private TextField defTextField;
    @FXML
    private TextField espAtkTextField;
    @FXML
    private TextField espDefTextField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button btnPrimary;
    @FXML
    private Button btnSecondary;

    public enum DisplayMode {
        CREATE_POKEMON, SHOW_POKEMON;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setNumberFields();
    }

    private void controlDisplayModeCreate() {
        btnPrimary.setText("Adicionar");
        btnSecondary.setText("Limpar Campos");
        btnPrimary.setOnAction(e -> {
            action();
        });
        btnSecondary.setOnAction(e -> {
            clearFields();
        });
    }

    private void controlDisplayModeShow() {
        btnPrimary.setText("Alterar");
        btnSecondary.setVisible(false);
        toggleEditableFields(false);
        setPokemonData();
        btnPrimary.setOnAction((ActionEvent e) -> {
            if ("Alterar".equals(btnPrimary.getText())) {
                btnPrimary.setText("Salvar");
                toggleEditableFields(true);
            } else {
                action();
                toggleEditableFields(false);
                btnPrimary.setText("Alterar");
            }
        });
    }

    private void action() {
        if (checkFields()) {
            Pokemon newPoke = new Pokemon(nameTextField.getText(),
                    Integer.parseInt(levelTextField.getText()),
                    Integer.parseInt(hpTextField.getText()),
                    Integer.parseInt(agiTextField.getText()),
                    Integer.parseInt(atkTextField.getText()),
                    Integer.parseInt(defTextField.getText()),
                    Integer.parseInt(espAtkTextField.getText()),
                    Integer.parseInt(espDefTextField.getText()));
            errorLabel.setText("");
            switch (mode) {
                case CREATE_POKEMON:
                    addAction(newPoke);
                    break;

                case SHOW_POKEMON:
                    updateAction(newPoke);
                    break;
            }
        } else {
            errorLabel.setText("Existem campos vazios.");
        }
    }

    private void updateAction(Pokemon newPoke) {

        boolean success = new PokemonDAO().update(newPoke, pokemon.getName());

        Alert dialogInfo;
        if(success) {
            dialogInfo = new Alert(Alert.AlertType.CONFIRMATION);
            dialogInfo.setTitle("Operação de alteração.");
            dialogInfo.setHeaderText("Pokemon " + newPoke.getName() + "...");
            dialogInfo.setContentText("Foi alterado com sucesso!!!");
            dialogInfo.showAndWait();   
        } else {
            dialogInfo = new Alert(Alert.AlertType.ERROR);
            dialogInfo.setTitle("Operação de inserção.");
            dialogInfo.setHeaderText("Pokemon " + newPoke.getName() + "...");
            dialogInfo.setContentText("Não foi alterado!!!");
            dialogInfo.showAndWait();
        }

    }

    private void addAction(Pokemon newPoke) {

        boolean success = new PokemonDAO().insert(newPoke);

        Alert dialogInfo;
        if(success) {
            dialogInfo = new Alert(AlertType.INFORMATION);
            dialogInfo.setTitle("Operação de inserção.");
            dialogInfo.setHeaderText("Pokemon " + newPoke.getName() + "...");
            dialogInfo.setContentText("Foi adicionado!!!");
        } else {
            dialogInfo = new Alert(AlertType.ERROR);
            dialogInfo.setTitle("Operação de inserção.");
            dialogInfo.setHeaderText("Pokemon " + newPoke.getName() + "...");
            dialogInfo.setContentText("Não foi adicionado!!!");
        }
        dialogInfo.showAndWait();
    }

    @FXML
    private void cancelAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("pokemonregister/View/PokemonHome.fxml"));
        Parent root = loader.load();

        PokemonHomeController homeController = (PokemonHomeController) loader.getController();
        homeController.setMainStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void clearFields() {
        nameTextField.clear();
        levelTextField.clear();
        hpTextField.clear();
        agiTextField.clear();
        atkTextField.clear();
        defTextField.clear();
        espAtkTextField.clear();
        espDefTextField.clear();
        errorLabel.setText("");
    }

    private void setNumberTextField(TextField txt) {
        txt.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                txt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private boolean checkFields() {
        boolean name = nameTextField.getText().isEmpty();
        boolean level = levelTextField.getText().isEmpty();
        boolean hp = hpTextField.getText().isEmpty();
        boolean agi = agiTextField.getText().isEmpty();
        boolean atk = atkTextField.getText().isEmpty();
        boolean def = defTextField.getText().isEmpty();
        boolean espAtk = espAtkTextField.getText().isEmpty();
        boolean espDef = espDefTextField.getText().isEmpty();

        return !(name && level && hp && agi && atk && def && espAtk && espDef); // Exists empty fields
    }

    public void setScreenData(Stage stage, DisplayMode mode) {
        this.stage = stage;
        this.mode = mode;
        screenLoad();
    }

    public void setScreenData(Stage stage, DisplayMode mode, Pokemon pokemon) {
        this.stage = stage;
        this.mode = mode;
        this.pokemon = pokemon;
        screenLoad();
    }

    private void setNumberFields() {
        setNumberTextField(levelTextField);
        setNumberTextField(hpTextField);
        setNumberTextField(agiTextField);
        setNumberTextField(atkTextField);
        setNumberTextField(defTextField);
        setNumberTextField(espAtkTextField);
        setNumberTextField(espDefTextField);
    }

    private void toggleEditableFields(boolean edit) {
        nameTextField.setEditable(edit);
        levelTextField.setEditable(edit);
        hpTextField.setEditable(edit);
        agiTextField.setEditable(edit);
        atkTextField.setEditable(edit);
        defTextField.setEditable(edit);
        espAtkTextField.setEditable(edit);
        espDefTextField.setEditable(edit);
    }

    private void setPokemonData() {
        nameTextField.setText(pokemon.getName());
        levelTextField.setText("" + pokemon.getLevel());
        hpTextField.setText("" + pokemon.getHp());
        agiTextField.setText("" + pokemon.getAgility());
        atkTextField.setText("" + pokemon.getAttack());
        defTextField.setText("" + pokemon.getDefense());
        espAtkTextField.setText("" + pokemon.getSpecialAttack());
        espDefTextField.setText("" + pokemon.getSpecialDefense());
    }

    private void screenLoad() {
        switch (mode) {
            case CREATE_POKEMON: {
                controlDisplayModeCreate();
                break;
            }
            case SHOW_POKEMON: {
                controlDisplayModeShow();
                break;
            }
        }
    }
}
