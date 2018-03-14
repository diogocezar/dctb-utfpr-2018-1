
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

            /*exemplos de implementação dos monstros e herois
            
            if(monstro1.getForca() > heroi1.getForca()){
                System.out.println(""+monstro1.getNome()+ " eh mais forte que" + " " +heroi1.getNome());
            }

            System.out.println("Bencao do "+heroi1.getNome() +": "+heroi1.getBencao());
            */
        }        



}
