/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author Aluno
 */
public class Creature {
    
    private String name;
    private String race;
    private int level;
    private int health;
    private int magic;
    private int strength;
    private int agility;
    private int dexterity;
    private int inteligence;
    private int charisma;
    
    //GET & SET
    
    //Name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
         return this.name;
    }
    //Race
    public void setRace(String race){
        this.race = race;
    }
    public String getRace(){
        return this.race;
    }
    //Level
    public void setLevel(int lvl){
        this.level = lvl;
    }
    public int getLevel(){
        return this.level;
    }
    //Health
    public void setHealth(int hp){
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
    //Magic
    public void setMagic(int magic){
        this.magic = magic;
    }
    public int getMagic(){
        return this.magic;
    }
    //Strength
    public void setStrength(int str){
        this.strength = str;
    }
    public int getStrength(){
        return this.strength;
    }
    //Agility
    public void setAgility(int agi){
        this.agility = agi;
    }
    public int getAgility(){
        return this.agility;
    }
    //Dexterity
    public void setDexterity(int dex){
        this.dexterity = dex;
    }
    public int getDexterity(){
        return this.dexterity;
    }
    //Inteligence
    public void setInteligence(int inteligence){
        this.inteligence = inteligence;
    }
    public int getInteligence(){
        return this.inteligence;
    }
    //Charisma
    public void setCharisma(int charisma){
        this.charisma = charisma;
    }
    public int getCharisma(){
        return this.charisma;
    }
    
    //Construtor
    public Creature(String name, String race, int level, int health, int magic, int strength, int agility, int dexterity, int inteligence, int charisma){
        setName(name);
        setRace(race);
        setLevel(level);
        setHealth(health);
        setMagic(magic);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setInteligence(inteligence);
        setCharisma(charisma);
    }
    //Methods
    public  int attack (){
    
    }
    public int defend(){
    
    }
    public int rest(){
    
    }
    public boolean isAlive(){
        return (getHealth() > 0) ? true : false;
    }
    public void loseHealth(){
        setHealth(getHealth() -8); 
    }
    public void Heal(){
    
    }
    //toString

}
