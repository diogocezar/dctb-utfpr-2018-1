/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.PokemonDAO;
import Model.Interfaces.ImplementPokemon;
import Model.Pokemon;
import Model.Table.TableModelPokemon;
import View.cadPkmForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kamimuraf
 */
public class PokemonController {
    
    private final cadPkmForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(cadPkmForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        list = implementPokemon.getAllPokemon();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTxtLevel().setText("");
        panel.getTxtHp().setText("");
        panel.getTxtAgi().setText("");
        panel.getTxtAtk().setText("");
        panel.getTxtDef().setText("");
        panel.getTxtSpeAtk().setText("");
        panel.getTxtSpeDef().setText("");
        panel.getTablePkm().clearSelection();
    }
    
    public void setTabel(){
        list = implementPokemon.getAllPokemon();
        panel.getTablePkm().setModel(new TableModelPokemon(list));
    }
    
    public  void getDataField(){
        int row = panel.getTablePkm().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
            panel.getTxtLevel().setText(String.valueOf(list.get(row).getLevel()));
            panel.getTxtHp().setText(String.valueOf(list.get(row).getHp()));
            panel.getTxtAgi().setText(String.valueOf(list.get(row).getAgility()));
            panel.getTxtAtk().setText(String.valueOf(list.get(row).getAttack()));
            panel.getTxtDef().setText(String.valueOf(list.get(row).getDefense()));
            panel.getTxtSpeAtk().setText(String.valueOf(list.get(row).getSpecialAttack()));
            panel.getTxtSpeDef().setText(String.valueOf(list.get(row).getSpecialDefense()));
            panel.getTablePkm().clearSelection();
        }
    }
    
    public void insert(){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgi().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAtk().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDef().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpeAtk().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpeDef().getText()));
        implementPokemon.insert(pokemon);
    }

    public void update(){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(Integer.parseInt(panel.getTxtId().getText()));
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgi().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAtk().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDef().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpeAtk().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpeDef().getText()));
        implementPokemon.update(pokemon);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementPokemon.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementPokemon.getPokemon(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementPokemon.getPokemon(name);
        panel.getTablePkm().setModel(new TableModelPokemon(list));
    }
}
