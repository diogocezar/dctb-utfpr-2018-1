package config;

/**
 *
 * @author christian
 */

/**
* Classe abstrata que contém atributos necessários
* para realizar a conexão com um banco de dados
*/
public abstract class Configuration {
    
    public String TYPE, HOST, USER, PASS, PORT, BASE, DRIV;
}
