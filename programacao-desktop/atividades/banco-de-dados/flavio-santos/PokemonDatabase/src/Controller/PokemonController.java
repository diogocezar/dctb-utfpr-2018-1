/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Controller;

import Model.Pokemon;
import Model.DAO.PokemonDAO;
import Model.Table.TabelModelPokemon;
import View.PokemonPanelForm;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Interfaces.ImplementPokemon;

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
        panel.getTxtName().setText("");
        panel.getTxtLevel().setText("");
        panel.getTxtHP().setText("");
        panel.getTxtAgility().setText("");
        panel.getTxtDefense().setText("");
        panel.getTxtAttack().setText("");
        panel.getTxtSpecAttack().setText("");
        panel.getTxtSpecDefense().setText("");
        panel.getTabelPokemon().clearSelection();
    }
    
    public void setTabel(){
        list = implementPokemon.getAllPokemon();
        panel.getTabelPokemon().setModel(new TabelModelPokemon(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelPokemon().getSelectedRow();
        if (row != -1){
            panel.getTxtID().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setHp(Integer.parseInt(panel.getTxtHP().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecDefense().getText()));
        implementPokemon.insert(pokemon);
    }

    public void update(){
        Pokemon pokemon = new Pokemon();
        pokemon.setHp(Integer.parseInt(panel.getTxtHP().getText()));
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecDefense().getText()));
        pokemon.setId(Integer.parseInt(panel.getTxtID().getText()));
        implementPokemon.update(pokemon);
    }
    
    public void delete(){
        if (panel.getTxtID().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtID().getText());
        implementPokemon.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtID().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um ID de pokemon para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(panel.getTxtID().getText());
        implementPokemon.getPokemon(id);
        this.filterTable(id);
    }

    public void filterTable(int id){
        list = implementPokemon.getPokemon(id);
        panel.getTabelPokemon().setModel(new TabelModelPokemon(list));
    }
}