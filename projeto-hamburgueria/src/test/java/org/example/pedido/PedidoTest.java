package org.example.pedido;

import org.example.equipe.TarefaCozinhaFritar;
import org.example.equipe.TarefaCozinhaMontar;
import org.example.pagamento.PagamentoCartao;
import org.example.pagamento.PagamentoDinheiro;
import org.example.pagamento.PagamentoPix;
import org.example.preparo.PreparoGrelhado;
import org.example.preparo.PreparoNaChapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido criarPedidoTradicional() {
        return PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
    }

    @Test
    void deveAceitarUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(pedido.getEstado());
        assertEquals("Pedido atualizado para: Aceito", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void devePrepararUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(pedido.getEstado());
        assertTrue(pedido.preparar());
        assertEquals("Pedido atualizado para: Em preparacao", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveCancelarUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals("Pedido atualizado para: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveFicarProntoUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.pronto());
        assertEquals("Pedido atualizado para: Pronto", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveCancelarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals("Pedido atualizado para: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveEntrarEmRotaUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.emRota());
        assertEquals("Pedido atualizado para: Em rota", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveEntregarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals("Pedido atualizado para: Entregue", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveCancelarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals("Pedido atualizado para: Cancelado", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveEntregarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals("Pedido atualizado para: Entregue", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveDevolverUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertTrue(pedido.devolver());
        assertEquals("Pedido atualizado para: Devolvido", pedido.getEstado().getUltimaNotificacao());
    }

    @Test
    void deveCancelarUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals("Pedido atualizado para: Cancelado", pedido.getEstado().getUltimaNotificacao());
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

    @Test
    void naoDeveEstarProntoUmPedidoEmPreparacao_SemChamarPronto() {
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

    @Test
    void deveRetornarMetodoPagamentoPix() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setEstrategiaPagamento(new PagamentoPix());
        assertEquals("[Pago via Pix]", pedido.getEstrategiaPagamento().descricao());
    }

    @Test
    void deveRetornarMetodoPagamentoCartao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setEstrategiaPagamento(new PagamentoCartao());
        assertEquals("[Pago via Cartão]", pedido.getEstrategiaPagamento().descricao());
    }

    @Test
    void deveRetornarMetodoPagamentoDinheiro() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setEstrategiaPagamento(new PagamentoDinheiro());
        assertEquals("[Pago via Dinheiro]", pedido.getEstrategiaPagamento().descricao());
    }

    @Test
    void deveChefChapaAssumirFritura() {
        Pedido pedido = criarPedidoTradicional();
        // tarefaCozinha already set to TarefaCozinhaFritar by PedidoFacade
        assertEquals("ChefChapa", pedido.processarNaCozinha());
    }

    @Test
    void deveChefMontagemAssumirAMontagem() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setTarefaCozinha(TarefaCozinhaMontar.getInstancia());
        assertEquals("ChefMontagem", pedido.processarNaCozinha());
    }

    @Test
    void deveFazerPedidoTradicionalGrelhadoViaPix() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        assertEquals("Produto: [Tradicional] Pão: Pão Brioche, Carne: Carne bovina - grelhado na brasa - R$25.0\n",
                pedido.getItemCardapio().getConteudo());
        assertEquals("[Pago via Pix]", pedido.getEstrategiaPagamento().descricao());
    }

    @Test
    void deveFazerPedidoVeganoNaChapaViaCartao() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoNaChapa(), new PagamentoCartao(), true);
        assertEquals("Produto: [Vegano] Pão: Pão Integral, Carne: Grão de Bico - na chapa - R$22.0\n",
                pedido.getItemCardapio().getConteudo());
        assertEquals("[Pago via Cartão]", pedido.getEstrategiaPagamento().descricao());
    }

    @Test
    void deveFazerComboTradicionalGrelhado() {
        Pedido pedido = PedidoFacade.fazerCombo(new PreparoGrelhado(), new PagamentoDinheiro(), false);
        assertEquals("Combo: Combo\n" +
                        "Produto: [Tradicional] Pão: Pão Brioche, Carne: Carne bovina - grelhado na brasa - R$25.0\n" +
                        "Bebida: Refrigerante - R$8.0\n",
                pedido.getItemCardapio().getConteudo());
    }

    @Test
    void deveFazerComboVeganoNaChapa() {
        Pedido pedido = PedidoFacade.fazerCombo(new PreparoNaChapa(), new PagamentoPix(), true);
        assertEquals("Combo: Combo\n" +
                        "Produto: [Vegano] Pão: Pão Integral, Carne: Grão de Bico - na chapa - R$22.0\n" +
                        "Bebida: Refrigerante - R$8.0\n",
                pedido.getItemCardapio().getConteudo());
    }

    @Test
    void deveArmazenarEstados() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.pronto();
        assertEquals(3, pedido.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.pronto();
        pedido.restauraEstado(0);
        assertEquals(PedidoEstadoAceito.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
        pedido.preparar();
        pedido.pronto();
        pedido.restauraEstado(1);
        assertEquals(PedidoEstadoEmPreparacao.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);
            pedido.restauraEstado(5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        Pedido pedido = PedidoFacade.fazerPedido(new PreparoGrelhado(), new PagamentoPix(), false);

        Pedido pedidoClone = pedido.clone();
        pedidoClone.setEstrategiaPagamento(new PagamentoCartao());

        assertEquals("[Pago via Pix]", pedido.getEstrategiaPagamento().descricao());
        assertEquals("[Pago via Cartão]", pedidoClone.getEstrategiaPagamento().descricao());

        assertNotSame(pedido.getItemCardapio(), pedidoClone.getItemCardapio());
        assertEquals(pedido.getItemCardapio().getConteudo(), pedidoClone.getItemCardapio().getConteudo());
    }
}
