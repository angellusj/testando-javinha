package control;

import model.Produtos;

public class ProdutoController {
    public static Produtos criaProduto(String nomeDoProduto, String descricaoDoProduto, double valorDoProduto, boolean disponivelParaVenda){

        if (nomeDoProduto == null || nomeDoProduto.trim().isEmpty()){
            throw new IllegalArgumentException("Nome do produto não pode ser nulo,\n");
        }

        if(descricaoDoProduto == null){
            throw new IllegalArgumentException("Descrição do produto não pode ser nulo.\n");
        }

        if (descricaoDoProduto.trim().isEmpty()){
            throw new IllegalArgumentException("Descrição do produto não pode ser vazio.\n");
        }

        if (valorDoProduto <= 0.0){
            throw new IllegalArgumentException("Valor do produto não pode ser menor ou igual a zero.\n");
        }

        return new Produtos(nomeDoProduto, descricaoDoProduto, valorDoProduto, disponivelParaVenda);
    }

}
