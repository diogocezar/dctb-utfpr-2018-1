import java.util.Random;

abstract class Creature implements Generic {
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

    public float attack() {
        Random rand = new Random();
        float var = (this.level + this.force + this.agility + (this.mana*0.1f))*(rand.nextFloat()*(1.66f - 1.10f) + 1.10f);
        if (var > 100)
        {
            return 100;
        } else if (var < 0 ) {
            return 0;
        }  else    {
            return var;
        }
    }

    public float defend() {
        Random rand = new Random();
        float var = (this.agility + (this.dexterity*0.7f) + this.intelligence) * (rand.nextFloat()*(1.66f - 1.10f) + 1.10f) + 10f;
        
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

    public void losesLife(float value) {
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

    public void __toString() 
    {
        System.out.println("Name: "+ this.name);
        System.out.println("Class: "+ this.classType);
        System.out.println("Life: "+ this.life);
        System.out.println("Mana: "+ this.mana);
        System.out.println("Force: "+ this.force);
        System.out.println("Agility: "+ this.agility);
        System.out.println("Dexterity: "+ this.dexterity);
        System.out.println("Intelligence: "+ this.intelligence);
        System.out.println("Charisma: "+ this.charisma);
    }

    public void __call()
    {

    }


    abstract void rest();
}