/*
* Créditos: https://github.com/ucuptimposu/mvc-dao-simple-java-swing
**/

package Model;

public class Pokemon{

    private int id;
    private String name;
    private int level;
    private int hp;
    private int agility;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;

    
    // É nesta classe que as operações com os dados devem ser realizadas;

    public int getId() {
        return id;
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

    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }
    public String getHp() {
        return hp;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }
    public String getAgility() {
        return agility;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }
    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }
    public void setDefense(String defense) {
        this.defense = defense;
    }
    public String getSpecialAttack() {
        return specialAttack;
    }
    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }
    public String getSpecialDefense() {
        return specialDefense;
    }
    public void setSpecialDefense(String specialDefense) {
        this.specialDefense = specialDefense;
    }
}