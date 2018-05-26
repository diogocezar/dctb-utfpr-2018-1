/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interfaces;

import java.util.ArrayList;
import models.Pokemon;

/**
 *
 * @author kassia
 */
public interface PokemonDAO {
    public void insert(Pokemon pokemon);
    
    public void update(Pokemon pokemon);
    
    public void delete(Pokemon pokemon);
    
    public Pokemon findByName(Pokemon pokemon);
    
    public ArrayList<Pokemon> getAll();
}
