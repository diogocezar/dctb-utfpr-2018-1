/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Controller;

import java.util.List;
import javax.swing.JOptionPane;
import pokemon.Class.Pokemon;
import pokemon.Model.DAO.PokemonDAO;
import pokemon.Model.Interfaces.InterfacePokemon;
import pokemon.Model.Table.PokemonTable;
import pokemon.View.View;

/**
 *
 * @author Danilo
 */
public class PokemonController {
    private final View panel;
    private final InterfacePokemon interfacePokemon;
    private List<Pokemon> list;

    public PokemonController(View panel) {
        this.panel = panel;
        interfacePokemon = new PokemonDAO();
        list = interfacePokemon.getAllPokemon();
    }
    
    public void insert(){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(panel.getjTextFieldName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getjTextFieldLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getjTextFieldHp().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getjTextFieldAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getjTextFieldAtk().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getjTextFieldDef().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getjTextFieldSpcAtk().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getjTextFieldSpcDef().getText()));
        interfacePokemon.insert(pokemon);
    }
    
    public void update(){
        Pokemon pokemon = new Pokemon();
        pokemon.setHp(Integer.parseInt(panel.getjTextFieldHp().getText()));
        pokemon.setName(panel.getjTextFieldName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getjTextFieldLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getjTextFieldHp().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getjTextFieldAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getjTextFieldAtk().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getjTextFieldDef().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getjTextFieldSpcAtk().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getjTextFieldSpcDef().getText()));
        pokemon.setId(Integer.parseInt(panel.getjTextFieldId().getText()));
        interfacePokemon.update(pokemon);
    } 
    
    public void delete(){
        if (panel.getjTextFieldId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getjTextFieldId().getText());
        interfacePokemon.delete(row);
    }
    
    public void getData(){
        if (panel.getjTextFieldId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um ID de pokemon para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(panel.getjTextFieldId().getText());
        interfacePokemon.getPokemon(id);
        this.filterTable(id);
    }
    
    public void reset(){
        panel.getjTextFieldName().setText("");
        panel.getjTextFieldLevel().setText("");
        panel.getjTextFieldHp().setText("");
        panel.getjTextFieldAgility().setText("");
        panel.getjTextFieldDef().setText("");
        panel.getjTextFieldAtk().setText("");
        panel.getjTextFieldSpcAtk().setText("");
        panel.getjTextFieldSpcDef().setText("");
        panel.getjTable1().clearSelection();
    }
    public  void getDataField(){
        int row = panel.getjTable1().getSelectedRow();
        if (row != -1){
            panel.getjTextFieldId().setText(String.valueOf(list.get(row).getId()));
            panel.getjTextFieldName().setText(list.get(row).getName());
        }
    }
      
    public void setTabel(){
        list = interfacePokemon.getAllPokemon();
        panel.getjTable1().setModel(new PokemonTable(list));
    }  
    
    public void filterTable(int id){
        list = interfacePokemon.getPokemon(id);
        panel.getjTable1().setModel(new PokemonTable(list));
    }
}
