package org.example.visitors;

import org.example.pagamento.PagamentoDinheiro;
import org.example.pagamento.PagamentoPix;
import org.example.pedido.PedidoFacade;
import org.example.preparo.PreparoGrelhado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraPrecoVisitorTest {

    private final CalculadoraPrecoVisitor visitor = new CalculadoraPrecoVisitor();

    @Test
    void deveCalcularPrecoDePedidoTradicional() {
        double preco = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false)
                .getItemCardapio()
                .aceitar(visitor);

        assertEquals(25.0, preco);
    }

    @Test
    void deveCalcularPrecoDePedidoVegano() {
        double preco = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), true)
                .getItemCardapio()
                .aceitar(visitor);

        assertEquals(22.0, preco);
    }

    @Test
    void deveCalcularPrecoDeComboTradicional() {
        double preco = PedidoFacade.fazerCombo(new PreparoGrelhado(), new PagamentoDinheiro(), false)
                .getItemCardapio()
                .aceitar(visitor);

        assertEquals(33.0, preco);
    }

    @Test
    void deveCalcularPrecoDeComboVegano() {
        double preco = PedidoFacade.fazerCombo(new PreparoGrelhado(), new PagamentoPix(), true)
                .getItemCardapio()
                .aceitar(visitor);

        assertEquals(30.0, preco);
    }
}