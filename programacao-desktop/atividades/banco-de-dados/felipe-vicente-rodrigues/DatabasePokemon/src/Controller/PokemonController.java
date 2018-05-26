/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.PokemonPanelForm;
import java.util.List;
import javax.swing.JOptionPane;
import model.DAO.PokemonDAO;
import model.Interfaces.ImplementPokemon;
import model.Pokemon;
import model.Table.TableModelPokemon;

/**
 *
 * @author felipe
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

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTablePokemon().clearSelection();
    }

    public void setTabel() {
        list = implementPokemon.getAllPokemons();
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }

    public void getDataField() {
        int row = panel.getTablePokemon().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }

    public void insert() {
        Pokemon course = new Pokemon();
        course.setName(panel.getTxtName().getText());
        implementPokemon.insert(course);
    }

    public void update() {
        Pokemon course = new Pokemon();
        course.setId(Integer.parseInt(panel.getTxtId().getText()));
        course.setName(panel.getTxtName().getText());
        implementPokemon.update(course);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementPokemon.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de Pokemon para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementPokemon.getPokemonByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementPokemon.getPokemonByName(name);
        panel.getTablePokemon().setModel(new TableModelPokemon(list));
    }

}
