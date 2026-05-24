package org.example.produtos;

public class Cardapio {

    private ItemCardapio item;

    public void setItem(ItemCardapio item) {
        this.item = item;
    }

    public String getCardapio() {
        if (this.item == null) {
            throw new NullPointerException("Cardápio sem itens");
        }
        return this.item.getConteudo();
    }
}
