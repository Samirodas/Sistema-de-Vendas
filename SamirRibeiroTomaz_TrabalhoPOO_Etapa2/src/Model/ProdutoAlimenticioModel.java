package Model;

public class ProdutoAlimenticioModel extends ProdutoModel {

    @Override
    public String getTipoProduto() {
        return "Alimentício";
    }
    
    public ProdutoAlimenticioModel(int codigo, String nome, String descricao, double precoCusto, double precoVenda,
                                   int quantidadeEstoque, String categoria) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
    }
}
