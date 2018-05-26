/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

/**
 *
 * @author luiz-
 */
public class ConfigMySQL extends Config {
    public ConfigMySQL(){
        
        //seta as variáveis a serem utilizadas na conexao
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "";
        super.PORT = "3306";
        super.BASE = "PokemonDataBase";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
    
}