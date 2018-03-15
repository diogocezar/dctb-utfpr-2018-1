/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

/**
 *
 * @author noda
 */
public class Hero extends Creature {
    private int blessing;
    
    public Hero(String name, String creature_class, int level, int life, int magic, int strength, int agility,
            int dexterity, int intelligence, int charisma, int blessing) {
        super(name, creature_class, level, life, magic, strength, agility, dexterity, intelligence, charisma);
        this.blessing=blessing;
    }
        
    @Override
    public String __toString() {
        String heroInfos=
                "\n----------\nName: "+ this.getName()+ "\n"
                +"Class: "+ this.getCreature_class()+"\n"
                +"Level: "+this.getLevel()+"\n"
                +"Life: "+this.getLife()+"\n"
                +"Magic: "+this.getMagic()+"\n"
                +"Strength: "+this.getStrength()+"\n"
                +"Agility: "+this.getAgility()+"\n"
                +"Dexterity: "+this.getDexterity()+"\n"
                +"Intelligence: "+this.getIntelligence()+"\n"
                +"Charisma: "+this.getCharisma()+"\n"
                +"Blessing: "+this.blessing;
        return heroInfos;
    }

    @Override
    public void __call() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getBlessing() {
        return blessing;
    }

    public void setBlessing(int blessing) {
        this.blessing = blessing;
    }

    @Override
    public int rest() {
        return (int)((this.getLife()+this.getLevel()+this.getBlessing())*this.constantMultiplier());
    }
    
    
}
