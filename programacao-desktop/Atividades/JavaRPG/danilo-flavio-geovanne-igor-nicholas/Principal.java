import java.util.Scanner;

public class Principal{
        public static void main(String args[]){

            //nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma
            Monstro monstro1 = new Monstro("Montaro", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
            Monstro monstro2 = new Monstro("Lord Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1);
            Monstro monstro3 = new Monstro("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 5);
                        
            //nome, classe, nivel, vida, forca, magia, agilidade, destreza, inteligencia, carisma, bencao
            Heroi heroi1 = new Heroi("Dark Gloryson", "Humano", 8, 100, 10, 100, 5, 10, 15, 2, 10);
            Heroi heroi2 = new Heroi("Mellayne", "Humano", 5, 100, 25, 80, 10, 8, 2, 20, 10);
            Heroi heroi3 = new Heroi("Gryin", "Anao", 10, 100, 30, 50, 5, 10, 5, 1, 10);

            Confronto rodada1 = new Confronto(heroi1, monstro1);
            Confronto rodada2 = new Confronto(heroi2, monstro3);
            Confronto rodada3 = new Confronto(heroi3, monstro2);
            Confronto rodada4 = new Confronto(rodada1.getVencedor(), rodada2.getVencedor());
            Confronto rodada5 = new Confronto(rodada4.getVencedor(), rodada3.getVencedor());
            
        }
}
