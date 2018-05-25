package Configurations;

/**
 *
 * @author igorv
 */
public class ConfigurationsMySQL extends Configurations {
    public ConfigurationsMySQL(){
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "mysql";
        super.PORT = "3306";
        super.BASE = "java_pokemon";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}