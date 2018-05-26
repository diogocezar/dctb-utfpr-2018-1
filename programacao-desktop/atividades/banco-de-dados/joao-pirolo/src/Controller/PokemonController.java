/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Interface.ImplementPokemon;
import Model.Pokemon;
import Model.Table.TabelModelPokemon;
import ModelDAO.PokemonDao;
import View.PokemonPanelForm;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author JOAO
 */
public class PokemonController {
    private final PokemonPanelForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(PokemonPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDao();
        list = implementPokemon.getAllPokemon();
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
        panel.getTabelPokemon().clearSelection();
    }
     public void setTabel(){
        list = implementPokemon.getAllPokemon();
        panel.getTabelPokemon().setModel(new TabelModelPokemon(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelPokemon().getSelectedRow();
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
    Pokemon pokemon = new Pokemon();
       if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para cadastrar.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
       
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
        Pokemon pokemon = new Pokemon();
        
        pokemon.setName(panel.getTxtName().getText());
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
            
        }
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        if (panel.getTxtLevel().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
        }
        pokemon.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        if (panel.getTxtHp().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
        }
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        if (panel.getTxtAgility().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
        }
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        if (panel.getTxtAttack().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
        }
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        if (panel.getTxtDefense().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
        }
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        if (panel.getTxtSpecialAttack().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para atualizar.",null, JOptionPane.ERROR_MESSAGE);
           
        }
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
         if (panel.getTxtSpecialDefense().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "necessario preencher todos os campos",null, JOptionPane.ERROR_MESSAGE);
        }
        implementPokemon.update(pokemon);
    }
    public void delete(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        implementPokemon.delete(panel.getTxtName().getText());
        
    }
    public void getData(){
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
        panel.getTabelPokemon().setModel(new TabelModelPokemon(list));
    }
}
