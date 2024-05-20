package Model;

public class FormaPagamentoCartaoModel extends FormaPagamentoModel {
    @Override
    public String getDescricao() {
        return "Pagamento com cartão";
    }

    @Override
    public void efetuarPagamento(double valorTotal) {
        System.out.println("Pagamento com cartão no valor de R$" + valorTotal);
    }
}
