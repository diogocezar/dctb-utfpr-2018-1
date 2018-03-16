/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;
import java.util.Random;
/**
 *
 * @author Aluno
 */
public class Creature implements Generic {
    
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
        
        this.name = name;
        this.race = race;
        this.level = level;
        this.health = health;
        this.magic = magic;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.inteligence = inteligence;
        this.charisma = charisma;
    }
    //Methods
    public float ladyLuck(){
        final int min = 10, max = 60;
        Random r = new Random();
        return (r.nextInt((max - min) + 1) + min)/100;
    }
    public  int attack (){
        
        if( ((int)(((float)this.level + (float)this.strength + (float)this.agility +(float)(this.magic*0.1))* ladyLuck()) > 100)){
            return 100;
        }else
            return (int) (((float)this.level + (float)this.strength + (float)this.agility +(float)(this.magic*0.1))* ladyLuck()) ;
    }
    public int defend(){
        
        if((int)(((float)this.agility + ((float)this.dexterity * 0.7f) + (float)this.inteligence) * ladyLuck() + 10f)>100)
            return 100;
        else
            return (int)(((float)this.agility + ((float)this.dexterity * 0.7f) + (float)this.inteligence) * ladyLuck() + 10f);
    }
    public boolean isAlive(){
        return (this.getHealth() <= 0);
    }
    public void loseHealth(){
        setHealth(getHealth() -8); 
    }
    public void Heal(int bless){
        int lifeRecover = 50, magicRecover = 30;
        if(bless > 20){
            if((magicRecover + getMagic()) > 100)
                    setMagic(100);
            else
                setHealth(lifeRecover);
        }
        if(bless > 20){
            if((magicRecover + getMagic()) > 100)
                    setMagic(100);
            else
                setMagic(magicRecover);
        }
    }
    //toString

}
