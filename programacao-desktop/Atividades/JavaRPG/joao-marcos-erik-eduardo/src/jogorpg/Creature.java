package jogorpg;

/**
 *
 * @author Erik Lima
 */

public class Creature implements Generica {
    
            //===attributes==
  
    private String name;        //name
    private String family;
    private int level;          //level
    private int life;           //life
    private int magic;          //Magic
    private int force;          //force
    private int agility;        //agility
    private int dexterity;      //dexterity
    private int intelligence;   //intelligence
    private int charisma;       //charisma
    
    
           
    //Get and Set
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setFamily(String family){
        this.family = family;
    }
    public String Getfamily(){
        return this.family;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }
    
    public void setLife(int life){
        this.life = life;
    }
    public int getLife(){
        return this.life;
    }
    
    public void setMagic(int magic){
        this.magic = magic;
    }
    public int getMagic(){
        return this.magic;
    }
    
    public void setForce(int force){
        this.force = force;
    }
    public int getForce(){
        return this.force;
    }
    
    public void setAgility(int agility){
        this.agility = agility;
    }
    public int getAgility(){
        return this.agility;
    }
    
    public void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }
    public int getDexterity(){
        return this.dexterity;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public int getIntelligence(){
        return this.intelligence;
    }
    
    public void setCharisma(int charisma){
        this.charisma = charisma;
    }
    public int getCharisma(){
        return this.charisma;
    }
        
            //Construct
    
    public Creature(String name,String family,int level, int life, int magic, int force, int agility,int dexterity, int intelligence, int charisma){
    
        this.name = name;
        this.family = family;
        this.level = level;
        this.life = life;
        this.magic = magic;
        this.force = force;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }
            //===methods==
    public void construct(){
        
    }
    public void atacar(){            //metod attack
        
    }
    public void  defender(){            //metod defend
        
    }
    public void  vivo(){             //metod alive
        
    }
    public void  perderVida(){         //metod losesLife
            
    }
    public void  revitalizar(){        //metod revitalize
        
    }
    public void descansar(){     //metod rest
        
    }
    public void _toString(){
        
    }
    public void _call(){
        
    }
    
}
