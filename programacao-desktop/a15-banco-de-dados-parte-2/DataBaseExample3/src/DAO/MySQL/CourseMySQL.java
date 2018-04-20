package DAO.MySQL;

import DAO.Interfaces.CourseDAO;
import Class.Course;
import Configurations.ConfigurationsMySQL;
import DataBase.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseMySQL implements CourseDAO {
    
    DataBase db;
    
    public CourseMySQL(){
        this.db = new DataBase(new ConfigurationsMySQL());
    }
    
    @Override
    public void insert(Course course){
        this.db.execute("INSERT INTO java_course (name) VALUES (?)", course.name);
    }
    
    @Override
    public Course findByName(Course course){
        ResultSet rs = this.db.query("SELECT id, name FROM java_course WHERE name LIKE %?%", course.name);
        try {
            return new Course(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
    @Override
    public void update(Course course) {
        this.db.execute("UPDATE java_course SET name=? WHERE id=?", course.name, course.id);
    }

    @Override
    public void delete(Course course) {
        this.db.execute("DELETE FROM java_course WHERE id=?", course.id);
    }

    @Override
    public ArrayList<Course> getAll() {
        ResultSet rs = this.db.query("SELECT id, name FROM java_course ORDER BY id");
        ArrayList<Course> result = new ArrayList<Course>();
        try {
            while(rs.next()){
                Course c = new Course(rs.getInt("id"), rs.getString("name"));
                result.add(c);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um curso pelo nome: " + ex.getMessage());
        }
        return null;
    }
}
