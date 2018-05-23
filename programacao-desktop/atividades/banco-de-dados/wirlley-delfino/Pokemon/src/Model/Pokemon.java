/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Wirlley Delfino
 */
public class Pokemon {
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int level;
    private int hp;
    private int agi;
    private int atk;
    private int def;
    private int specialAtk;
    private int specialDef;

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

    public int getSpecialAtk() {
        return specialAtk;
    }

    public void setSpecialAtk(int specialAtk) {
        this.specialAtk = specialAtk;
    }

    public int getSpecialDef() {
        return specialDef;
    }

    public void setSpecialDef(int specialDef) {
        this.specialDef = specialDef;
    }
}
