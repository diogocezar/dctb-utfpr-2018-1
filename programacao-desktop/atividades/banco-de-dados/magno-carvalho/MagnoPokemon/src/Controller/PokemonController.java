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
import View.CoursePanelForm;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Magno Carvalho
 */
public class PokemonController {

    private final CoursePanelForm panel;
    private final ImplementPokemon implementCourse;
    private List<Pokemon> list;

    public PokemonController(CoursePanelForm panel) {
        this.panel = panel;
        implementCourse = new PokemonDAO();
        list = implementCourse.getAllCourse();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getAgildade().setText("");
        panel.getTxtAttack().setText("");
        panel.getTxtDefese().setText("");
        panel.getTxtLevel().setText("");
        panel.getTxtSeason().setText("");
        panel.getTxtSpecialAtack().setText("");
        panel.gethp().setText("");
        panel.getSpecialDefese().setText("");

        panel.getTabelCourse().clearSelection();
    }

    public void setTabel() {
        list = implementCourse.getAllCourse();
        panel.getTabelCourse().setModel(new TableModelPokemon(list));
    }

    public void getDataField() {
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
            panel.getAgildade().setText(String.valueOf(list.get(row).getAgility()));
            panel.getTxtAttack().setText(String.valueOf(list.get(row).getAttack()));
            panel.getTxtDefese().setText(String.valueOf(list.get(row).getDefese()));
            panel.getTxtLevel().setText(String.valueOf(list.get(row).getLevel()));
            panel.getTxtSeason().setText(String.valueOf(list.get(row).getSeason()));
            panel.getTxtSpecialAtack().setText(String.valueOf(list.get(row).getSpecialAttack()));
            panel.gethp().setText(String.valueOf(list.get(row).getHp()));
            panel.getSpecialDefese().setText(String.valueOf(list.get(row).getSpecialDefense()));
        }
    }

    public void insert() {
        Pokemon course = new Pokemon();
        course.setName(panel.getTxtName().getText());
        course.setAgility(Integer.parseInt(panel.getAgildade().getText()));
        course.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        course.setDefese(Integer.parseInt(panel.getTxtDefese().getText()));
        course.setHp(Integer.parseInt(panel.gethp().getText()));
        course.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        course.setSeason(Integer.parseInt(panel.getTxtSeason().getText()));
        course.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAtack().getText()));
        course.setSpecialDefense(Integer.parseInt(panel.getSpecialDefese().getText()));

        implementCourse.insert(course);
    }

    public void update() {
        Pokemon course = new Pokemon();
        course.setId(Integer.parseInt(panel.getTxtId().getText()));
        course.setName(panel.getTxtName().getText());
        course.setAgility(Integer.parseInt(panel.getAgildade().getText()));
        course.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        course.setDefese(Integer.parseInt(panel.getTxtDefese().getText()));
        course.setHp(Integer.parseInt(panel.gethp().getText()));
        course.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        course.setSeason(Integer.parseInt(panel.getTxtSeason().getText()));
        course.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAtack().getText()));
        course.setSpecialDefense(Integer.parseInt(panel.getSpecialDefese().getText()));
        implementCourse.update(course);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCourse.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de pokemon para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCourse.getCourseByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementCourse.getCourseByName(name);
        panel.getTabelCourse().setModel(new TableModelPokemon(list));
    }
}
