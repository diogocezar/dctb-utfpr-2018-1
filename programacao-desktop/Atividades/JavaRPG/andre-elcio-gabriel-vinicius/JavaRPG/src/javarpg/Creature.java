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
public abstract class Creature implements Generic{
    private String name, creature_class;
    private int level, life, magic, strength, agility, dexterity, intelligence, charisma;

    public Creature(String name, String creature_class, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charisma) {
        this.name = name;
        this.creature_class = creature_class;
        this.setLevel(level);
        this.setLife(life);
        this.setMagic(magic);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setDexterity(dexterity);
        this.setIntelligence(intelligence);
        this.setCharisma(charisma);
    }
    
    // getters
    public String getName() {
        return name;
    }

    public String getCreature_class() {
        return creature_class;
    }

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getMagic() {
        return magic;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCreature_class(String creature_class) {
        this.creature_class = creature_class;
    }

    public void setLevel(int level) {
        if(level > 0 && level <= 10){   
            this.level = level;
        }
    }

    public void setLife(int life) {
        if(life > 0 && life <=100){    
            this.life = life;
        }
    }

    public void setMagic(int magic) {
        if(magic > 0 && magic <=100){      
            this.magic = magic;
        }
    }

    public void setStrength(int strength) {
        if(strength > 0 && strength <=32){
            this.strength = strength;
        }
    }

    public void setAgility(int agility) {
        if(agility > 0 && agility <= 12){
            this.agility = agility;
        }
    }

    public void setDexterity(int dexterity) {
        if(dexterity > 0 && dexterity <=16){
            this.dexterity = dexterity;
        }
    }

    public void setIntelligence(int intelligence) {
        if(intelligence > 0 && intelligence <=20){
            this.intelligence = intelligence;
        }
    }

    public void setCharisma(int charisma) {
        if(charisma > 0 && charisma <=12){
            this.charisma = charisma; 
        }
    }
}
    