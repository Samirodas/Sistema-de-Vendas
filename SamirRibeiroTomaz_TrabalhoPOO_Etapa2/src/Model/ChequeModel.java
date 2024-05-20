package Model;

public class ChequeModel extends FormaPagamentoModel {
    @Override
    public String getDescricao() {
        return "Pagamento com cheque";
    }

    @Override
    public void efetuarPagamento(double valorTotal) {
        
    }
}
