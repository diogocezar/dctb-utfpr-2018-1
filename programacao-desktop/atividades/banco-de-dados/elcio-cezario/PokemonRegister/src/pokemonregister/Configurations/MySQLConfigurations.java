/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonregister.Configurations;

/**
 *
 * @author ecsanchesjr
 */
public class MySQLConfigurations extends BDConfigurations {

    public MySQLConfigurations() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "";
        super.PORT = "3306";
        super.BASE = "desktop_pokemon";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}
