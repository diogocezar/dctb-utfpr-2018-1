class Monstro extends Criatura{
    
    public Monstro(String nome, String classe, float nivel, float vida, float forca, float magia, float agilidade, float destreza, float inteligencia, float carisma){
        super(nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma);
    }
        
    public float descansar(){
        return (super.getVida() + super.getNivel()) * gerarNumero();
    }
}
