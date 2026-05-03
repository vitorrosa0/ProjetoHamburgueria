package org.example.pagamento;

public class PagamentoCartao implements EstrategiaPagamento {

    public String descricao() {
        return "[Pago via Cartão]";
    }
}
