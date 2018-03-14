import java.util.Random;

public class Monster extends Creature {
    public Monster(String name, String typeClass, int level, int life, int mana, int force, int agility, int dexterity,
            int intelligence, int charisma) {
        super(Creature(name, typeClass, level, life, mana, force, agility, dexterity, intelligence, charisma));
    }

    public void rest() {
        Random rand = new Random();
        Float var = (super.getLife()+super.getLevel())*(rand.nextFloat()*(1.66 - 1.10) + 1.10);

        if (var > 20 )
        {
           super.revitalize();
        }
    }
}