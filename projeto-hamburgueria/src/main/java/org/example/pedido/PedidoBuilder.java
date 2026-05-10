package org.example.pedido;

import org.example.pagamento.EstrategiaPagamento;
import org.example.produtos.Hamburguer;

public class PedidoBuilder {

    private Hamburguer hamburguer;
    private EstrategiaPagamento estrategiaPagamento;
    private String tarefaCozinha;

    public PedidoBuilder setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        return this;
    }

    public PedidoBuilder setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
        return this;
    }

    public PedidoBuilder setTarefaCozinha(String tarefaCozinha) {
        this.tarefaCozinha = tarefaCozinha;
        return this;
    }

    public Pedido build() {
        if (hamburguer == null) {
            throw new NullPointerException("Hamburguer inválido");
        }

        if (estrategiaPagamento == null) {
            throw new NullPointerException("Tipo de pagamento inválido");
        }

        Pedido pedido = new Pedido(hamburguer);
        pedido.setEstrategiaPagamento(estrategiaPagamento);
        pedido.setTarefaCozinha(tarefaCozinha);
        return pedido;
    }
}
