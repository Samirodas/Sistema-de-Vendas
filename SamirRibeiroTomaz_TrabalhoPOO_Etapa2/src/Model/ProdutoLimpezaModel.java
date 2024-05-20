package Model;

public class ProdutoLimpezaModel extends ProdutoModel {
    @Override
    public String getTipoProduto() {
        return "Limpeza";
    }

    public ProdutoLimpezaModel(int codigo, String nome, String descricao, double precoCusto, double precoVenda,
                               int quantidadeEstoque, String categoria) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
    }
}
