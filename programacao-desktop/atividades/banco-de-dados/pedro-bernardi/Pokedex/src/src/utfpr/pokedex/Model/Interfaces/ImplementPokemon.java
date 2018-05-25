/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/
package src.utfpr.pokedex.Model.Interfaces;

import java.util.List;
import src.utfpr.pokedex.Model.Pokemon;

public interface ImplementPokemon {

    public void insert(Pokemon pokemon);

    public void update(Pokemon pokemon);

    public void delete(int id);

    public void create();

    public List<Pokemon> getPokemon(String name);

    public List<Pokemon> getAllPokemon();
}
