import java.util.Random;
public abstract class Criatura{

    private String nome, classe;
    private float nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma;
    //private double vida;

    Criatura(String nome, String classe, float nivel, float vida, float forca, float magia, float agilidade, float destreza, float inteligencia, float carisma){
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

    final float max = 1.66f;
    final float min = 1.10f;
    Random gerador = new Random(); //numero aleatorio para o ataque e defesa
    float r = min + gerador.nextFloat() * (max-min);

    public float atacar(){ // função atacar() retorna o dano causado
        /*if(classe=="Humano")
            return (double)nivel*forca*(double)(0.75*agilidade+0.25*destreza)/100;
        else
            return (double)nivel*inteligencia*(magia+agilidade)/435;*/
       // if(classe=="Humano")
      //      return (gerador.nextInt(2))*nivel*(7*forca+3*agilidade+3*destreza)/10;
      //  else
       //     return (gerador.nextInt(2))*nivel*(7*inteligencia+2*magia+agilidade)/10;
       return (float)(nivel + forca + agilidade + (magia*0.1) ) * r;
    }
    public float defender(){ // função defender() retorna o total de dano defendido
       // return nivel*(double)(0.4*destreza+0.3*carisma+0.3*inteligencia)/(double)(vida/3);
      // return (gerador.nextInt(2))*this.vida/8*(5*destreza+4*agilidade+carisma)/10;
        return  (float)(agilidade + (destreza * 0.7) + inteligencia) * r + 10;
    }

    void vivo(){

    }

    public void perdeVida(float ataque){ // função perdeVida() dá baixa no HP do personagem
        float defesa = defender();
        System.out.println("Coeficiente do ataque: "+ataque);
        System.out.println("Coeficiente da defesa: "+defesa);
        if(ataque>=defesa){
            System.out.println("Ataque bem sucedido. O "+getNome()+" perdeu 8 pontos de vida.");
            this.vida -= 8;
            System.out.println("Vida atual do "+getNome()+": "+getVida());
        }
        else{
            System.out.println("Ataque não foi bem sucedido");
        }
       // int toggleRegen = gerador.nextInt(3);
        //if (toggleRegen==0) revitalizar(); // 1/3 de chance de ativar a skill revitalizar
    }

    void revitalizar(){
        //int regeneracao = gerador.nextInt(65);
        //if (this.vida+regeneracao>100) this.vida=100; // regeneraçao do HP entre cada ataque sofrido
       // else this.vida+= regeneracao;

       // System.out.println("Revitalizar disparado. Regenerados "+regeneracao+" pontos de vida.");
    }
    public abstract float descansar();
       
    
}
