public class Hero extends Creature
{
    private int blessing;

    public Hero(String name, String class, int level, int life, int mana, int force, int agility, int dexterity, int intelligence, int charisma, int blessing)
    {
        super(name, class, level, life, mana, force, agility, dexterity, intelligence, charisma);
        this.blessing = blessing;
    }

    public void rest()
    {

    }

    public void setBlessing(int blessing)
    {
        this.blessing = blessing;
    }

    public int getBlessing()
    {
        return this.blessing;
    }

}