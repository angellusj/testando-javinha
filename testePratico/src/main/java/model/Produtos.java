package model;

public class Produtos {
    private String nomeDoProduto;
    private String descricaoDoProduto;
    private double valorDoProduto;
    private boolean disponivelParaVenda;

    public Produtos(String nomeDoProduto, String descricaoDoProduto, double valorDoProduto, boolean disponivelParaVenda){
        this.nomeDoProduto = nomeDoProduto;
        this.descricaoDoProduto = descricaoDoProduto;
        this.valorDoProduto = valorDoProduto;
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public String getNomeDoProduto(){
        return nomeDoProduto;
    }

    public String getDescricaoDoProduto(){
        return descricaoDoProduto;
    }

    public double getValorDoProduto(){
        return valorDoProduto;
    }

    public boolean getDisponivelParaVenda(){
        return disponivelParaVenda;
    }

    public void setNomeDoProduto(String nomeDoProduto){
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setDescricaoDoProduto(String descricaoDoProduto){
        this.descricaoDoProduto = descricaoDoProduto;
    }

    public void setValorDoProduto(double valorDoProduto){
        this.valorDoProduto = valorDoProduto;
    }

    public void setDisponvelParaVenda(boolean disponivelParaVenda){
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public boolean disponivel(){
        return disponivelParaVenda = true;
    }

    public void naoDisponivel(){
        this.disponivelParaVenda = false;
    }

    public String toString(){
        String res = "Nome do Produto: " + nomeDoProduto;
        res += "\nDescricao: " + descricaoDoProduto;
        res += "\nValor: R$" + valorDoProduto;
        res += disponivelParaVenda ? "Sim\n" : "Não\n";

        return res;
    }
}