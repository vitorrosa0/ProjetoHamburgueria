package org.example.pedido;

import java.util.Iterator;

public class HistoricoPedido {

    public static Integer contarEstados(Pedido pedido) {
        int quantidade = 0;
        for (Iterator<PedidoEstado> it = pedido.iterator(); it.hasNext(); ) {
            quantidade++;
            it.next();
        }
        return quantidade;
    }

    public static Integer contarEstadosCancelados(Pedido pedido) {
        int quantidade = 0;
        for (PedidoEstado estado : pedido) {
            if (estado instanceof PedidoEstadoCancelado) {
                quantidade++;
            }
        }
        return quantidade;
    }
}
