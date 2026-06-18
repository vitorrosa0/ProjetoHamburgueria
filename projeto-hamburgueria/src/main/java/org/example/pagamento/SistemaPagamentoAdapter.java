package org.example.pagamento;

public class SistemaPagamentoAdapter extends SistemaPagamentoLegado {

    private ISistemaPagamento sistemaModerno;

    public SistemaPagamentoAdapter(ISistemaPagamento sistemaModerno) {
        this.sistemaModerno = sistemaModerno;
    }

    public String processarPagamentoLegado() {
        String descricao = sistemaModerno.processarPagamento();

        if (descricao.contains("Dinheiro")) return processarPagamentoLegado(1);
        if (descricao.contains("Cartão"))   return processarPagamentoLegado(2);
        if (descricao.contains("Pix"))      return processarPagamentoLegado(3);
        throw new IllegalArgumentException("Estratégia de pagamento não reconhecida: " + descricao);
    }
}