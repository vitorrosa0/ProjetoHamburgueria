package org.example.produtos;

import org.example.visitors.ItemCardapioVisitor;

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

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public String getConteudo() {
        String saida = "Combo: " + getDescricao() + "\n";
        for (ItemCardapio item : itens) {
            saida += item.getConteudo();
        }
        return saida;
    }

    @Override
    public double aceitar(ItemCardapioVisitor visitor) {
        return visitor.visitarCombo(this);
    }
}
