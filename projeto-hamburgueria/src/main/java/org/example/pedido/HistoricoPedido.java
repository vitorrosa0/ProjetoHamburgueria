package org.example.pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HistoricoPedido implements Iterable<PedidoEstado> {

    private List<PedidoEstado> estados = new ArrayList<>();

    public void salvar(PedidoEstado estado) {
        estados.add(estado);
    }

    public PedidoEstado restaurar(int indice) {
        if (indice < 0 || indice > estados.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        return estados.get(indice);
    }

    public int tamanho() {
        return estados.size();
    }

    @Override
    public Iterator<PedidoEstado> iterator() {
        return estados.iterator();
    }

    public static int contarEstados(Pedido pedido) {
        int quantidade = 0;
        for (Iterator<PedidoEstado> it = pedido.getHistorico().iterator(); it.hasNext(); ) {
            quantidade++;
            it.next();
        }
        return quantidade;
    }

    public static int contarEstadosCancelados(Pedido pedido) {
        int quantidade = 0;
        for (PedidoEstado estado : pedido.getHistorico()) {
            if (estado instanceof PedidoEstadoCancelado) {
                quantidade++;
            }
        }
        return quantidade;
    }
}
