public abstract Class Creature
{
    private String name;
    private String class;
    private int level;
    private int life;
    private int mana;
    private int force;
    private int agility;
    private int dexterity;
    private int intelligence;
    private int charisma;

    
    public Creature()
    {
    }

    public Creature(String name, String class, int level, int life, int mana, int force, int agility, int dexterity, int intelligence, int charisma)
    {
        this.name = name;
        this.class = class;
        this.level = level;
        this.life = life;
        this.mana = mana;
        this.force = force;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setClass(String class)
    {
        this.class = class;
    }

    public String getClass()
    {
        return this.class;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLife(int life)
    {
        this.life = life;
    }

    public int getLife()
    {
        return this.life;
    }

    public void setMana(int mana)
    {
        this.mana = mana;
    }
    
    public int getMana()
    {
        return this.mana;
    }

    public void setForce(int force)
    {
        this.force = force;
    }

    public int getForce()
    {
        return this.force;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
    }

    public int getAgility() 
    {
        return this.agility;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public int getDexterity()
    {
        return this.dexterity;
    }

    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    public int getIntelligence()
    {
        return this.intelligence;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }

    public int getCharisma()
    {
        return this.charisma;
    }

    public void attack()
    {
        
    }

    public void defend()
    {

    }

    public void isAlive()
    {

    }

    public void losesLife()
    {

    }

    public void revitalize()
    {

    } 

    abstract void rest()
    {

    }
}