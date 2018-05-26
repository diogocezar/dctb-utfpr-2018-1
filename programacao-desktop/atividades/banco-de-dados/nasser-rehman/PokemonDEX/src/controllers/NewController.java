/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.DAO.PokemonDAO;
import models.Pokemon;
import models.interfaces.ImplementPokemon;
import views.NewPanelForm;
import views.PokemonPanelForm;

/**
 *
 * @author nadook
 */
public class NewController {
    private final NewPanelForm panel;
    private final ImplementPokemon implementPokemon;
    
    public NewController(NewPanelForm panel) {
        this.panel = panel;
        implementPokemon = new PokemonDAO();
    }

    
    public void insert() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(panel.getTxtName().getText());
        pokemon.setHp(Integer.parseInt(panel.getTxtHp().getText()));
        pokemon.setLevel(Integer.parseInt(panel.getTxtLevel().getText()));
        pokemon.setAgility(Integer.parseInt(panel.getTxtAgility().getText()));
        pokemon.setAttack(Integer.parseInt(panel.getTxtAttack().getText()));
        pokemon.setDefense(Integer.parseInt(panel.getTxtDefense().getText()));
        pokemon.setSpecialAttack(Integer.parseInt(panel.getTxtSpecialAttack().getText()));
        pokemon.setSpecialDefense(Integer.parseInt(panel.getTxtSpecialDefense().getText()));
        implementPokemon.insert(pokemon);
    }
}
