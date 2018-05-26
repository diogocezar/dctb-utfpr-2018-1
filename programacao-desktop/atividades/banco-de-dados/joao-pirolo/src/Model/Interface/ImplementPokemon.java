/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Interface;
import Model.Pokemon;
import java.util.List;
/**
 *
 * @author JOAO
 */
public interface ImplementPokemon {
 
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(String name);
    
    public List<Pokemon> getPokemon(String name);
    
    public List<Pokemon> getAllPokemon();
    

}

