package arquivos;

public class Cliente /*implements java.io.Serializable*/ {
    //private static final long serialVersionUID = 1335421L;
    private String nome;
    private String fone;
    private int idade;
    private String CPF;
    //private String email;

    private Cliente() {
        nome = "não informado";
        fone = "não informado";
        idade = 0;
    }
    
    public Cliente (int idade){
        this.idade = idade;
    }

    @Override
    public String toString() {
        if (this != null) {
            return (nome +"  "+fone+" "+idade+" "+CPF);
        } else {
            return (null);
        }
    }

    public Cliente(String nm, String fon, int id) {
        nome = nm;
        fone = fon;
        idade = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
