public class Confronto {
    Confronto(Criatura player1, Criatura player2, int[] vencedor) {
        iniciar(player1, player2, vencedor);
    }

    public static void main() {

    }

    public void iniciar(Criatura player1, Criatura player2, int[] vencedor){
        int vez = 2;
        int turno = 1;
        
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        
        while(player1.getVida()>0 && player2.getVida()>0){
            System.out.println("--Turno "+turno+"--\n");
            if(vez==2){
                vez = 1;
                int ataque = player2.atacar();
                int defesa = player1.defender();

                System.out.println(player2.getNome()+" atacou (%.2f " +ataque+ " x %.2f" +defesa+") " +player1.getNome()+ "\n");

                if(ataque>defesa){
                    player1.perdeVida();
                }else{
                    System.out.println(player1.getNome()+ " defendeu-se do ataque\n");
                }
 
                System.out.println(player1.getNome()+ " possui " +player1.getVida()+ "\n" 
                                + player2.getNome()+ " possui " +player2.getVida() + "\n\n");
            }
            else{
                vez = 2;
                int ataque = player1.atacar();
                int defesa = player2.defender();

                System.out.println(player1.getNome()+" atacou (%.2f" +ataque+ " x %.2f" +defesa+") " +player2.getNome()+ "\n");

                if(ataque>defesa){
                    player2.perdeVida();
                }else{
                    System.out.println(player2.getNome()+ " defendeu-se do ataque\n");
                }
 
                System.out.println(player1.getNome()+ " possui " +player1.getVida()+ "\n" 
                                + player2.getNome()+ " possui " +player2.getVida() + "\n\n");    
            }
            turno++;
        }


        if(player2.getVida()<0){ 
            System.out.println("O "+player1.getNome()+" venceu o confronto");
            if(player1 instanceof Heroi){
                player1.revitalizar(player1.descansar());
                System.out.println("O heroi " +player1.getNome()+ " pode descansar. Seu novo HP é " +player1.getVida());
            }else{
                System.out.println("A classe de " +player1.getNome()+ " nao permite que ele descanse e recupere seu HP.");
            }
        }
        else if(player1.getVida()<0){
            System.out.println("O "+player2.getNome()+" venceu o confronto");
            if(player2 instanceof Heroi){
                player2.revitalizar(player2.descansar());
                System.out.println("O heroi " +player2.getNome()+ " pode descansar. Seu novo HP é " +player2.getVida());
            }else{
                System.out.println("A classe de " +player2.getNome()+ " nao permite que ele descanse e recupere seu HP.");
            }
        }
    }
}
