public class Hero extends Creature {
    
    private int bless;
    
    public int getBless(){
        return bless;
    }
    public void setBless(int bless){
        this.bless = bless;
    }

    public Hero(String name, String race, int level, 
                int life, int spell, int strenght, 
                int agility, int skill, int intelligence,
                int charisma, int bless) {
        super(name, race, level, life, spell, strenght, agility, skill, intelligence, charisma);
        this.bless = bless;
    }

    public String toString(){
        String text = super.toString();
        text += "\nBençao: "+this.bless;
        
        return text;
    }
 
    @Override
    public float rest() {
        return ((this.getLife() + this.getLevel() + this.getBless()) / 3) * this.generateConstRand();
    }
}
