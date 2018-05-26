/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pokemon;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthu
 */
public class PokemonDAO {
    Connection con;
    public PokemonDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/pokedb";
        try {
            con = DriverManager.getConnection(url, "root", "athur12");
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Insere(Pokemon poke){
        PreparedStatement pst = null;
        String sql = "INSERT INTO pokemon VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst.setString(1, poke.getName());
            pst.setInt(2, poke.getLevel());
            pst.setInt(3, poke.getHp());
            pst.setInt(4, poke.getAgi());
            pst.setInt(5, poke.getAtk());
            pst.setInt(6, poke.getDef());
            pst.setInt(7, poke.getsAtk());
            pst.setInt(8, poke.getsDef());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Pokemon> lista(){
        Statement pst = null;
        ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
        ResultSet result = null;
        String sql = "select * from pokemon";
        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = pst.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(result.next()){
                String nome = result.getString("Pname");
                 int level = result.getInt("Plevel");
                 int hp = result.getInt("Php");
                 int agi = result.getInt("Pagi");
                 int atk = result.getInt("Patk");
                 int def = result.getInt("Pdef");
                 int satk = result.getInt("Pspatk");
                 int sdef = result.getInt("Pspdef");
                 Pokemon poke = new Pokemon(nome,level,hp,agi,atk,def,satk,sdef);
                 lista.add(poke);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
