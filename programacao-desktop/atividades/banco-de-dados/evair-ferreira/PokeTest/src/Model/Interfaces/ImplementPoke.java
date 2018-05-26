package Model.Interfaces;

import Model.Poke;
import java.util.List;

public interface ImplementPoke{
    
    public void insert(Poke course);
    
    public void update(Poke course);
    
    public void delete(int id);
    
    public List<Poke> getCourse(String name);
    
    public List<Poke> getAllCourse();
}