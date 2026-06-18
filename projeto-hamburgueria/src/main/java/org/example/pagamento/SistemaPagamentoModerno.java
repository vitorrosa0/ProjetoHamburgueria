package org.example.pagamento;

public class SistemaPagamentoModerno implements ISistemaPagamento {

    private EstrategiaPagamento estrategia;

    public SistemaPagamentoModerno(EstrategiaPagamento estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public String processarPagamento() {
        return estrategia.descricao();
    }
}