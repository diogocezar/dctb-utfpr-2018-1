/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edu.utfpr.convert;

import br.com.edu.utfpr.domain.Cliente;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;

/**
 *
 * @author Caroline
 */
public class ClienteJson extends Convertedor<Cliente, String> {

    public String toString(Cliente cliente) {
        Gson gson = new Gson();
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        return gson.toJson(cliente)+"\n";
    }

    public Cliente toObject(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Cliente.class);
    }

}
