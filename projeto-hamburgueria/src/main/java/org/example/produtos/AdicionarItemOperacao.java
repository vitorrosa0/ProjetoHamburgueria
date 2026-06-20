package org.example.produtos;

public class AdicionarItemOperacao implements Operacao {

    private Combo combo;
    private ItemCardapio item;

    public AdicionarItemOperacao(Combo combo, ItemCardapio item) {
        this.combo = combo;
        this.item = item;
    }

    @Override
    public void executar() {
        combo.addItem(item);
    }

    @Override
    public void cancelar() {
        combo.removerItem(item);
    }
}