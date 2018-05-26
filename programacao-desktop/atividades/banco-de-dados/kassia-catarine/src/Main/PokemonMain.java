/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAO.Interfaces.PokemonDAO;
import DAO.MySQL.PokemonMySQL;
import java.util.ArrayList;
import java.util.Scanner;
import models.Pokemon;

/**
 *
 * @author kassia
 */
public class PokemonMain {
    static public PokemonDAO getPokemonDB(){
        return new PokemonMySQL();
    }
    
    public static void main(String[] args) {
        int i;
        int id = 0;
        String nome;
        Scanner in = new Scanner(System.in);
        
        PokemonDAO db = PokemonMain.getPokemonDB();
        
        do {
            i = menu();
            if (i == 1) {
                System.out.println("Digite o nome do pokemon:\n");
                nome = in.nextLine();
                db.insert(new Pokemon(++id, nome));
            } else if (i == 0) {
                ArrayList<Pokemon> all = db.getAll();
                for(Pokemon one : all){
                    System.out.println(one.getName());
                }
                System.out.println("\n\nBye");
            }
        } while (i != 0);
    }
    
    public static int menu() {
        System.out.println("\t\tMenu\n1 - Cadastrar Pokemon\n0 - Sair");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
