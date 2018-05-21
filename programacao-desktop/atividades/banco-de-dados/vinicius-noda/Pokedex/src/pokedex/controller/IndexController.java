/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import pokedex.Classes.Pokemon;
import pokedex.model.DAO.PokemonDAOMySql;

/**
 *
 * @author noda
 */
public class IndexController implements Initializable {
    
    @FXML
    TableView mainTable;
    @FXML
    TableColumn TCName;
    @FXML
    Button create;
    
    @FXML
    Button delete;
    
    @FXML
    AnchorPane dynamic;
    
    DisplayController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TCName.setCellValueFactory(new PropertyValueFactory("name"));
        populateTable();
        mainTable.setOnMousePressed(event -> {
            if(event.isPrimaryButtonDown() && event.getClickCount() == 2){
                Node node = ((Node) event.getTarget()).getParent();
                TableRow row;
                if (node instanceof TableRow) {
                    row = (TableRow) node;
                } else {
                    row = (TableRow) node.getParent();
                }
                Pokemon pokemon = (Pokemon) row.getItem();
                callInfo(pokemon);
                }
        });
        callDefault();
        controller = null;
    }    
    
    public void populateTable(){
        PokemonDAOMySql dao = new PokemonDAOMySql();
        ArrayList<Pokemon> all = dao.getAllPokemon();
        mainTable.setItems(FXCollections.observableArrayList(all));
    }
    
    public void callDefault(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("pokedex/view/Default.fxml"));
            dynamic.getChildren().clear();
            dynamic.getChildren().add((AnchorPane)loader.load());
            controller = null;
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void callCreate(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("pokedex/view/Display.fxml"));
            dynamic.getChildren().clear();
            dynamic.getChildren().add((AnchorPane)loader.load());
            controller = loader.getController();
            controller.setDisplayMode();
            controller.setIndexController(this);
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void delete(){
        PokemonDAOMySql dao = new PokemonDAOMySql();
        Pokemon pokemon = (Pokemon) mainTable.getSelectionModel().getSelectedItem();
        if(pokemon != null){
            dao.delete(pokemon);
            populateTable();
            if(controller != null && controller.openPokemon() != null && controller.openPokemon().getName().equals(pokemon.getName())){
                callDefault();
            }
        }
    }
    
    public void callInfo(Pokemon pokemon){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("pokedex/view/Display.fxml"));
            dynamic.getChildren().clear();
            dynamic.getChildren().add((AnchorPane)loader.load());
            controller = loader.getController();
            controller.setDisplayMode(pokemon);
            controller.setIndexController(this);
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
