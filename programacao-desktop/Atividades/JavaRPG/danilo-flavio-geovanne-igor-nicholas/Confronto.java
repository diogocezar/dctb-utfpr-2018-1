import java.text.DecimalFormat;

public class Confronto {
    private Criatura vencedor;

    public Confronto(){}

    public Confronto(Criatura player1, Criatura player2) {
        iniciar(player1, player2);
    }

    public Criatura getVencedor(){
        return this.vencedor;
    }

    public void iniciar(Criatura player1, Criatura player2){

        int vez = 2;
        int turno = 1;

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        System.out.println("\n-------------------NOVO CONFRONTO--------------------");

        System.out.println(player1.toString());
        System.out.println(player2.toString());
        
        while(player1.getVida()>0 && player2.getVida()>0){
            System.out.println("--Turno "+turno+"--\n");
            if(vez==2){
                vez = 1;
                float ataque = player1.atacar();
                float defesa = player2.defender();

                System.out.println(player2.getNome()+" atacou (" +df.format(ataque) + " x "+df.format(defesa)+") " +player1.getNome()+ "\n");

                if(ataque>defesa){
                    player1.perdeVida();
                }else{
                    System.out.println(player1.getNome()+ " defendeu-se do ataque\n");
                }
 
                System.out.println(player1.getNome()+ " possui " +player1.getVida()+ " pontos de vida\n" 
                                + player2.getNome()+ " possui " +player2.getVida() + " pontos de vida\n\n");
            }
            else{
                vez = 2;
                float ataque = player1.atacar();
                float defesa = player2.defender();

                System.out.println(player1.getNome()+" atacou ("+df.format(ataque) + " x "+df.format(defesa)+") " +player2.getNome()+ "\n");

                if(ataque>defesa){
                    player2.perdeVida();
                }else{
                    System.out.println(player2.getNome()+ " defendeu-se do ataque\n");
                }
 
                System.out.println(player1.getNome()+ " possui " +player1.getVida()+ " pontos de vida\n" 
                                + player2.getNome()+ " possui " +player2.getVida() + " pontos de vida\n\n");    
            }
            turno++;
        }

        if(player2.getVida()<0){ 
            System.out.println("O "+player1.getNome()+" venceu o confronto\n");
            //System.out.println(String.valueOf( player2 instanceof Heroi) +"\n");                        
            
            if(player1 instanceof Heroi){
                player1.revitalizar(player1.descansar());
                System.out.println("O heroi " +player1.getNome()+ " pode descansar. Seu novo HP é " +df.format(player2.getVida())+"\n");
            }else{
                System.out.println("A classe de " +player1.getNome()+ " nao permite que ele descanse e recupere seu HP.\n");
            }
            //Teste de retorno
            vencedor = player1;
        }
        else if(player1.getVida()<0){
            System.out.println(player2.getNome()+" venceu o confronto\n");
            //System.out.println(String.valueOf( player2 instanceof Heroi) +"\n");            
            
            if(player2 instanceof Heroi){
                player2.revitalizar(player2.descansar());
                System.out.println("O heroi " +player2.getNome()+ " pode descansar. Seu novo HP é " + df.format(player2.getVida())+"\n");
            }else{
                System.out.println("A classe de " +player2.getNome()+ " nao permite que ele descanse e recupere seu HP.\n");
            }
            //Teste de retorno
            vencedor = player2;
        }
    }
}
