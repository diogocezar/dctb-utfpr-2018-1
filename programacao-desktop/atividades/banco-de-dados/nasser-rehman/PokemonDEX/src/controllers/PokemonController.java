/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import app.Main;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import models.DAO.PokemonDAO;
import models.Pokemon;
import models.interfaces.ImplementPokemon;
import models.tables.TableModelPokemon;
import views.EditPanelForm;
import views.NewPanelForm;
import views.PokemonPanelForm;

/**
 *
 * @author nadook
 */
public class PokemonController {
    private final PokemonPanelForm panel;
    private final ImplementPokemon implementPokemon;
    private List<Pokemon> list;
    
    public PokemonController(PokemonPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
        list = implementPokemon.getAllPokemons();
    }
    
    public void delete() {
        int selected = panel.getTablePokemon().getSelectedRow();
        
        if (selected == -1) {
            JOptionPane.showMessageDialog(panel, "Nenhum registro foi selectionado!", null, JOptionPane.ERROR_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(panel, "Deseja excluir o Pokemon: "+panel.getTablePokemon().getValueAt(selected, 1), null, JOptionPane.OK_CANCEL_OPTION);
            
            if (option == JOptionPane.OK_OPTION) {
                implementPokemon.delete(Integer.parseInt(panel.getTablePokemon().getValueAt(selected, 0).toString()));
            }
        }
    }
    
    public void reset() {
        panel.getTablePokemon().clearSelection();
    }
    
    public void newPanelFormDisplay() {
        Main main = new Main();
        main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        main.setSize(352, 460);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.add(new NewPanelForm(this.panel, main));
        main.setVisible(true);
    }
    
    public void editPanelFormDisplay() {
        int verify = this.panel.getTablePokemon().getSelectedRow();
        if (verify == -1 ) {
            JOptionPane.showMessageDialog(this.panel, "Selecione algum Pokemon para poder alterar", null, JOptionPane.OK_OPTION);
        } else {           
            int rowcol = Integer.parseInt(this.panel.getTablePokemon().getValueAt(verify, 0).toString());
            Main main = new Main();
            main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            main.setSize(352, 460);
            main.setLocationRelativeTo(null);
            main.setResizable(false);   
            main.add(new EditPanelForm(this.panel, main, implementPokemon.getPokemonById(rowcol)));
            main.setVisible(true);
        }
        
    }
    
    public void setTable() {
        list = implementPokemon.getAllPokemons();
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }
    
    public void getData(){
        if (panel.getTxtSearch().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            this.setTable();
            return;
        }
        String name = panel.getTxtSearch().getText();
        implementPokemon.getPokemon(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementPokemon.getPokemon(name);
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }
}
