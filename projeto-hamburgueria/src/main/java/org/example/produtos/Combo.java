package org.example.produtos;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ItemCardapio {

    private List<ItemCardapio> itens;

    public Combo(String descricao) {
        super(descricao);
        this.itens = new ArrayList<>();
    }

    public void addItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public String getConteudo() {
        String saida = "Combo: " + getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getConteudo();
        }
        return saida;
    }
}
