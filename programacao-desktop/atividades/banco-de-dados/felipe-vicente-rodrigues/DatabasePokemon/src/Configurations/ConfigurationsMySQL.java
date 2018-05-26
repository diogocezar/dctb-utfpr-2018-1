/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

/**
 *
 * @author felipe
 */
public class ConfigurationsMySQL extends Configurations {

    public ConfigurationsMySQL() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "root";
        super.PORT = "3306";
        super.BASE = "database_pokemon";
        super.DRIV = "com.mysql.jdbc.Driver";
    }

    /*
    SCRIPT - CREATE DATABASE
    
    CREATE DATABASE database_pokemon;

CREATE TABLE database_pokemon.pokemon (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(150) NOT NULL,
	PRIMARY KEY (id)
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
     */
}
