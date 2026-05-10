package org.example.pedido;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.HamburgueriaFactory;
import org.example.pagamento.PagamentoCartao;
import org.example.pagamento.PagamentoDinheiro;
import org.example.preparo.PreparoGrelhado;
import org.example.produtos.Hamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoBuilderTest {

    @Test
    void deveRetornarExcessaoParaPedidoSemHamburguer() {

        try {
            PedidoBuilder pedidoBuilder = new PedidoBuilder();
            Pedido pedido = pedidoBuilder
                    .setEstrategiaPagamento(new PagamentoCartao())
                    .setTarefaCozinha("Fritando a carne")
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Hamburguer inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcessaoParaPedidoSemEstrategiaPagamento() {

        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());

        try {
            PedidoBuilder pedidoBuilder = new PedidoBuilder();
            Pedido pedido = pedidoBuilder
                    .setHamburguer(hamburguer)
                    .setTarefaCozinha("Fritando a carne")
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Tipo de pagamento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoCriado() {

        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());

        PedidoBuilder pedidoBuilder = new PedidoBuilder();
        Pedido pedido = pedidoBuilder
                .setHamburguer(hamburguer)
                .setEstrategiaPagamento(new PagamentoDinheiro())
                .setTarefaCozinha("Fritando a carne")
                .build();

        assertNotNull(pedido);
    }

}