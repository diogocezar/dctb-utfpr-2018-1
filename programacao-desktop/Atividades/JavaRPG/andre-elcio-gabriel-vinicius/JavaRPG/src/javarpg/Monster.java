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
    public void __call() {
        
    }

    @Override
    public int rest() {
        return (int) ( (this.getLife() + this.getLevel())* this.constantMultiplier() );
    }
    
}
