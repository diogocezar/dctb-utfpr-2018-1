class Heroi extends Criatura{
    
    int bencao;
    
    public Heroi (String nome, String classe, int nivel, int vida, int forca, int magia, int agilidade, int destreza, int inteligencia, int carisma, int bencao){
        super(nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma);
        this.bencao = bencao;
    }

    public int getBencao(){
        return bencao;
    }
}