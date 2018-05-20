/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex.model.Interfaces;

import java.util.ArrayList;
import pokedex.Classes.Pokemon;

/**
 *
 * @author noda
 */
public interface PokemonOperations {
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(Pokemon pokemon);
    
    public Pokemon getPokemon(String name);
    
    public ArrayList<Pokemon> getAllPokemon();
}
