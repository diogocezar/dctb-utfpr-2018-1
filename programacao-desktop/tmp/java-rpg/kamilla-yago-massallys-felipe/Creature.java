package parte1;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class Creature implements Generic {

    String name;
    String ranking;
    int level;
    int life;
    int magic;
    int strength;
    int agility;
    int dexterity;
    int intelligence;
    int charisma;
    int blessing;

    public Creature(String name, String ranking, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charisma, int blessing) {
        this.name = name;
        this.ranking = ranking;
        this.level = level;
        this.life = life;
        this.magic = magic;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.blessing = blessing;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public int getLevel() {
        if (level >= 1 && level <= 10) {
            return level;
        }
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLife() {
        if (life >= 1 && life <= 100) {
            return life;
        }
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMagic() {
        if (magic >= 1 && magic <= 100) {
            return magic;
        }
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getStrength() {
        if (strength >= 1 && strength <= 32) {
            return strength;
        }
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        if (agility >= 1 && agility <= 12) {
            return agility;
        }
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        if (dexterity >= 1 && dexterity <= 16) {
            return dexterity;
        }
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        if (intelligence >= 1 && intelligence <= 20) {
            return intelligence;
        }
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        if (charisma >= 1 && charisma <= 12) {
            return charisma;
        }

        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getBlessing() {
        return blessing;
    }

    public void setBlessing(int blessing) {
        this.blessing = blessing;
    }

    public double attack() {

        double attackForce;
        attackForce = (getLevel() + getStrength() + getAgility()
                + (getMagic() * 0.1)) * multiplierConstant();

        System.out.println("\nAttack force = "
                + new DecimalFormat("#0.##").format(attackForce));

        if (attackForce > 100) {
            return attackForce = 100;

        } else if (attackForce < 0) {
            return attackForce = 0;

        } else {
            return attackForce;
        }

    }

    public double defend() {

        double defenseForce;
        defenseForce = ((getAgility()
                + (getDexterity() * 0.7)
                + getIntelligence()) * multiplierConstant()) + 10;

        System.out.println("Defense force = "
                + new DecimalFormat("#0.##").format(defenseForce));

        if (defenseForce > 100) {
            return defenseForce = 100;
        } else if (defenseForce < 0) {
            return defenseForce = 0;
        } else {
            return defenseForce;
        }
    }

    public double multiplierConstant() {

        double r;
        Random random = new Random();
        r = (110 + (166 - 110) * random.nextDouble()) * 0.01;
        return r;
    }

    public double rest(int blessing) {

        double sleep;
        sleep = (getLife() + getLevel() + blessing) * multiplierConstant();

        if (sleep > 20) {
            if (getLife() + 50 > 100) {
                setLife(100);
            } else if (getMagic() + 30 > 100) {
                setMagic(100);
            } else {
                setLife(life + 50);
                setMagic(magic + 30);
            }
        }

        System.out.println("Rest = "
                + new DecimalFormat("#0.##").format(sleep));

        if (sleep > 100) {
            return sleep = 100;
        } else if (sleep < 0) {
            return sleep = 0;
        } else {
            return sleep;
        }
    }

    public int alive() {

        if (life > 100) {
            return life = 100;
        } else if (life < 0) {
            return life = 0;
        } else {
            return life;
        }
    }

    public double loseLife(int attack) {

        life -= attack;
        return (life);
    }

    public void revitalize() {
        //   rest();
    }

    @Override
    public void call() {
    }

    @Override
    public String toString() {
        return "";
    }
}
