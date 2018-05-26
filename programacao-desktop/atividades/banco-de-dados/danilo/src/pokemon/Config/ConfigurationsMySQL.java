/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.Config;

/**
 *
 * @author Danilo
 */
public class ConfigurationsMySQL extends Configurations{
    public ConfigurationsMySQL() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "root";
        super.PORT = "3307";
        super.BASE = "pokemon_db";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}
