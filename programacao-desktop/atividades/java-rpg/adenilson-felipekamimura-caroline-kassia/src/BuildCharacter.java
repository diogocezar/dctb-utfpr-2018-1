
import java.util.HashMap;
import jdk.nashorn.internal.codegen.CompilerConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caroline
 */
public class BuildCharacter {
    
    public HashMap<String, Hero> listHeroes(){
        HashMap<String, Hero> heroes = new HashMap<>();
        
        heroes.put("dark-glorysson", new Hero("Dark Glorysson", "Humano", 8, 100, 100, 10, 5, 10, 15, 2, 10));
        heroes.put("mellayne", new Hero("Mellayne", "Humano", 5, 100, 80, 25, 10, 8, 2, 20, 10));
        heroes.put("gryin", new Hero("Gryin", "Anão", 10, 100, 50, 30, 5, 10, 5, 1, 10));
       
        return heroes;
    }
    
    public HashMap<String, Monster> listMonsters(){
        HashMap<String, Monster> monsters = new HashMap<>();
        
        monsters.put("montaro", new Monster("Montaro", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10));
        monsters.put("lord-black", new Monster("Lord Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1));
        monsters.put("matilda", new Monster("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 5));
        
        return monsters;
    }
}