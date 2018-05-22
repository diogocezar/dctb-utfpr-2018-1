/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pokemon.ControllerMaster;
import pokemon.model.objects.Pokemon;

/**
 *
 * @author gabriel
 */
public class Register implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField level;
    @FXML
    private TextField hp;
    @FXML
    private TextField agility;
    @FXML
    private TextField attack;
    @FXML
    private TextField defense;
    @FXML
    private TextField specialAttack;
    @FXML
    private TextField specialDefense;

    @FXML
    private Button delete;
    
    String mode = "";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void save() {
        try {
            savePokemon();
        } catch (NumberFormatException e) {
            ControllerMaster.getInstance().displayErrorAlert("Verifique os dados digitados!");
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
            ControllerMaster.getInstance().displayErrorAlert("Pokemon já cadastrado!");
        }
        catch(Exception e){
            ControllerMaster.getInstance().displayErrorAlert("Falha ao conectar com banco de dados!");
        }
    }

    private void savePokemon() throws Exception {
        Pokemon pokemon = new Pokemon();
        pokemon.setAgility(Integer.parseInt(agility.getText()));
        pokemon.setAttack(Integer.parseInt(attack.getText()));
        pokemon.setDefense(Integer.parseInt(defense.getText()));
        pokemon.setHp(Integer.parseInt(hp.getText()));
        pokemon.setLevel(Integer.parseInt(level.getText()));
        pokemon.setName(name.getText());
        pokemon.setSpecialAttack(Integer.parseInt(specialAttack.getText()));
        pokemon.setSpecialDefense(Integer.parseInt(specialDefense.getText()));
        if(mode.equals("Register")){
            ControllerMaster.getInstance().getPokeDAO().insertPokemon(pokemon);
            ControllerMaster.getInstance().displayInformationAlert("Inserido com sucesso!");
        }else{
            ControllerMaster.getInstance().getPokeDAO().updatePokemon(
                    ControllerMaster.getInstance().getPokeAux().getName(),pokemon);
            ControllerMaster.getInstance().displayInformationAlert("Atualizado com sucesso!");
        }
    }

    @FXML
    private void cancel() {
        if(mode.equals("Register")){
            ControllerMaster.getInstance().openMain();
        }else{
            ControllerMaster.getInstance().getAuxStage().close();
        }
        
    }

    public void setRegister() {
        delete.setDisable(true);
        delete.setVisible(false);
        mode="Register";
    }

    public void setUpdate() {
        delete.setDisable(false);
        delete.setVisible(true);
        mode="Update";
        setData();
    }
    private void setData(){
        Pokemon aux;
        aux = ControllerMaster.getInstance().getPokeAux();
        name.setText(aux.getName());
        agility.setText(Integer.toString(aux.getAgility()));
        attack.setText((Integer.toString(aux.getAttack())));
        defense.setText(Integer.toString(aux.getDefense()));
        hp.setText(Integer.toString(aux.getHp()));
        level.setText(Integer.toString(aux.getLevel()));
        specialAttack.setText(Integer.toString(aux.getSpecialAttack()));
        specialDefense.setText(Integer.toString(aux.getSpecialDefense()));
        
    }

}
