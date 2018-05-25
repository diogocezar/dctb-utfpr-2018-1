
package Configurations;

public class ConfigurationsMySQL extends Configurations {
    public ConfigurationsMySQL(){
        super.TYPE = "mysql";
        super.HOST = "aaw9ag1ubjow00.cqvp2jcb562b.sa-east-1.rds.amazonaws.com";
        super.USER = "root";
        super.PASS = "rootroot";
        super.PORT = "3306";
        super.BASE = "desktopdb";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}
