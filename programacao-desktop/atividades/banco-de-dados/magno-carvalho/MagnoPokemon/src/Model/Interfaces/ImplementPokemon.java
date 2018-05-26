package Model.Interfaces;

import Model.Pokemon;
import java.util.List;

public interface ImplementPokemon{
    
    public void insert(Pokemon course);
    
    public void update(Pokemon course);
    
    public void delete(int id);
    
    public List<Pokemon> getCourseByName(String name);
    
    public List<Pokemon> getAllCourse();
    
    public Pokemon getOneCourse(int id);
}