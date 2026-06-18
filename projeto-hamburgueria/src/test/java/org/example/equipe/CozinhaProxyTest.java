package org.example.equipe;

import org.example.pagamento.PagamentoPix;
import org.example.pedido.Pedido;
import org.example.pedido.PedidoEstadoEmPreparacao;
import org.example.pedido.PedidoFacade;
import org.example.preparo.PreparoGrelhado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CozinhaProxyTest {

    @Test
    void deveProcessarPedidoEmPreparacao() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());

        String resultado = new CozinhaProxy().processarTarefa(pedido);

        assertEquals("ChefChapa", resultado);
    }

    @Test
    void deveBarrarPedidoForaDePreparacao() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        // estado inicial: Aceito

        try {
            new CozinhaProxy().processarTarefa(pedido);
            fail();
        } catch (IllegalStateException e) {
            assertEquals("Pedido não está em preparação", e.getMessage());
        }
    }

    @Test
    void deveBarrarPedidoCancelado() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.cancelar();

        try {
            new CozinhaProxy().processarTarefa(pedido);
            fail();
        } catch (IllegalStateException e) {
            assertEquals("Pedido não está em preparação", e.getMessage());
        }
    }
}