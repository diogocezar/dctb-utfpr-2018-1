import java.util.Random;
class Criatura{

    private String nome, classe;
    private int nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma;
    //private double vida;

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
 
    Random gerador = new Random(); //numero aleatorio para o ataque e defesa

    public int atacar(){ // função atacar() retorna o dano causado
        /*if(classe=="Humano")
            return (double)nivel*forca*(double)(0.75*agilidade+0.25*destreza)/100;
        else
            return (double)nivel*inteligencia*(magia+agilidade)/435;*/
        if(classe=="Humano")
            return (gerador.nextInt(2))*nivel*(7*forca+3*agilidade+3*destreza)/10;
        else
            return (gerador.nextInt(2))*nivel*(7*inteligencia+2*magia+agilidade)/10;
    }
    int defender(){ // função defender() retorna o total de dano defendido
       // return nivel*(double)(0.4*destreza+0.3*carisma+0.3*inteligencia)/(double)(vida/3);
       return (gerador.nextInt(2))*this.vida/8*(5*destreza+4*agilidade+carisma)/10;
    }

    void vivo(){

    }

    public void perdeVida(int ataque){ // função perdeVida() dá baixa no HP do personagem
        int defesa = defender();
        System.out.println("Dano do ataque: "+ataque);
        System.out.println("Dano defendido: "+defesa);
        if(ataque>=defesa)
            this.vida -= ataque-defesa;
        int toggleRegen = gerador.nextInt(3);
        if (toggleRegen==0) revitalizar(); // 1/3 de chance de ativar a skill revitalizar
    }

    void revitalizar(){
        int regeneracao = gerador.nextInt(65);
        if (this.vida+regeneracao>100) this.vida=100; // regeneraçao do HP entre cada ataque sofrido
        else this.vida+= regeneracao;

        System.out.println("Revitalizar disparado. Regenerados "+regeneracao+" pontos de vida.");
    }
    void descansar(){
        
    }
}