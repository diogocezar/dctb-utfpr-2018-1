package DAO.Interfaces;

import Class.Course;
import java.util.ArrayList;

public interface CourseDAO {
    public void create(String name);
    
    public void update(long id, Course course);
    
    public void delete(long id);
    
    public Course findByName(String name);
    
    public ArrayList<Course> getAll();
}