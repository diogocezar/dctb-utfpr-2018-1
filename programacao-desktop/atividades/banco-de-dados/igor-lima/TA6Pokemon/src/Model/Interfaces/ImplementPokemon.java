package Model.Interfaces;

/**
 *
 * @author igorv
 */

import Model.Pokemon;
import java.util.List;

public interface ImplementPokemon {
    
    public void insert(Pokemon pokemon);
       
    public void delete(int id);
    
    public List<Pokemon> getPokemon(String name);
    
    public List<Pokemon> getAllPokemon();

    public void updatePokemon(Pokemon poke);
    
}
