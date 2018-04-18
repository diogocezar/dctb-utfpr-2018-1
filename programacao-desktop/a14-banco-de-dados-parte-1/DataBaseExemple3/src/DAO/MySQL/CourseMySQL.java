package DAO.MySQL;

import DAO.Interfaces.CourseDAO;
import Class.Course;
import java.util.ArrayList;

public class CourseMySQL implements CourseDAO {
    @Override
    public void create(String name){

    }
    
    @Override
    public Course findByName(String name){
        return new Course(1, name);
    }
    @Override
    public void update(long id, Course course) {
        
    }

    @Override
    public void delete(long id) {
        
    }

    @Override
    public ArrayList<Course> getAll() {
        return null;
    }
}
