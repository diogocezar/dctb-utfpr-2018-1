package jogorpg;
/**
 *
 * @author Erik Lima
 */

public abstract class Creature {
    
            //===attributes==
  
    private String nome;            //name
    private String clases;
    private double nivel;              //level
    private double vida;               //life
    private double magia;              //Magic
    private double força;              //force
    private double agilidade;          //agility
    private double destreza;           //dexterity
    private double intelligencia;      //intelligence
    private double carisma;            //charisma

    Aleatorio r = new Aleatorio();
    double num =r.GerarNumeroAleatorio(10, 66);
    
    
       
    public String getNome() {
        return nome;
    }

    public String getClases() {
        return clases;
    }

    public double getNivel() {
        return nivel;
    }

    public double getVida() {
        return vida;
    }

    public double getMagia() {
        return magia;
    }

    public double getForca() {
        return força;
    }

    public double getAgilidade() {
        return agilidade;
    }

    public double getDestreza() {
        return destreza;
    }

    public double getIntelligencia() {
        return intelligencia;
    }

    public double getCarisma() {
        return carisma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setMagia(double magia) {
        this.magia = magia;
    }

    public void setForça(double forca) {
        this.força = forca;
    }

    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public void setIntelligencia(double intelligencia) {
        this.intelligencia = intelligencia;
    }

    public void setCarisma(double carisma) {
        this.carisma = carisma;
    }
    
    
    
             //===methods==
    
   
    public Creature(String nome, String clases, double nivel, double vida, double magia, double força, double agilidade, double destreza, double intelligencia, double carisma){
        this.nome = nome;
        this.clases = clases;
        this.nivel = nivel;
        this.vida = vida;
        this.magia = magia;
        this.força = força;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.intelligencia = intelligencia;
        this.carisma = carisma;
        
    }
    

    public double atacar(double nivel, double forca, double agilidade, double magia) {
        //metod attack
        
       
       
        return (nivel + forca + agilidade + (magia*0.1)* (num/100) );
    }
    public double  defender(double agilidade, double destreza, double inteligencia){
        //metod defend
      
        return ((agilidade + (destreza * 0.7) + inteligencia)*(num/100) + 10);
        
    }
    public boolean vivo(double vida){
        //metod alive
        boolean retorno = true;
        if(vida < 1){
            retorno= false;
        }else if(vida >0){ 
            retorno =true;
        }
        return retorno;
        
        
    }
    public double perderVida(double vida){         //metod losesLife
        return vida - 8;
    }
    public void  revitalizar(Creature c){        //metod revitalize
        setVida(c.getVida()+50);
        setVida(c.getVida()+ 30);
        if(c.getVida()> 100){
               c.setVida(100);
         }
            if(c.getMagia()>100){
                c.setMagia(100);
            }
        
    }
    abstract public  double descancar(double vida, double nivel);    //metod rest
       
       
    public void _toString(){
        System.out.println("Nome "+getNome());
        System.out.println("Nivel "+ getNivel());
        System.out.println("Vida " + getVida());
        System.out.println("Magia "+ getMagia());
        System.out.println("Força "+ getForca());
        System.out.println("Agilidade "+ getAgilidade());
        System.out.println("Deztreza "+ getDestreza());
        System.out.println("Inteligencia "+ getIntelligencia());
        System.out.println("Carisma "+ getCarisma());
        
        
        
        
    }
    public void _call(){
        
    }

    
    
}
