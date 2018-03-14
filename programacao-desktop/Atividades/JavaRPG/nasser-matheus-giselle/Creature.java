import java.util.Random;

abstract class Creature {
    private String name;
    private String classType;
    private int level;
    private int life;
    private int mana;
    private int force;
    private int agility;
    private int dexterity;
    private int intelligence;
    private int charisma;

    public Creature() {
    }

    public Creature(String name, String classType, int level, int life, int mana, int force, int agility, int dexterity,
            int intelligence, int charisma) {
        this.name = name;
        this.classType = classType;
        this.level = level;
        this.life = life;
        this.mana = mana;
        this.force = force;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getForce() {
        return this.force;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAgility() {
        return this.agility;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public Float attack() {
        Random rand = new Random();
        Float var = (this.level + this.force + this.agility + (this.mana*0.1))*(rand.nextFloat()*(1.66 - 1.10) + 1.10);
        if (var > 100)
        {
            return 100;
        } else if (var < 0 ) {
            return 0;
        }  else    {
            return var;
        }
    }

    public Float defend() {
        Random rand = new Random();
        Float var = (this.agility + (this.dexterity*1.8) + this.intelligence) * (rand.nextFloat()*(1.66 - 1.10) + 1.10) + 10;
        
        if ( var > 100 )
        {
            return 100;
        } else if (var < 0) {
            return 0;
        }  else {
            return var;
        }
    }

    public Boolean isAlive() {
        if (this.life <= 0)
            return false;
        else
            return true;
    }

    public void losesLife(Float value) {
        this.life -= value;
    }

    public void revitalize() {
        if (this.life + 50 > 100) {
            this.life = 100;
        } else {
            this.life += 50;
        }

        if (this.mana + 30 > 100) {
            this.mana = 100;
        } else {
            this.mana += 30;
        }
    }

    abstract void rest();
}