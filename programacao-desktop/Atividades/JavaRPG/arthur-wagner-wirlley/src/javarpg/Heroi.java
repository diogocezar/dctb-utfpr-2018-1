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
     
     public Heroi (){}
     public Heroi(String name, String race, int level, int health, int magic, int strength, int agility, int dexterity, int inteligence, int charisma, int blessing){
         super(name, race, level, health, magic, strength, agility, dexterity, inteligence, charisma);
         this.blessing = blessing;
     }   
     //GET &SET
    public void setBlessing(int bless){
        this.blessing = bless;
    }
    public int getBlessing(){
        return this.blessing;
    }
     //Methods
    public int rest(){
        return (int)(((float)this.getHealth() + (float)this.getLevel()+ (float)this.blessing) * this.ladyLuck());
    }
    
     //toString
     public String toString(){
         return "\tHero: "+getName()+super.toString() + "Blessing: " + getBlessing()+"\n";
     }
     
}
