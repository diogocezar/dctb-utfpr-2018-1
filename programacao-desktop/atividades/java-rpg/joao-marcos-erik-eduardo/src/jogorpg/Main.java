package jogorpg;

/**
 *
 * @author Erik Lima
 */
public class Main {
   public static void main(String[]agrs){
       
     Creature vencedor[] = new Creature[5];
        
        Hero h1 = new Hero("Dark Glorysson", "Humano", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        Hero h2 = new Hero("Mellayne", "Humano", 5, 100, 80, 25, 10, 8, 2, 20,10);
        Hero h3 = new Hero("Gryn", "Anão", 10, 100, 50,30, 5, 10, 5, 1,10);
        Monster m1 = new Monster("Montaro","Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
        Monster m2 = new Monster("Lord Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1);
        Monster m3 = new Monster("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 15);
        
             h1._toString();
             System.out.println("\n");
             m1._toString();
             vencedor[0] = battle.Iniciar(h1, m1);
             System.out.println("Vencedor " + vencedor[0].getNome());
             
             
             
             System.out.println("================================\n\n");
             h2._toString();
             System.out.println("\n");
             m3._toString();
             vencedor[1] = battle.Iniciar(h2, m3);
             System.out.println("Vencedor " + vencedor[1].getNome());
             
             
             System.out.println("================================\n\n");
            h3._toString();
            System.out.println("\n");
            m2._toString();
             vencedor[2] = battle.Iniciar(h3, m2);
             System.out.println("Vencedor " + vencedor[2].getNome());
             
             System.out.println("================================\n\n");
             vencedor[0]._toString();
             System.out.println("\n");
             vencedor[1]._toString();
             vencedor[3] = battle.Iniciar(vencedor[0], vencedor[1]);
             System.out.println("Vencedor " + vencedor[3].getNome());
             
             
             System.out.println("================================\n\n");
             vencedor[2]._toString();
             System.out.println("\n");
             vencedor[3]._toString();
             vencedor[4] = battle.Iniciar(vencedor[2],vencedor[3]);
             System.out.println("Campeão " + vencedor[4].getNome());
             
        
   }
    
}
