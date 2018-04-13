package game.control;

import java.util.Random;

public class Hero extends Creature {
    
    private int boon;
    
    
    public Hero(String name, int classCreature, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charism, int boon) {
        super(name, classCreature, level, life, magic, strength, agility, dexterity, intelligence, charism);
        this.boon = boon;
    }

    public int getBoon() {
        return boon;
    }

    @Override
    public void rest() {
        float rest = 0;
            rest = (getLife() + getLevel() + this.boon * getR());
            if(rest > 20){
                super.revitalize();
            }
    }

}
