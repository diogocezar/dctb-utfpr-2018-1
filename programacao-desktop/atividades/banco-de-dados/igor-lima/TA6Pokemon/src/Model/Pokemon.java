package Model;

/**
 *
 * @author igorv
 */
public class Pokemon {
    //id,name,level,hp,agility,attack,defense,spA,spD
    public int id;
    public String name;
    public int level;
    public int hp;
    public int agility;
    public int attack;
    public int defense;
    public int specialAttack;
    public int specialDefense;
    
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setAgility(int agility){
        this.agility = agility;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public void setSpecialAttack(int speccialAttack){
        this.specialAttack = specialAttack;
    }
    public void setSpecialDefense(int specialDefense){
        this.specialDefense = specialDefense;
    }

    public int getId(){
        return id;
    }    
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public int getHp(){
        return hp;
    }
    public int getAgility(){
        return agility;
    }
    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpecialAttack(){
        return specialAttack;
    }
    public int getSpecialDefense(){
        return specialDefense;
    }
    
    
}
