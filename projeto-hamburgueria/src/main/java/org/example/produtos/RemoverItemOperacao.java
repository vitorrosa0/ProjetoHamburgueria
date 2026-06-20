package org.example.produtos;

public class RemoverItemOperacao implements Operacao {

    private Combo combo;
    private ItemCardapio item;

    public RemoverItemOperacao(Combo combo, ItemCardapio item) {
        this.combo = combo;
        this.item = item;
    }

    @Override
    public void executar() {
        combo.removerItem(item);
    }

    @Override
    public void cancelar() {
        combo.addItem(item);
    }
}