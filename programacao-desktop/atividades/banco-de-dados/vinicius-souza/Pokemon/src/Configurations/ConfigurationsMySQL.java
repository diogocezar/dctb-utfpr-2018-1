package Configurations;

public class ConfigurationsMySQL extends Configurations {
    public ConfigurationsMySQL(){
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "utfpr";
        super.PORT = "3306";
        super.BASE = "utfpr_tests";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}