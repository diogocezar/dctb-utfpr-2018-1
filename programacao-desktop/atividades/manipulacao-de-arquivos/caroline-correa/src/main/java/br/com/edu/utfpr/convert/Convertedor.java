/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edu.utfpr.convert;

import br.com.edu.utfpr.domain.Cliente;
import com.google.gson.JsonElement;

/**
 *
 * @author Caroline
 */
public abstract class Convertedor<T, K> {
    
    public abstract K toString(T cliente);
    
    public abstract T toObject(String text);
}
