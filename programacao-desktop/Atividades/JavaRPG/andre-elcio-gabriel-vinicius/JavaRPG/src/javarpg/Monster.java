/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author noda
 */
public class Monster extends Creature {
    
    public Monster(String name, String creature_class, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charisma) {
        super(name,creature_class,level,life,magic,strength,agility,dexterity,intelligence,charisma);
    }
    
    @Override
    public String  __toString() {
        String monsterInfos="";
        System.out.println("Name: " + this.getName());
        System.out.println("Class: " + this.getCreature_class());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Life: " + this.getLife() );
        System.out.println("Magic: "+ this.getMagic());
        System.out.println("Strenght: " + this.getStrength());
        System.out.println("Agility: " + this.getAgility());
        System.out.println("Dexterity: " + this.getDexterity());
        System.out.println("Intelligence: " + this.getIntelligence());
        System.out.println("Charisma: " + this.getCharisma());
        return monsterInfos;
    }

    @Override
    public void __call() {
        
    }

    @Override
    public int rest() {
        return (int) ( (this.getLife() + this.getLevel())* this.constantMultiplier() );
    }
    
}
