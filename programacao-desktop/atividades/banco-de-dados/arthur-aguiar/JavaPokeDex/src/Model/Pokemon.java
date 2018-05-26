/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arthu
 */
public class Pokemon {
   private String name;
   private int level;
   private int hp;
   private int agi;
   private int atk;
   private int def;
   private int sAtk;
   private int sDef;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getsAtk() {
        return sAtk;
    }

    public void setsAtk(int sAtk) {
        this.sAtk = sAtk;
    }

    public int getsDef() {
        return sDef;
    }

    public void setsDef(int sDef) {
        this.sDef = sDef;
    }

    public Pokemon(String name, int level, int hp, int agi, int atk, int def, int sAtk, int sDef) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.agi = agi;
        this.atk = atk;
        this.def = def;
        this.sAtk = sAtk;
        this.sDef = sDef;
    }
    
   
}
