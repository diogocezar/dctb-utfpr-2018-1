/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

/**
 *
 * @author kamimuraf
 */
public class ConfigurationsMySQL extends Configurations {
        public ConfigurationsMySQL(){
            super.TYPE = "mysql";
            super.HOST = "localhost";
            super.USER = "root";
            super.PASS = "senhaSQL";
            super.PORT = "3306";
            super.BASE = "cadPokemon";
            super.DRIV = "com.mysql.jdbc.Driver";
        }
}
