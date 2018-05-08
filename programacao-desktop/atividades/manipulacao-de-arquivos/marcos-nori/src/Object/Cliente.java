
package Object;
import java.io.Serializable;
/**
 *
 * @author Joao Pirolo
 */
public class Cliente implements Serializable{
    private String nome;
    private String cpf;
    private String endereco;
    private String cidade;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, String endereco, String cidade, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente() {
 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString() {
        return  nome + "\n" + cpf + "\n" + endereco + "\n" + cidade + "\n"
                + email + "\n" + telefone + "\n";
    } 
   
}
