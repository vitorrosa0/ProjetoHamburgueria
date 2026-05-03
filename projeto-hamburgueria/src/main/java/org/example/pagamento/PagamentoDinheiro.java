package org.example.pagamento;

public class PagamentoDinheiro implements EstrategiaPagamento {

    public String descricao() {
        return "[Pago via Dinheiro]";
    }
}
