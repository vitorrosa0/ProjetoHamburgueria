package org.example.pagamento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaPagamentoAdapterTest {

    @Test
    void deveProcessarPagamentoPix() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoPix());
        assertEquals("[Pago via Pix]", moderno.processarPagamento());
    }

    @Test
    void deveProcessarPagamentoPixLegado() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoPix());
        SistemaPagamentoAdapter adaptador = new SistemaPagamentoAdapter(moderno);
        assertEquals("PAGAMENTO_PIX", adaptador.processarPagamentoLegado());
    }

    @Test
    void deveProcessarPagamentoCartao() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoCartao());
        assertEquals("[Pago via Cartão]", moderno.processarPagamento());
    }

    @Test
    void deveProcessarPagamentoCartaoLegado() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoCartao());
        SistemaPagamentoAdapter adaptador = new SistemaPagamentoAdapter(moderno);
        assertEquals("PAGAMENTO_CARTAO", adaptador.processarPagamentoLegado());
    }

    @Test
    void deveProcessarPagamentoDinheiro() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoDinheiro());
        assertEquals("[Pago via Dinheiro]", moderno.processarPagamento());
    }

    @Test
    void deveProcessarPagamentoDinheiroLegado() {
        ISistemaPagamento moderno = new SistemaPagamentoModerno(new PagamentoDinheiro());
        SistemaPagamentoAdapter adaptador = new SistemaPagamentoAdapter(moderno);
        assertEquals("PAGAMENTO_DINHEIRO", adaptador.processarPagamentoLegado());
    }
}