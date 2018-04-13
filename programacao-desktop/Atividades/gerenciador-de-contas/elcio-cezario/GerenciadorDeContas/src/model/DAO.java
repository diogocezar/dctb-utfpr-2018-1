/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ecsanchesjr
 */
public class DAO {
    private ArrayList<Account> Contas= new ArrayList<>();

    public ArrayList<Account> getContas() {
        return Contas;
    }

    public void setContas(ArrayList<Account> Contas) {
        this.Contas = Contas;
    }
    public void addToContas(Account conta){
        Contas.add(conta);
    }
    
    private DAO() {
    }
    
    public static DAO getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {

        private static final DAO INSTANCE = new DAO();
    }
}
