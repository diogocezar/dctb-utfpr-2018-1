
package Model;

/**
 *
 * @author Erik Lima
 */
public class Produto {
    private int codProduto;
    private double precoProduto;
    private String nomeProduto;
    private double pesoProduto;
    private String marcaProduto;
    private int quantidadeProduto;

    public Produto(int codProduto, double precoProduto, String nomeProduto, double pesoProduto, String marcaProduto, int quantidadeProduto) {
        this.codProduto = codProduto;
        this.precoProduto = precoProduto;
        this.nomeProduto = nomeProduto;
        this.pesoProduto = pesoProduto;
        this.marcaProduto = marcaProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(double pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    
}
