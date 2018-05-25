package Controller;

import Model.Pokemon;
import Model.DAO.PokemonDAO;
import Model.Interfaces.ImplementPokemon;
import Model.Table.TableModelPokemon;
import View.PokemonJPanelForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author igorv
 */
public class PokemonController {
    private final PokemonJPanelForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(PokemonJPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        list = implementPokemon.getAllPokemon();
    }

    public void reset(){
        panel.getTxtId().setText("");
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
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }

    public  void getDataField(){
        int row = panel.getTablePokemon().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
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
        Pokemon poke = new Pokemon();
        poke.setName(panel.getTxtName().getText());
        poke.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        poke.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        poke.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        poke.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        poke.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        poke.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        poke.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        implementPokemon.insert(poke);
    }

    public void update(){
        Pokemon poke = new Pokemon();
        poke.setId(Integer.parseInt(panel.getTxtId().getText()));
        poke.setName(panel.getTxtName().getText());
        poke.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        poke.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        poke.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        poke.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        poke.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        poke.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        poke.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        implementPokemon.updatePokemon(poke);
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
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }
}
