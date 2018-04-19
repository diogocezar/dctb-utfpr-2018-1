/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Model.DAO;

import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import Model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements ImplementCourse{
    
    private List<Course> list;
    
    private final DataBase db = new DataBase(new ConfigurationsMySQL());
            
    @Override
    public void insert(Course course) {
        this.db.execute("INSERT INTO java_course (name) VALUES (?)", course.getName());
    }

    @Override
    public void update(Course course) {
        this.db.execute("UPDATE java_course SET name=? WHERE id=?", course.getName(), course.getId());
    }

    @Override
    public void delete(int id) {
        this.db.execute("DELETE FROM java_course WHERE id=?", id);
    }

    @Override
    public List<Course> getCourse(String name) {
        list = new ArrayList<Course>();
        try {
            ResultSet rs = this.db.query("SELECT * FROM java_course WHERE name LIKE '%" + name + "%'");
            while (rs.next()) { 
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString("name"));
                list.add(course);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um curso: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        list = new ArrayList<Course>();
        ResultSet rs = this.db.query("SELECT id, name FROM java_course ORDER BY id");
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
}
