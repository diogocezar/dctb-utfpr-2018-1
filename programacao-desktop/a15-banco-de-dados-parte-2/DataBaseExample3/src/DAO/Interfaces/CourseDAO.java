package DAO.Interfaces;

import Class.Course;
import java.util.ArrayList;

public interface CourseDAO {
    public void insert(Course course);
    
    public void update(Course course);
    
    public void delete(Course course);
    
    public Course findByName(Course course);
    
    public ArrayList<Course> getAll();
}