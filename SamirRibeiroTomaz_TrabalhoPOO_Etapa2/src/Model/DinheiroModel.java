package Model;

public class DinheiroModel extends FormaPagamentoModel {
    @Override
    public String getDescricao() {
        return "Pagamento em dinheiro";
    }

    @Override
    public void efetuarPagamento(double valorTotal) {
     
    }
}
