/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.utfpr.pokedex.Model;

/**
 *
 * @author Pedro
 */
public class Move {
    private int attack;
    private int defense;
    private int hp;
    private int sp_atk;
    private int sp_def;
    private int speed;

    public Move(int attack, int defense, int hp, int sp_atk, int sp_def, int speed) {
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.sp_atk = sp_atk;
        this.sp_def = sp_def;
        this.speed = speed;
    }
    
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public int getSp_atk() {
        return sp_atk;
    }

    public int getSp_def() {
        return sp_def;
    }

    public int getSpeed() {
        return speed;
    }
    
    
}
