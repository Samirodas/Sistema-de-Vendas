package Model;

public class CartaoModel extends FormaPagamentoModel {
    @Override
    public String getDescricao() {
        return "Pagamento com cartão";
    }

    @Override
    public void efetuarPagamento(double valorTotal) {
        
    }
}
