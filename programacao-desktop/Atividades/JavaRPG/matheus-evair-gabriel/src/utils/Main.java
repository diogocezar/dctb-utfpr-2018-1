package utils;

public class Main {

    public static void main(String[] args){
        Hero hero1 = new Hero("Dark Glorysson", "Humano", 8, 100, 100, 10, 5, 10, 15, 02, 10);
        Hero hero2 = new Hero("Mellayne", "Humano", 5, 100, 80, 25, 10, 8, 2, 20, 10);
        Hero hero3 = new Hero("Gryin", "Anão", 01, 100, 50, 30, 5, 10, 5, 1, 10);
        
        Monster monster1 = new Monster("Montaro", "Elfo da Trevas", 7, 100, 100, 10, 5, 10, 15, 10, null);
        Monster monster2 = new Monster("Matilda", "Elfa", 10, 100, 80, 10, 8, 10, 18, 5, null);
        Monster monster3 = new Monster("Lord Black", "Humano", 10, 100, 20, 32, 12, 10, 10, 1, null);
        
        Creature winner1;
        Creature winner2;
        Creature winner3;
        Creature winner4;
        Creature champion;
        
        Battle battle = new Battle();
        
        System.out.println("1ª Batalha!");
        winner1 = battle.confrontation(monster1, hero1);
        System.out.println("\n2ª Batalha!");
        winner2 = battle.confrontation(monster2, hero2);
        System.out.println("\n3ª Batalha!");
        winner3 = battle.confrontation(monster3, hero3);
        System.out.println("\n4ª Batalha!");
        winner4 = battle.confrontation(winner1, winner2);
        System.out.println("\nBatalha Final !!!");
        champion = battle.confrontation(winner4, winner3);
        
        System.out.println("\nO campeão do Torneio foi " + champion.getName());
    }
    
}
