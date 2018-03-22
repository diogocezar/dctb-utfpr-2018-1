package rpg2;

/**
 *
 * @author luiz-
 */
public class RPG {
    public static void main(String[] args) {
        String vencedorSemi;
        Confronto semifinal = new Confronto();
        Confronto confrontoFinal = new Confronto();
         
        Heroi darkGlorysson = new Heroi("Dark Glorysson", "Humano", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        Heroi mellayne = new Heroi("Mellayne", "Humano", 5, 100, 80, 25, 10, 8, 2, 20, 10);
        Heroi gryin = new Heroi("Gryin", "Anão", 10, 100, 50, 30, 5, 10, 5, 1, 10);
        
        Monstro montaro = new Monstro("Montaro", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
        Monstro lordBlack = new Monstro("Lorde Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1);
        Monstro matilda = new Monstro("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 5);
        
        Confronto conf1 = new Confronto();
        String vencedor1 = conf1.iniciar(darkGlorysson, montaro);
        System.out.println("O vencedor do confronto eh: " + vencedor1);
        
        Confronto conf2 = new Confronto();
        String vencedor2 = conf2.iniciar(mellayne, matilda);
        System.out.println("O vencedor do confronto eh: " + vencedor2);
        
        Confronto conf3 = new Confronto();
        String vencedor3 = conf3.iniciar(gryin, lordBlack);
        System.out.println("O vencedor do confronto eh: " + vencedor3);
        
        
        
        if (vencedor2 == "Mellayne"){
            if (vencedor1 == "Montaro"){
                vencedorSemi = semifinal.iniciar(mellayne, montaro);
                System.out.println("O vencedor da semi final eh: " + vencedorSemi);
            } else {
                vencedorSemi = semifinal.iniciar (darkGlorysson, mellayne);
                System.out.println("O vencedor da semi final eh: " + vencedorSemi);
            }
        } else{
            if (vencedor1 == "Montaro"){
                vencedorSemi = semifinal.iniciar(montaro, matilda);
                System.out.println("O vencedor da semi final eh: " + vencedorSemi);
            } else{
                vencedorSemi = semifinal.iniciar(darkGlorysson, matilda);
                System.out.println("O vencedor da semi final eh: " + vencedorSemi);
            }
        }
        
        System.out.println("");
        System.out.println("Preparem-se para a final!!!");
        
        if (vencedor3 == "Lorde Black"){
            if (vencedorSemi == "Matilda"){
                String vencedorFinal  = confrontoFinal.iniciar(lordBlack, matilda);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else if (vencedorSemi == "Mellayne"){
                String vencedorFinal = confrontoFinal.iniciar(mellayne, lordBlack);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else if (vencedorSemi ==  "Montaro"){
                String vencedorFinal = confrontoFinal.iniciar(montaro, lordBlack);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else {
                String vencedorFinal = confrontoFinal.iniciar(darkGlorysson, lordBlack);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            }
        } else {
            if (vencedorSemi == "Matilda"){
                String vencedorFinal  = confrontoFinal.iniciar(gryin, matilda);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else if (vencedorSemi == "Mellayne"){
                String vencedorFinal = confrontoFinal.iniciar(mellayne, gryin);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else if (vencedorSemi ==  "Montaro"){
                String vencedorFinal = confrontoFinal.iniciar(gryin, montaro);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            } else {
                String vencedorFinal = confrontoFinal.iniciar(darkGlorysson, gryin);
                System.out.println("O vencedor da final eh: " + vencedorFinal);
                System.out.println("Parabens ao vencedor!!!");
            }
        }
    }
}