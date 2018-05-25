package config;

/**
 *
 * @author christian
 */

/**
 * 
 * Classe que extende a classe abstrata @see Configuration
 */
public class ConfigurationMySql extends Configuration {
    
    public ConfigurationMySql() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "alves";
        super.PORT = "3306";
        super.BASE = "desktop";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
    
}
