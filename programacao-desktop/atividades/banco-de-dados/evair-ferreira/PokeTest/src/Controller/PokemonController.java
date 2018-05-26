package Controller;

import Model.Poke;
import Model.DAO.PokeDAO;
import Model.Table.TabelModelPoke;
import View.PookePanelForm;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Interfaces.ImplementPoke;

public class PokemonController {
    private final PookePanelForm panel;
    private final ImplementPoke implementCourse;
    private List<Poke> list;
    
    public PokemonController(PookePanelForm panel) {
        this.panel = panel;
        implementCourse = new PokeDAO();
        list = implementCourse.getAllCourse();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelCourse().clearSelection();
    }
    
    public void setTabel(){
        list = implementCourse.getAllCourse();
        panel.getTabelCourse().setModel(new TabelModelPoke(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Poke course = new Poke();
        course.setName(panel.getTxtName().getText());
        implementCourse.insert(course);
    }

    public void update(){
        Poke course = new Poke();
        course.setId(Integer.parseInt(panel.getTxtId().getText()));
        course.setName(panel.getTxtName().getText());
        implementCourse.update(course);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Nada para exclusão.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCourse.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um Pokenome para a busca.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCourse.getCourse(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementCourse.getCourse(name);
        panel.getTabelCourse().setModel(new TabelModelPoke(list));
    }
}