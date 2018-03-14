public class Confrontation 
{
    public static void main(String[] args)
    {

        Hero hero = new Hero("DARK GLORYSSON", "Humano", 8, 100, 100, 10, 5, 10, 15, 2, 10);
        hero.__toString();
        System.out.println("");
        Monster monster = new Monster("MONTARO", "Elfo das Trevas", 7, 100, 100, 10, 5, 10, 15, 10);
        monster.__toString();
    }
}