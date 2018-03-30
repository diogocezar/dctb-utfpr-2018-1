package utils;

import java.util.Random;

abstract class Creature {

    double r;
    private String name;

    private String classType;

    double level;

    double life;

    private double magic;

    private double power;

    private double agility;

    private double dexterity;

    private double intelligence;

    private double charisma;

    private Integer blessing;

    public Creature(String name, String classType, double level, double life, double magic, double power, double agility, double dexterity, double intelligence, double charisma, Integer blessing) {
        this.name = name;
        this.classType = classType;
        this.level = level;
        this.life = life;
        this.magic = magic;
        this.power = power;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.blessing = blessing;
    }

    public boolean alive() {
        if (life > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double random() {
        r = (1.10 + Math.random() * 1.66);
        return r;
    }

    public double attack() {
        double attack;
        attack = (level + power + agility + (magic * 0.1)) * random();
        if (attack > 100) {
            attack = 100;
        }
        return attack;
    }

    public double defend() {
        double defend;
        defend = (agility + (dexterity * 0.7) + intelligence) * random() + 10;
        if (defend > 100) {
            defend = 100;
        }
        return defend;
    }

    public double rest() {
        double rest;
        if (blessing == null) {
            rest = (life + level) * random();
        } else {
            rest = (life + level + blessing) * random();
        }
        return rest;
    }

    public boolean revitalize() {
        if (rest() > 20) {
            life = life + 50;
            magic = magic + 30;
            if (life > 100) {
                life = 100;
            }
            if (magic > 100) {
                magic = 100;
            }
            return true;
        } else {
            return false;
        }
    }
    
    // --------------------- Getters and Setters -------------------------

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String clase) {
        this.classType = clase;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double nivel) {
        this.level = nivel;
    }

    public double getLife() {
        if (life <= 0) {
            return 0;
        } else {
            return life;
        }
    }

    public void setLife(double vida) {
        this.life = vida;
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magia) {
        this.magic = magia;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double forca) {
        this.power = forca;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agilidade) {
        this.agility = agilidade;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double destreza) {
        this.dexterity = destreza;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double inteligencia) {
        this.intelligence = inteligencia;
    }

    public double getCharisma() {
        return charisma;
    }

    public void setCharisma(double carisma) {
        this.charisma = carisma;
    }

    public void loseLife() {
        life = life - 8;
    }

    public Integer getBlessing() {
        return blessing;
    }

    public void setBlessing(Integer bencao) {
        this.blessing = bencao;
    }

}
