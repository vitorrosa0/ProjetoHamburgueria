package org.example;

import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido criarPedidoTradicional() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());
        return new Pedido(hamburguer);
    }

    @Test
    void deveAceitarUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        assertEquals(PedidoEstadoAceito.getInstancia(), pedido.getEstado());
    }

    @Test
    void devePrepararUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparacao.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveFicarProntoUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.pronto());
        assertEquals(PedidoEstadoPronto.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntrarEmRotaUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.emRota());
        assertEquals(PedidoEstadoEmRota.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntregarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntregarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveDevolverUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertTrue(pedido.devolver());
        assertEquals(PedidoEstadoDevolucao.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void naoDeveCancelarUmPedidoAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDeveEstarProntoUmPedidoAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveEstarEmRotaUmPedidoAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarUmPedidoAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.entregar());
    }

    @Test
    void naoDeveDevolverUmPedidoAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.devolver());
    }

    @Test
    void naoDeveAceitarUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertFalse(pedido.aceitar());
    }
    // ---- EmPreparacao (faltam 5, o aceitar já está) ----

    @Test
    void naoDeveEstarProntoUmPedidoEmPreparacao_SemChamarPronto() {
        // EmPreparacao não pode ir direto pra emRota
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertFalse(pedido.entregar());
    }

    @Test
    void naoDeveDevolverUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertFalse(pedido.devolver());
    }

    @Test
    void naoDevePrepararUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertFalse(pedido.preparar());
    }

    // ---- Pronto (faltam 4, cancelar/emRota/entregar já estão) ----

    @Test
    void naoDeveAceitarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveDevolverUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertFalse(pedido.devolver());
    }

    // ---- EmRota (faltam 4, cancelar/entregar já estão) ----

    @Test
    void naoDeveAceitarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveEstarProntoUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveDevolverUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertFalse(pedido.devolver());
    }

    // ---- Entregue (faltam 6, devolver já está) ----

    @Test
    void naoDeveAceitarUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveCancelarUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDeveEstarProntoUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveEstarEmRotaUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertFalse(pedido.entregar());
    }

    // ---- Devolucao (faltam 6, cancelar já está) ----

    @Test
    void naoDeveAceitarUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveEstarProntoUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveEstarEmRotaUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.entregar());
    }

    @Test
    void naoDeveDevolverUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertFalse(pedido.devolver());
    }

    // ---- Cancelado (todos os 7 são negativos) ----

    @Test
    void naoDeveAceitarUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDevePrepararUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.preparar());
    }

    @Test
    void naoDeveCancelarUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDeveEstarProntoUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.pronto());
    }

    @Test
    void naoDeveEstarEmRotaUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.emRota());
    }

    @Test
    void naoDeveEntregarUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.entregar());
    }

    @Test
    void naoDeveDevolverUmPedidoCancelado() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        assertFalse(pedido.devolver());
    }

    @Test
    void naoDeveAceitarUmPedidoJaAceito() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoAceito.getInstancia());
        assertFalse(pedido.aceitar());
    }

    @Test
    void naoDeveProntoUmPedidoJaPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertFalse(pedido.pronto());
    }

}