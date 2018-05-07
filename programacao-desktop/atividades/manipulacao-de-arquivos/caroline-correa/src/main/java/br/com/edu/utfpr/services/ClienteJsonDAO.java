/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edu.utfpr.services;

import br.com.edu.utfpr.convert.ClienteText;
import br.com.edu.utfpr.convert.Convertedor;
import br.com.edu.utfpr.domain.Cliente;
import br.com.edu.utfpr.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Caroline
 */
public class ClienteJsonDAO extends ClienteDAO {

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public ClienteJsonDAO(Convertedor convertedor) {
        super(convertedor);
        this.file = "clientes.json";
    }


}
