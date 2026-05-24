package org.example.produtos;

public abstract class ItemCardapio implements Cloneable {

    private String descricao;

    public ItemCardapio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String getConteudo();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
