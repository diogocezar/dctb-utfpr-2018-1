class Heroi extends Criatura{
    
    float bencao;
    
    public Heroi (String nome, String classe, float nivel, float vida, float magia, float forca, float agilidade, float destreza, float inteligencia, float carisma, float bencao){    
        super(nome, classe, nivel, vida, magia, forca, agilidade, destreza, inteligencia, carisma);
        this.bencao = bencao;
    }
     
    public float descansar(){
        float novo = (super.getVida() + super.getNivel() + getBencao()) * gerarNumero();
        if (novo > 100){
            return 100;
        }else{
        return novo;
        } 
    }
    
    public void setBencao(float bencao){
        this.bencao = bencao;
    }
    
    public float getBencao(){
        return bencao;
    }
  
}
