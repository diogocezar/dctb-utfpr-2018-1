/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Model.Interfaces;

import Model.Pokemon;
import java.util.List;

public interface ImplementPokemon{
    
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(int id);
    
    public List<Pokemon> getPokemon(String name);
    
    public List<Pokemon> getAllPokemon();
}