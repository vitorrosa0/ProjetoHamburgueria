package org.example.pedido;

import org.example.equipe.TarefaCozinha;
import org.example.pagamento.EstrategiaPagamento;
import org.example.produtos.ItemCardapio;

public class PedidoBuilder {

    private ItemCardapio itemCardapio;
    private EstrategiaPagamento estrategiaPagamento;
    private TarefaCozinha tarefaCozinha;

    public PedidoBuilder setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
        return this;
    }

    public PedidoBuilder setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
        return this;
    }

    public PedidoBuilder setTarefaCozinha(TarefaCozinha tarefaCozinha) {
        this.tarefaCozinha = tarefaCozinha;
        return this;
    }

    public Pedido build() {
        if (itemCardapio == null) {
            throw new NullPointerException("Item do cardápio inválido");
        }
        if (estrategiaPagamento == null) {
            throw new NullPointerException("Tipo de pagamento inválido");
        }
        Pedido pedido = new Pedido(itemCardapio);
        pedido.setEstrategiaPagamento(estrategiaPagamento);
        pedido.setTarefaCozinha(tarefaCozinha);
        return pedido;
    }
}