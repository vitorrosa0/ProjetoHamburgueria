package org.example.pedido;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.HamburgueriaFactory;
import org.example.pagamento.PagamentoCartao;
import org.example.pagamento.PagamentoDinheiro;
import org.example.preparo.PreparoGrelhado;
import org.example.produtos.Hamburguer;
import org.example.produtos.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoBuilderTest {

    @Test
    void deveRetornarExcecaoParaPedidoSemItemCardapio() {
        try {
            PedidoBuilder pedidoBuilder = new PedidoBuilder();
            Pedido pedido = pedidoBuilder
                    .setEstrategiaPagamento(new PagamentoCartao())
                    .setTarefaCozinha("Fritando a carne")
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Item do cardápio inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPedidoSemEstrategiaPagamento() {
        Hamburguer hamburguer = FabricaTradicional.getInstancia().criarBase(new PreparoGrelhado());
        Produto produto = new Produto(hamburguer, 25.0);

        try {
            PedidoBuilder pedidoBuilder = new PedidoBuilder();
            Pedido pedido = pedidoBuilder
                    .setItemCardapio(produto)
                    .setTarefaCozinha("Fritando a carne")
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Tipo de pagamento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPedidoCriado() {
        Hamburguer hamburguer = FabricaTradicional.getInstancia().criarBase(new PreparoGrelhado());
        Produto produto = new Produto(hamburguer, 25.0);

        Pedido pedido = new PedidoBuilder()
                .setItemCardapio(produto)
                .setEstrategiaPagamento(new PagamentoDinheiro())
                .setTarefaCozinha("Fritando a carne")
                .build();

        assertNotNull(pedido);
    }
}