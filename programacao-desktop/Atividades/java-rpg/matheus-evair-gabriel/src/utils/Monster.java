package utils;
public class Monster extends Creature{

    public Monster(String name, String classType, double level, double life, double magic, double power, double agility, double dexterity, double intelligence, double charisma, Integer blessing) {
        super(name, classType, level, life, magic, power, agility, dexterity, intelligence, charisma, blessing);
    }
    
    @Override
    public String toString() {
        return "Monstro{" + '}';
    }
}
