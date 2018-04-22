package Controller;

import Model.Course;
import Model.DAO.CourseDAO;
import Model.Interfaces.ImplementCourse;
import Model.Table.TabelModelCourse;
import View.CoursePanelForm;
import java.util.List;
import javax.swing.JOptionPane;

public class CourseController {
    private final CoursePanelForm panel;
    private final ImplementCourse implementCourse;
    private List<Course> list;
    
    public CourseController(CoursePanelForm panel) {
        this.panel = panel;
        implementCourse = new CourseDAO();
        list = implementCourse.getAllCourse();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        panel.getTabelCourse().clearSelection();
    }
    
    public void setTabel(){
        list = implementCourse.getAllCourse();
        panel.getTabelCourse().setModel(new TabelModelCourse(list));
    }
    
    public  void getDataField(){
        int row = panel.getTabelCourse().getSelectedRow();
        if (row != -1){
            panel.getTxtId().setText(String.valueOf(list.get(row).getId()));
            panel.getTxtName().setText(list.get(row).getName());
        }
    }
    
    public void insert(){
        Course course = new Course();
        course.setName(panel.getTxtName().getText());
        implementCourse.insert(course);
    }

    public void update(){
        Course course = new Course();
        course.setId(Integer.parseInt(panel.getTxtId().getText()));
        course.setName(panel.getTxtName().getText());
        implementCourse.update(course);
    }
    
    public void delete(){
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Sem dados para excluir.",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementCourse.delete(row);
    }
    
    public void getData(){
        if (panel.getTxtName().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Digite um nome de curso para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementCourse.getCourseByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name){
        list = implementCourse.getCourseByName(name);
        panel.getTabelCourse().setModel(new TabelModelCourse(list));
    }
}