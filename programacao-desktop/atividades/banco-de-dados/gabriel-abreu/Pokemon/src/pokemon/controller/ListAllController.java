/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pokemon.ControllerMaster;
import pokemon.model.objects.Pokemon;

/**
 * FXML Controller class
 *
 * @author gabriel
 */
public class ListAllController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Button select;
    @FXML
    private TableView<Pokemon> pokemons;
    @FXML
    private TableColumn<Pokemon, String> name;
    @FXML
    private TableColumn<Pokemon, Integer> level;
    @FXML
    private TableColumn<Pokemon, Integer> hp;
    @FXML
    private TableColumn<Pokemon, Integer> agility;
    @FXML
    private TableColumn<Pokemon, Integer> attack;
    @FXML
    private TableColumn<Pokemon, Integer> defense;
    @FXML
    private TableColumn<Pokemon, Integer> specialAttack;
    @FXML
    private TableColumn<Pokemon, Integer> specialDefense;

    ObservableList<Pokemon> pokemonsList;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadList();
        loadTable();
    }

    @FXML
    public void editPokemon() {
        Pokemon aux = pokemons.getSelectionModel().getSelectedItem();
        if (aux != null) {
            ControllerMaster.getInstance().setPokeAux(aux);
            ControllerMaster.getInstance().openEditPanel();
        } else {
            ControllerMaster.getInstance().displayInformationAlert("Nenhum Pokemon Selecionado!");
        }
    }

    public void setListMode() {
        title.setText("Todos os Pokemons");
        select.setDisable(true);
        select.setVisible(false);
    }

    public void setEditMode() {
        title.setText("Gerenciamento de Pokemons");
        select.setDisable(false);
        select.setVisible(true);
    }

    private void loadTable() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        level.setCellValueFactory(new PropertyValueFactory<>("level"));
        hp.setCellValueFactory(new PropertyValueFactory<>("hp"));
        agility.setCellValueFactory(new PropertyValueFactory<>("agility"));
        attack.setCellValueFactory(new PropertyValueFactory<>("attack"));
        defense.setCellValueFactory(new PropertyValueFactory<>("defense"));
        specialAttack.setCellValueFactory(new PropertyValueFactory<>("specialAttack"));
        specialDefense.setCellValueFactory(new PropertyValueFactory<>("specialDefense"));
        pokemons.setItems(pokemonsList);

    }

    private void loadList() {
        pokemonsList = FXCollections.observableArrayList();
        try {
            for (Pokemon el : ControllerMaster.getInstance().getPokeDAO().getALlPokemons()) {
                pokemonsList.add(el);
            }
        } catch (Exception e) {
            ControllerMaster.getInstance().displayErrorAlert("Falha ao conectar com o banco!");
        }
    }

    @FXML
    private void goBack() {
        ControllerMaster.getInstance().openMain();
        if (ControllerMaster.getInstance().getAuxStage() != null) {
            ControllerMaster.getInstance().getAuxStage().close();
        }
    }
}
