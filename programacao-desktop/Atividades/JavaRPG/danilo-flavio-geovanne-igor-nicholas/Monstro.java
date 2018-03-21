public class Monstro extends Criatura{
    
    public Monstro(String nome, String classe, float nivel, float vida, float magia, float forca, float agilidade, float destreza, float inteligencia, float carisma){
        super(nome, classe, nivel, vida, magia, forca, agilidade, destreza, inteligencia, carisma);
    }
    
    public float descansar(){
        return 0;   
    }

}
