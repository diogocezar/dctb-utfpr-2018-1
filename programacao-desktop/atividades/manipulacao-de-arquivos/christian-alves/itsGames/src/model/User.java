package model;

import java.io.Serializable;

/**
 *
 * @author christian
 */
public class User implements Serializable {
    
    private String name, password, email;
    
    public User(String name, String pwd, String email) {
        this.name = name;
        this.password = pwd;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public String toText() {
        String aux = "";
        
        aux += this.name + ";";
        aux += this.password + ";";
        aux += this.email + ";";
        
        return aux;
    }
    
}
