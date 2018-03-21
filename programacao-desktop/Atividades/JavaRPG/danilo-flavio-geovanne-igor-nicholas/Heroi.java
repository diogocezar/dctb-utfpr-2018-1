class Heroi extends Criatura{
    
    float bencao;
    
    public Heroi (String nome, String classe, float nivel, float vida, float forca, float magia, float agilidade, float destreza, float inteligencia, float carisma, float bencao){    
        super(nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma);
        this.bencao = bencao;
    }
     
    public float descansar(){
        return (super.getVida() + super.getNivel() + getBencao()) * gerarNumero();
    }
    
    public void setBencao(float bencao){
        this.bencao = bencao;
    }
    
    public float getBencao(){
        return bencao;
    }
  
}
