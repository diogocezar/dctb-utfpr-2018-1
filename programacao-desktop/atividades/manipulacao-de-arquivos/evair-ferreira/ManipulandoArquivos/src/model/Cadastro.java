package model;

import java.io.Serializable;

/**
 *
 * @author phoebo
 */
public class Cadastro implements Serializable {
    
    private String nome;
    private String endereco;
    private String uf;
    private String senha;

    public Cadastro(String nome, String endereco, String uf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.uf = uf;
        this.senha = senha;
    }
    
    public Cadastro(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cadastro{" + "nome=" + nome + ", endereco=" + endereco 
                + ", uf=" + uf + ", senha=" + senha + '}';
    }
}
