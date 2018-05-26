/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

/**
 *
 * @author JOAO
 */
public class ConfigurationsMysql extends Configurations {
    public ConfigurationsMysql(){
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "";
        super.PORT = "3306";
        super.BASE = "Pokemon";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
    
}
