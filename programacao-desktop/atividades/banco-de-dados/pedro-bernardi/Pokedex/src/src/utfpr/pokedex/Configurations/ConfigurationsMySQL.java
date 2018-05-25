
package src.utfpr.pokedex.Configurations;

public class ConfigurationsMySQL extends Configurations {
    public ConfigurationsMySQL(){
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "";
        super.PORT = "3306";
        super.BASE = "pokedex";
        super.DRIV = "com.mysql.jdbc.Driver";
        super.SSL = "&useSSL=false";
    }
}
