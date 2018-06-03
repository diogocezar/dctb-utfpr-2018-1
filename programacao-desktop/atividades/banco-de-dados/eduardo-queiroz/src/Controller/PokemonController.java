/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Controller;

import Model.Pokemon;
import Model.DAO.PokemonDAO;
import Model.Interfaces.ImplementPokemon;
import Model.Table.TabelModelPokemon;
import View.PokemonPanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class PokemonController {
    private final PokemonPanelForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(PokemonPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        list = implementPokemon.getAllPokemon();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelPokemon().clearSelection();
    }
    
    public void setTabel(){
        list = implementPokemon.getAllPokemon();
        panel.getTabelPokemon().setModel(new TabelModelPokemon(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelPokemon().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(panel.getTxtName().getText());
        implementPokemon.insert(pokemon);
    }

    public void update(){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(Integer.parseInt(panel.getTxtId().getText()));
        pokemon.setName(panel.getTxtName().getText());
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