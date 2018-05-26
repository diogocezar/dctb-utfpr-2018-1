/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Interface.ImplementPokemon;
import Model.Pokemon;
import Model.Table.TablePokemon;
import ModelDAO.PokemonDAO;
import View.PokemonPanelForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz-
 */
public class PokemonController {
    private final PokemonPanelForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(PokemonPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        list = implementPokemon.getAllPokemon();  //chama todos os pokemons do banco usando o DAO
    }
    
    public void reset(){
        
        panel.getTxtName().setText("");
        panel.getTxtLevel().setText("");
        panel.getTxtHp().setText("");
        panel.getTxtAgility().setText("");
        panel.getTxtAttack().setText("");
        panel.getTxtDefense().setText("");
        panel.getTxtSpecialAttack().setText("");
        panel.getTxtSpecialDefense().setText("");
        panel.getTablePokemon().clearSelection();
    }
     public void setTable(){
        list = implementPokemon.getAllPokemon();
        panel.getTablePokemon().setModel(new TablePokemon(list));
    }
    
    public  void getDataField(){
        int row = panel.getTablePokemon().getSelectedRow();
        if (row != -1){
            
            panel.getTxtName().setText(list.get(row).getName());
            panel.getTxtLevel().setText(String.valueOf(list.get(row).getLevel()));
            panel.getTxtHp().setText(String.valueOf(list.get(row).getHp()));
            panel.getTxtAgility().setText(String.valueOf(list.get(row).getAgility()));
            panel.getTxtAttack().setText(String.valueOf(list.get(row).getAttack()));
            panel.getTxtDefense().setText(String.valueOf(list.get(row).getDefense()));
            panel.getTxtSpecialAttack().setText(String.valueOf(list.get(row).getSpecialAttack()));
            panel.getTxtSpecialDefense().setText(String.valueOf(list.get(row).getSpecialDefense()));
            
        }
    }
    
    public void insert(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Insira os dados do novo pokemon, incluindo seu nome.",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Pokemon pokemon = new Pokemon();
      
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        implementPokemon.insert(pokemon);
}

    public void update(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Escolha o pokemon que deverá ser atualizado.",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Pokemon pokemon = new Pokemon();
       
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        implementPokemon.update(pokemon);
    }
    public void delete(){
        
        //garante que um pokemon foi selecionado para a exclusão
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        implementPokemon.delete(panel.getTxtName().getText());
        
    }
    public void getData(){
        
        // garante que existe algum nome ou coisa do tipo para a busca
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de pokemon para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementPokemon.getPokemon(name);
        this.filterTable(name);
    }
     public void filterTable(String name){
        list = implementPokemon.getPokemon(name);
        panel.getTablePokemon().setModel(new TablePokemon(list));
    }
}
