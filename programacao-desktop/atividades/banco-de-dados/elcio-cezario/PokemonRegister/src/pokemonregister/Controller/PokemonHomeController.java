/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pokemonregister.Controller.PokemonDisplayController.DisplayMode;
import pokemonregister.Model.DAO.PokemonDAO;
import pokemonregister.Model.Pokemon;

/**
 *
 * @author ecsanchesjr
 */
public class PokemonHomeController implements Initializable {
    private Stage stage;
    
    @FXML
    private TableView pokemonTable;
    @FXML
    private TableColumn pokemon;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pokemon.setCellValueFactory(new PropertyValueFactory<>("name"));
        loadPokemonsInTable();
        pokemonTable.setOnMousePressed(event -> {
            if(event.isPrimaryButtonDown() && event.getClickCount() == 2){
                try {
                    Node node = ((Node) event.getTarget()).getParent();
                    TableRow row;
                    if (node instanceof TableRow) {
                        row = (TableRow) node;
                    } else {
                        row = (TableRow) node.getParent();
                    }
                    Pokemon pokemon = (Pokemon) row.getItem();
                    showPokemonAction(pokemon);
                } catch (IOException ex) {
                    System.out.println("Show pokemon error\n"+ex.getMessage());
                }
            }
        });
    }

    private void loadPokemonsInTable() {
        pokemonTable.setItems(FXCollections.observableArrayList(new PokemonDAO().getAllPokemons()));
    }
    
    private void showPokemonAction(Pokemon poke) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("pokemonregister/View/PokemonDisplay.fxml"));
        Parent root = loader.load();
        
        PokemonDisplayController displayController = loader.getController();
        displayController.setScreenData(stage, DisplayMode.SHOW_POKEMON, poke);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
    @FXML
    private void addPokemonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("pokemonregister/View/PokemonDisplay.fxml"));
        Parent root = loader.load();
        
        PokemonDisplayController displayController = loader.getController();
        displayController.setScreenData(stage, DisplayMode.CREATE_POKEMON);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
    } 
    
    @FXML
    private void delPokemonAction() {
        Pokemon toDelete = (Pokemon) pokemonTable.getSelectionModel().getSelectedItem();
        if(toDelete != null) {
            Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDelete.setTitle("Confirmar operação.");
            confirmDelete.setHeaderText("Confirme a operação de deletar.");
            confirmDelete.setContentText("Deletar Pokemon: "+toDelete.getName()+"?");
            Optional<ButtonType> confirm = confirmDelete.showAndWait();
            if(confirm.get() == ButtonType.OK) {
                new PokemonDAO().delete(toDelete);
                loadPokemonsInTable();
            }
        }
    }
    
    public void setMainStage(Stage stage) {
        this.stage = stage;
    }
}
