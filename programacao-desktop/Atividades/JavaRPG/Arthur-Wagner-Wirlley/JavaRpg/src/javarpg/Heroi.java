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
public class Heroi extends Creature{
     private int blessing;
     
     //Constructor
     public Heroi(String name, String race, int level, int health, int magic, int strength, int agility, int dexterity, int inteligence, int charisma, int blessing){
         super(name, race, level, health, magic, strength, agility, dexterity, inteligence, charisma);
         this.blessing = blessing;
     }   
     //Methods
    public int rest(){
    }
     //toString
     public String toString(){
         return super.toString() + "\nBlessing: " + this.blessing;
     }
     
}
