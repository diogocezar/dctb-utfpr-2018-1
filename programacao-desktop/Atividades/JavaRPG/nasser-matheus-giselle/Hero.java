import java.util.Random;

public class Hero extends Creature {
    private int blessing;

    public Hero()
    {

    }

    public Hero(String name, String typeClass, int level, int life, int mana, int force, int agility, int dexterity,
            int intelligence, int charisma, int blessing) {
        super(name, typeClass, level, life, mana, force, agility, dexterity, intelligence, charisma);
        this.blessing = blessing;
    }

    public void setBlessing(int blessing) {
        this.blessing = blessing;
    }

    public int getBlessing() {
        return this.blessing;
    }
    @Override
    public void __toString() {
        super.__toString();
        System.out.println("Blessing: "+ this.blessing);
    }

    public void rest() {
        Random rand = new Random();
        float var = (super.getLife() + super.getLevel() + this.blessing) * (rand.nextFloat() * (1.66f - 1.10f) + 1.10f);

        if (var > 20) {
            super.revitalize();
        }
    }
}