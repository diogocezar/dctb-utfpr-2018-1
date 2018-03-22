package jogorpg;

/**
 *
 * @author Erik Lima
 */
public class Hero extends Creature{
    
  
//===attributes==
    private int blessing;
        public Hero(String name, String family, int level, int life, int magic, int force, int agility, int dexterity, int intelligence, int charisma) {
        super(name, family, level, life, magic, force, agility, dexterity, intelligence, charisma);
        
    }    

    public void setBlessing(int blessing){
        this.blessing = blessing;
    }
    public int getBlessing(){
        return this.blessing;
    }
    
            //===methods==
    
    public void construct(){
        
    }
    public void descansar(){
        
    }
    
}
