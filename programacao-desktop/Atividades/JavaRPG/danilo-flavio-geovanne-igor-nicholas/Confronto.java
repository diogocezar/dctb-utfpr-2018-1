public class Confronto
{
    Confronto(Criatura player1, Criatura player2){
        iniciar(player1, player2);
    }
    public static void main()
    {   

    }

    public void iniciar(Criatura player1, Criatura player2)
    {
        int vez = 2;
        int turno = 1;
        while(player1.getVida()>0 && player2.getVida()>0){
            System.out.println("--Turno "+turno+"--");
            if(vez==2){
                vez = 1;
                player1.perdeVida(player2.atacar());
            //    System.out.println("Vida do "+player1.getNome() +": "+player1.getVida());
            //    System.out.println("Vida do "+player2.getNome() +": "+player2.getVida());
                System.out.println("\n");   
            }
            else{
                vez = 2;
                player2.perdeVida(player1.atacar());
                System.out.println("\n");
            }
            turno++;
        }
        if(player1.getVida()>0) 
            System.out.println("O "+player1.getNome()+" ganhou a luta com "+player1.getVida()+" pontos de vida.");
        else
             System.out.println("O "+player2.getNome()+" ganhou a luta com "+player2.getVida()+" pontos de vida.");
    }
}
