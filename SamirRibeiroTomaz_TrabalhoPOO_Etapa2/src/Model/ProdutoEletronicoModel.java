package Model;

public class ProdutoEletronicoModel extends ProdutoModel {

    @Override
    public String getTipoProduto() {
        return "Eletrônico";
    }
    
    public ProdutoEletronicoModel(int codigo, String nome, String descricao, double precoCusto, double precoVenda,
                                  int quantidadeEstoque, String categoria) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
    }
}
