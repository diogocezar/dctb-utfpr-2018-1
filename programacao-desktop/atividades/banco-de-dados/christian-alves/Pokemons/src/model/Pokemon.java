package model;

/**
 *
 * @author christian
 */
public class Pokemon {
    
    private int id;
    private String name;
    private int level, hp, agility, attack, defense, specialAttack, specialDefense;
    
    public Pokemon(
            String name,
            int level,
            int hp,
            int agility,
            int attack,
            int defense,
            int specialAttack,
            int specialDefense
    ) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.agility = agility;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }
    
    public Pokemon() {}
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
        String aux = "";
        
        aux += "ID: " + this.id + "\n";
        aux += "Name: " + this.name + "\n";
        aux += "Level: " + this.level + "\n";
        aux += "HP: " + this.hp + "\n";
        aux += "Agility: " + this.agility + "\n";
        aux += "Attack: " + this.attack + "\n";
        aux += "Defense: " + this.defense + "\n";
        aux += "Special Attack: " + this.specialAttack + "\n";
        aux += "Special Defense: " + this.specialDefense;
        
        return aux;
    }
    
}
