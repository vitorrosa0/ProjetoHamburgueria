package org.example.pedido;

import org.example.pagamento.PagamentoPix;
import org.example.preparo.PreparoGrelhado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoPedidoTest {

    @Test
    void deveContarEstados() {
        Pedido pedido = Pedido.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.pronto();

        assertEquals(3, HistoricoPedido.contarEstados(pedido));
    }

    @Test
    void deveContarEstadosCancelados() {
        Pedido pedido = Pedido.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.cancelar();

        assertEquals(1, HistoricoPedido.contarEstadosCancelados(pedido));
    }
}