package org.example.visitors;

import org.example.pagamento.PagamentoDinheiro;
import org.example.pagamento.PagamentoPix;
import org.example.pedido.PedidoFacade;
import org.example.preparo.PreparoGrelhado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPrecoComDescontoVisitorTest {

    @Test
    void deveCalcularDescontoDePedidoVeganoComFidelidade() {
        // preco * 0.1 - fidelidade = 22.0 * 0.1 - 2.0 = 0.2
        double desconto = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), true)
                .getItemCardapio()
                .aceitar(new CalculadoraPrecoComDescontoVisitor(2.0));

        assertEquals(0.2, desconto, 0.0001);
    }

    @Test
    void deveCalcularDescontoDeComboTradicionalComFidelidade() {
        // preco * 0.1 - fidelidade = 33.0 * 0.1 - 2.0 = 1.3
        double desconto = PedidoFacade.fazerCombo(new PreparoGrelhado(), new PagamentoDinheiro(), false)
                .getItemCardapio()
                .aceitar(new CalculadoraPrecoComDescontoVisitor(2.0));

        assertEquals(1.3, desconto, 0.0001);
    }

}