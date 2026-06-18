package org.example.equipe;

import org.example.pedido.Pedido;
import org.example.pedido.PedidoEstadoEmPreparacao;

public class CozinhaProxy implements ICozinha {

    private Cozinha cozinha;

    @Override
    public String processarTarefa(Pedido pedido) {
        if (pedido.getEstado() != PedidoEstadoEmPreparacao.getInstancia()) {
            throw new IllegalStateException("Pedido não está em preparação");
        }
        if (this.cozinha == null) {
            this.cozinha = Cozinha.getInstance();
        }
        return this.cozinha.processarTarefa(pedido);
    }
}