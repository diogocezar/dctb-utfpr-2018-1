/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Model.Interfaces;

import java.util.ArrayList;
import pokemonregister.Model.Pokemon;

/**
 *
 * @author ecsanchesjr
 */
public interface PokemonOperations {
    public boolean insert(Pokemon poke);
    public boolean update(Pokemon poke, String pokeName);
    public void delete(Pokemon poke);
    public Pokemon getPokemon(Pokemon poke);
    public ArrayList<Pokemon> getAllPokemons();
}
