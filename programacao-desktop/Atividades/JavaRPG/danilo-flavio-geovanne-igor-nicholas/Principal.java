import java.util.Scanner;

public class Principal{
        public static void main(String args[]){
            
            int[] vencedor;
            vencedor =  new int[4];
            int flag = 0;

            //nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma
            monstro1 = new Monstro("Montaro", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
            monstro2 = new Monstro("Lord Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1);
            monstro3 = new Monstro("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 5);
                        
            //nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma, bencao
            heroi1 = new Heroi("Dark Gloryson", "Humano", 8, 100, 10, 100, 5, 10, 15, 2, 10);
            heroi2 = new Heroi("Mellayne", "Humano", 5, 100, 25, 80, 10, 8, 2, 20, 10);
            heroi3 = new Heroi("Gryin", "Anao", 10, 100, 30, 50, 5, 10, 5, 1, 10);

            Confronto rodada1 = new Confronto(heroi1, monstro1, vencedor[flag]);
            flag +=1;
            Confronto rodada2 = new Confronto(heroi2, monstro3, vencedor[flag]);
            flag +=1;
            Confronto rodada3 = new Confronto(heroi3, monstro2, vencedor[flag]);
            flag +=1;
            Confronto rodada4 = new Confronto(vencedor[0], vencedor[1], vencedor[flag]);
            Confronto rodada5 = new Confronto(vencedor[3], vencedor[1], vencedor[flag]);
            
            

            
            /*exemplos de implementação dos monstros e herois
            
            if(monstro1.getForca() > heroi1.getForca()){
                System.out.println(""+monstro1.getNome()+ " eh mais forte que" + " " +heroi1.getNome());
            }

            System.out.println("Bencao do "+heroi1.getNome() +": "+heroi1.getBencao());
            */

        }
}
