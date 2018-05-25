/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interfaces;

import Model.Pokemon;
import java.util.List;

public interface ImplementPokemon {
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(int id);
    
    public List<Pokemon> getPokemon(String name);
 
    public List<Pokemon> getAllPokemon();
}
