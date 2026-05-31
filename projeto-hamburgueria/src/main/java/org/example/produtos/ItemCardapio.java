package org.example.produtos;

import org.example.visitors.ItemCardapioVisitor;

public abstract class ItemCardapio implements Cloneable {

    private String descricao;

    public ItemCardapio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String getConteudo();

    public abstract double aceitar(ItemCardapioVisitor visitor);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
