package Model;
public class Pokemon {
    public String name;
    public int level;
    public int hp;
    public int agility;
    public int attack;
    public int defense;
    public int specialAttack;
    public int specialDefense;

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

    public Pokemon() {

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
    
    
}
