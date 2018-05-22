/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pokemon.controller.ListAllController;
import pokemon.controller.Register;
import pokemon.model.dao.DatabaseConnection;
import pokemon.model.dao.PokemonDAO;
import pokemon.model.dao.mysql.MySqlPokemonDao;
import pokemon.model.dao.mysql.MysqlDatabaseConnection;
import pokemon.model.objects.Pokemon;

/**
 *
 * @author gabriel
 */
public class ControllerMaster {

    private Stage masterStage;
    private Stage auxStage;
    private DatabaseConnection connection;
    private PokemonDAO pokeDAO;

    private Pokemon pokeAux;

    private ListAllController listController;
    
    public void openEditPanel() {
        LoadedScene ls = setScene("view/Register.fxml");
        openStage(auxStage,"Cadastro de pokemons", ls.scene);
        Register controller = (Register) ls.controller;
        controller.setUpdate();
    }

    public void openEdit() {
        LoadedScene ls = setScene("view/ListAll.fxml");
        openStage(masterStage,"Todos os Pokemons", ls.scene);
        listController = (ListAllController) ls.controller;
        listController.setEditMode();
    }

    public void openListAll() {
        LoadedScene ls = setScene("view/ListAll.fxml");
        openStage(masterStage,"Todos os Pokemons", ls.scene);
        listController = (ListAllController) ls.controller;
        listController.setListMode();
    }

    public void openRegister() {
        LoadedScene ls = setScene("view/Register.fxml");
        openStage(masterStage,"Cadastro de pokemons", ls.scene);
        Register controller = (Register) ls.controller;
        controller.setRegister();
    }

    public void openMain() {
        LoadedScene ls = setScene("view/Index.fxml");
        openStage(masterStage,"Pokedex", ls.scene);
    }

    public void startApp(Stage stage) {
        masterStage = stage;
        auxStage= new Stage();
        try {
            connection = new MysqlDatabaseConnection();
            connection.startConnection();
            pokeDAO = new MySqlPokemonDao();
            openMain();
        } catch (Exception e) {
            displayErrorAlert("Falha ao conectar com banco de dados!");
        }

    }

    public void displayErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void displayInformationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public ListAllController getListController() {
        return listController;
    }
    
    public DatabaseConnection getDatabaseConnection() {
        return connection;
    }

    public PokemonDAO getPokeDAO() {
        return pokeDAO;
    }

    public Pokemon getPokeAux() {
        return pokeAux;
    }

    public void setPokeAux(Pokemon pokeAux) {
        this.pokeAux = pokeAux;
    }

    public Stage getMasterStage() {
        return masterStage;
    }

    public Stage getAuxStage() {
        return auxStage;
    }
    private LoadedScene setScene(String location) {
        LoadedScene loadedScene = new LoadedScene();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(location));
            Parent root = (Parent) loader.load();
            Object controller = loader.getController();
            loadedScene.controller = controller;
            loadedScene.scene = new Scene(root);
        } catch (IOException e) {
            displayErrorAlert("Falha ao carregar recurso!");
        }
        return loadedScene;
    }

    private void openStage(Stage stage,String title, Scene scene) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private ControllerMaster() {
    }

    public static ControllerMaster getInstance() {
        return ControllerMasterHolder.INSTANCE;
    }

    private static class ControllerMasterHolder {

        private static final ControllerMaster INSTANCE = new ControllerMaster();
    }

    private class LoadedScene {

        Scene scene;
        Object controller;
    }
}
