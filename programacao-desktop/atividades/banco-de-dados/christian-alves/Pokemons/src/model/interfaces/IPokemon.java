package model.interfaces;

import model.Pokemon;
import java.util.List;

/**
 *
 * @author christian
 */
public interface IPokemon {
    
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(int id);
    
    public List<Pokemon> getPokemon(String name);
    
    public List<Pokemon> getAllPokemon();
    
}
