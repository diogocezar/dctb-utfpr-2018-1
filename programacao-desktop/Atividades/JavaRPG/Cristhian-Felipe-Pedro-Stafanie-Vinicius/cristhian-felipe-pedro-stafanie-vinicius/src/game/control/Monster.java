package game.control;

import java.util.Random;

public class Monster extends Creature {
    
    private int r;
    Random random = new Random();

    public Monster(String name, int classCreature, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charism) {
        super(name, classCreature, level, life, magic, strength, agility, dexterity, intelligence, charism);
        r = (random.nextInt(66) / 100);
    }

    @Override
    public void rest() {
        float rest = 0;
            rest += (super.getLife() + super.getLevel() * this.r);
        if(rest>20){
            super.revitalize();
        }
    }

}
