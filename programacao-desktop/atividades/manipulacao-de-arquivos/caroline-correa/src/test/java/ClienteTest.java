/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.edu.utfpr.convert.ClienteJson;
import br.com.edu.utfpr.domain.Cliente;
import br.com.edu.utfpr.services.ClienteBinDAO;
import br.com.edu.utfpr.services.ClienteDAO;
import br.com.edu.utfpr.services.ClienteJsonDAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caroline
 */
public class ClienteTest {
    
    public ClienteTest() {
    }

   @Test
   public void hello() {
       Cliente cliente = new Cliente(3, "Nome", "CPF", "Endereco", "Telefone", "Email");
       ClienteBinDAO binDAO = new ClienteBinDAO();
       
       System.out.println(binDAO.buscar(3).getNome());
       
   }
}
