/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Model.Interfaces;

import Model.Course;
import java.util.List;

public interface ImplementCourse{
    
    public void insert(Course course);
    
    public void update(Course course);
    
    public void delete(int id);
    
    public List<Course> getCourse(String name);
    
    public List<Course> getAllCourse();
}