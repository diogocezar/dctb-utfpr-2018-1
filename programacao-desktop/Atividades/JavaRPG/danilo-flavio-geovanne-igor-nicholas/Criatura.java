import java.util.Random;
public abstract class Criatura implements Generica{

    public String nome, classe;
    public float nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma;

    Criatura(String nome, String classe, float nivel, float vida, float magia, float forca, float agilidade, float destreza, float inteligencia, float carisma){
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

    public float getNivel(){
        return nivel;
    }

    public float getVida(){
        return vida;
    }

    public float getForca(){
        return forca;
    }

    public float getMagia(){
        return magia;
    }

    public float getAgilidade(){
        return agilidade;
    }

    public float getDestreza(){
        return destreza;
    }

    public float getInteligencia(){
        return inteligencia;
    }

    public float getCarisma(){
        return carisma;
    }

    public float gerarNumero(){
        final float max = 1.66f;
        final float min = 1.10f;
        Random gerador = new Random(); //numero aleatorio para o ataque e defesa
        return (gerador.nextFloat()*(max - min)) + min;
    }

    public float atacar(){ // função atacar() retorna o dano causado
        float novo = (float)(nivel + forca + agilidade + (magia*0.1) ) * gerarNumero();
        return novo;
    }
    public float defender(){ // função defender() retorna o total de dano defendido
        float novo = (float)((agilidade + (destreza * 0.7) + inteligencia) * gerarNumero()) + 10;
        return novo;
    }

    void vivo(){

    }

    public void perdeVida(){ // função perdeVida() dá baixa no HP do personagem
        this.vida -=8;
        System.out.println(this.nome+ " perdeu 8 pontos de vida\n");
    }

    public void revitalizar(float recuperar){
        this.vida = recuperar;
    }
    
    public abstract float descansar(); 

    public String toString(){
        return("\nNome: " +this.nome+ "\nClasse: " +this.classe+ "\nNível: " +this.nivel+   
        "\nVida: " +this.vida+ "\nMagia: " +this.magia+ "\nForça: " +this.forca+ "\nAgilidade:" +this.agilidade+
        "\nDestreza: " +this.destreza+ "\nInteligência: " +this.inteligencia+ "\nCarisma: " +this.carisma+"\n");
    }
}