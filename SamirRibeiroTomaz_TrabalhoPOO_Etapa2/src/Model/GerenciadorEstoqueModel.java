package Model;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorEstoqueModel {
    private Map<ProdutoModel, Integer> estoque;

    public GerenciadorEstoqueModel() {
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(ProdutoModel produto, int quantidadeEstoque) {
        if (estoque.containsKey(produto)) {
            int quantidadeAtual = estoque.get(produto);
            estoque.put(produto, quantidadeAtual + quantidade);
        } else {
            estoque.put(produto, quantidade);
        }
    }

    public void removerProduto(ProdutoModel produto, int quantidadeEstoque) {
        if (estoque.containsKey(produto)) {
            int quantidadeAtual = estoque.get(produto);
            if (quantidadeAtual <= quantidade) {
                estoque.remove(produto);
            } else {
                estoque.put(produto, quantidadeAtual - quantidade);
            }
        }
    }

    public int verificarQuantidadeProduto(ProdutoModel produto) {
        return estoque.getOrDefault(produto, 0);
    }
}
