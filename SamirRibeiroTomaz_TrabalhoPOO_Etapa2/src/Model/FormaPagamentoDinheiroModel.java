package Model;

public class FormaPagamentoDinheiroModel extends FormaPagamentoModel {
    @Override
    public String getDescricao() {
        return "Pagamento em dinheiro";
    }

    @Override
    public void efetuarPagamento(double valorTotal) {
        System.out.println("Pagamento em dinheiro no valor de R$" + valorTotal);
    }
}
