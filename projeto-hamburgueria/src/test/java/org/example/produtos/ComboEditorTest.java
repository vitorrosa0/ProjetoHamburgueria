package org.example.produtos;

import org.example.pedido.Preco;
import org.example.preparo.PreparoGrelhado;
import org.example.fabrica.FabricaTradicional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboEditorTest {

    private Produto criarHamburguer() {
        return new Produto(
                FabricaTradicional.getInstancia().criarBase(new PreparoGrelhado()),
                Preco.HAMBURGUER_TRADICIONAL
        );
    }

    private Bebida criarBebida() {
        return new Bebida("Refrigerante", Preco.BEBIDA);
    }

    @Test
    void deveAdicionarItemAoCombo() {
        Combo combo = new Combo("Combo");
        ComboEditor editor = new ComboEditor();

        editor.executarOperacao(new AdicionarItemOperacao(combo, criarHamburguer()));

        assertEquals(1, combo.getItens().size());
    }

    @Test
    void deveRemoverItemDoCombo() {
        Combo combo = new Combo("Combo");
        Bebida bebida = criarBebida();
        combo.addItem(criarHamburguer());
        combo.addItem(bebida);

        ComboEditor editor = new ComboEditor();
        editor.executarOperacao(new RemoverItemOperacao(combo, bebida));

        assertEquals(1, combo.getItens().size());
    }

    @Test
    void deveCancelarUltimaAdicao() {
        Combo combo = new Combo("Combo");
        ComboEditor editor = new ComboEditor();

        editor.executarOperacao(new AdicionarItemOperacao(combo, criarHamburguer()));
        editor.executarOperacao(new AdicionarItemOperacao(combo, criarBebida()));
        editor.cancelarUltimaOperacao();

        assertEquals(1, combo.getItens().size());
    }

    @Test
    void deveCancelarUltimaRemocao() {
        Combo combo = new Combo("Combo");
        Bebida bebida = criarBebida();
        combo.addItem(criarHamburguer());
        combo.addItem(bebida);

        ComboEditor editor = new ComboEditor();
        editor.executarOperacao(new RemoverItemOperacao(combo, bebida));
        editor.cancelarUltimaOperacao();

        assertEquals(2, combo.getItens().size());
    }

    @Test
    void deveCancelarSemOperacoesNaoLancaExcecao() {
        ComboEditor editor = new ComboEditor();
        editor.cancelarUltimaOperacao();
    }
}