package Model.DAO;

import Configurations.ConfigurationsMySQL;
import Model.Interfaces.ImplementCourse;
import DataBase.DataBaseGeneric;
import Model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAO extends DataBaseGeneric implements ImplementCourse{
    
    public ArrayList<Course> list;
    
    public CourseDAO(){
        super(new ConfigurationsMySQL(), "java_course");
    }
            
    @Override
    public void insert(Course course){
        Map<Object, Object> mapObj = new HashMap<>();
        mapObj.put("name", course.getName());
        this.genericInsert(mapObj);
    }

    @Override
    public void update(Course course){
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapObj.put("name", course.getName());
        mapConditions.put("id", course.getId());
        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("id", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Course> getCourseByName(String name){
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) { 
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex){
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse(){
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public Course getOneCourse(int id){
        ResultSet rs = this.getOne(id);
        Course course = new Course();
        try {
            course.setId(rs.getInt(1));
            course.setName(rs.getString("name"));
            return course;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo id: " + ex.getMessage());
        }
        return null;
    }
}
