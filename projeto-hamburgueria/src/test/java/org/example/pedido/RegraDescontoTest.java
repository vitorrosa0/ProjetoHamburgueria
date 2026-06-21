package org.example.pedido;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegraDescontoTest {

    @Test
    void deveCalcularDescontoComFormulaPadrao() {
        // preco * 0.1 - fidelidade = 100.0 * 0.1 - 5.0 = 5.0
        double desconto = RegraDesconto.calcularDesconto(100.0, 5.0);
        assertEquals(5.0, desconto);
    }

    @Test
    void deveCalcularDescontoSemBonusFidelidade() {
        // preco * 0.1 - fidelidade = 200.0 * 0.1 - 0.0 = 20.0
        double desconto = RegraDesconto.calcularDesconto(200.0, 0.0);
        assertEquals(20.0, desconto);
    }

    @Test
    void deveRespeitorFormulaTrocada() {
        String formulaOriginal = RegraDesconto.formula;
        try {
            RegraDesconto.formula = "preco * 0.2 - fidelidade";
            // preco * 0.2 - fidelidade = 100.0 * 0.2 - 5.0 = 15.0
            double desconto = RegraDesconto.calcularDesconto(100.0, 5.0);
            assertEquals(15.0, desconto);
        } finally {
            RegraDesconto.formula = formulaOriginal;
        }
    }

    @Test
    void deveLancarExcecaoParaExpressaoInvalida() {
        String formulaOriginal = RegraDesconto.formula;
        try {
            RegraDesconto.formula = "preco *";
            RegraDesconto.calcularDesconto(100.0, 5.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        } finally {
            RegraDesconto.formula = formulaOriginal;
        }
    }
}