import java.text.DecimalFormat;

class Heroi extends Criatura{
    
    float bencao;
    
    

    public Heroi (String nome, String classe, float nivel, float vida, float magia, float forca, float agilidade, float destreza, float inteligencia, float carisma, float bencao){    
        super(nome, classe, nivel, vida, magia, forca, agilidade, destreza, inteligencia, carisma);
        this.bencao = bencao;
    }
     
    public float descansar(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        float novo = (super.getVida() + super.getNivel() + getBencao()) * gerarNumero();
        System.out.println("O coeficiente de descanso foi " +df.format(novo)+ "\n");
        if (novo > 20){
            if((this.vida+50)<100){
                return this.vida+50;
            }else{
                return 100;
            }
        }else{
            return this.vida;
        } 
    }
    
    public void setBencao(float bencao){
        this.bencao = bencao;
    }
    
    public float getBencao(){
        return bencao;
    }
  
}
