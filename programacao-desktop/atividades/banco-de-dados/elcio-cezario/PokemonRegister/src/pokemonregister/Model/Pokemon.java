/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Model;

/**
 *
 * @author ecsanchesjr
 */
public class Pokemon {
    private String name;
    private int level;
    private int hp;
    private int agility;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;

    public Pokemon(String name, int level, int hp, int agility, int attack, int defense, int specialAttack, int specialDefense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.agility = agility;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }
    
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

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "name=" + name + ", level=" + level + ", hp=" + hp + ", agility=" + agility + ", attack=" + attack + ", defense=" + defense + ", specialAttack=" + specialAttack + ", specialDefense=" + specialDefense + '}';
    }
}
