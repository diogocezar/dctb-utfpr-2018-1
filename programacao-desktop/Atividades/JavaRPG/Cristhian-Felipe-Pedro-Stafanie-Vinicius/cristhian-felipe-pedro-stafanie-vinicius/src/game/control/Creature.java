package game.control;

import java.util.Random;
import javax.swing.*;

/**
 * Classe Creature, estabele os parametros de criatura
 *
 */
public abstract class Creature{
    Random random = new Random();
    private String name;
    private int level;
    private int life;
    private int magic;
    private int strength;
    private int agility;
    private int dexterity;
    private int intelligence;
    private int charism;
    private classCreature nameClass;

    /**
     * Construtor da classe Creature
     *
     * @param name recebe o nome
     * @param classCreature recebe a classe de criatura
     * @param level recebe o nivel
     * @param life recebe a vida
     * @param magic recebe o valor de magia
     * @param strength recebe a força
     * @param agility recebe a agilidade
     * @param dexterity recebe a destreza
     * @param intelligence recebe a inteligencia
     * @param charism recebe a carisma
     */
    public Creature(String name, int classCreature, int level, int life, int magic, int strength, int agility, int dexterity, int intelligence, int charism) {
        this.name = name;
        this.level = level;
        this.nameClass = nome(classCreature);
        this.life = life;
        this.magic = magic;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charism = charism;
    }

    /**
     * Enum de classe de criatura
     */
    public static enum classCreature {
        HUMAN(1), ELF(2), DARKELF(3), DWARF(4), KNIGHT(5), MAGE(6);

        private final int codigo;

        classCreature(int codigo) {
            this.codigo = codigo;
        }

        public int codigo() {
            return codigo;
        }
    }

    /**
     *  Metodo que retorna imagem de criatura ao receber a classe de criatura
     *
     * @return imagem de criatura
     */
    public String image() {
        switch (nameClass.codigo) {
            case 1:
                return "human.jpg";
            case 2:
                return "elf.jpg";
            case 3:
                return "dark_elf.jpg";
            case 4:
                return "dwarf.jpg";
            case 5:
                return "knight.jpg";
            case 6:
                return "mage.jpg";
        }
        return null;
    }

    /**
     * Metodo para receber codigo e retornar nome de classe da criaura
     *
     * @param classCreatureValue codigo de classe de criatura
     * @return nome de classe de criatura
     */
    public classCreature nome(int classCreatureValue) {
        for (classCreature p : classCreature.values())
            if (p.codigo == classCreatureValue) {
                return p;
            }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getMagic() {
        return magic;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharism() {
        return charism;
    }

    /**
     * Metodo do valor r de aleatorio
     * @return numero aleatorio entre 1.10 e 1.66
     */
    public float getR() {
        float r = (random.nextInt((66 - 10) + 1 ) + 10);
        return  r/100;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public classCreature getNameClass() {
        return nameClass;
    }

    /**
     * Metodo de ataque de criatura, usando valores de nível, agilidade
     * , magia e um numero aleatorio r gerado por {@link #getR()}
     * @return valor de ataque
     */
    public float attack(){
        float attack;
            attack = (float) (getLevel() + getAgility() + (getMagic() * 0.1) * getR());
            if(attack > 100){
                attack = 100;
            }
            System.out.print(getName() + " atacou (" + attack);
            return attack;
    };

    /**
     * Metodo de defesa de criatura, usando valores de agilidade
     * , destreza, inteligencia e um numero aleatorio r gerado por {@link #getR()}
     * @return
     */
    public float defend(){
        float defense;
            defense = (float) (getAgility() + (getDexterity() * 0.7) + getIntelligence()) * getR() + 10;
            if(defense > 100){
                defense = 100;
            }
            System.out.println("x" + defense + ") " +getName());
            return defense;
    };

    public boolean isLive() {
        return this.getLife() > 0;
    }

    public void loseLife(){
        System.out.println(getName() + " perdeu 8 pontos de vida");
        this.life -= 8;
    };

    public void revitalize() {
        System.out.println(getName() + " descansou");
        setLife(getLife()+50<100?getLife()+50:100);
        setMagic(getMagic()+30<100?getMagic()+30:100); 
    }

    public abstract void rest();

}
