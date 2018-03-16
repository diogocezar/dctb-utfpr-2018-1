/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author arthu
 */
public class Monstro extends Creature {
    
    //Construtor
    public Monstro(String name, String race, int level, int health, int magic, int strength, int agility, int dexterity, int inteligence, int charisma){
         super(name, race, level, health, magic, strength, agility, dexterity, inteligence, charisma);
     }
    //Methods
    public int rest(){
        return (((int)((float)(this.getHealth() + (float)this.getLevel()) * this.ladyLuck())) > 100) ? 100 : ((int)(((float)this.getHealth() + (float)this.getLevel())* this.ladyLuck()));
    }    
}
