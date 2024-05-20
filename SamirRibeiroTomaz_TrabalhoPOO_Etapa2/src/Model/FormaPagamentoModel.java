package Model;

public abstract class FormaPagamentoModel {
    public abstract String getDescricao();
    public abstract void efetuarPagamento(double valorTotal);
}
