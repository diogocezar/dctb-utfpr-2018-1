class Criatura{

    private String nome, classe;
    private int nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma;

    Criatura(String nome, String classe, int nivel, int vida, int forca, int magia, int agilidade, int destreza, int inteligencia, int carisma){
        this.nome = nome;
        this.classe = classe;
        this.nivel = nivel;
        this.vida = vida;
        this.forca = forca;
        this.magia = magia;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.carisma = carisma;
    }

    public String getNome(){
        return nome;
    }

    public String getClasse(){
        return classe;
    }

    public int getNivel(){
        return nivel;
    }

    public int getVida(){
        return vida;
    }

    public int getForca(){
        return forca;
    }

    public int getMagia(){
        return magia;
    }

    public int getAgilidade(){
        return agilidade;
    }

    public int getDestreza(){
        return destreza;
    }

    public int getInteligencia(){
        return inteligencia;
    }

    public int getCarisma(){
        return carisma;
    }
 
    void atacar(){

    }
    void defender(){

    }

    void vivo(){

    }

    void perdeVida(){

    }

    void revitalizar(){

    }
    void descansar(){
        
    }
}