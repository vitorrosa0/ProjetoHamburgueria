package org.example.produtos;

import org.example.visitors.ItemCardapioVisitor;

public class Bebida extends ItemCardapio {

    private double preco;

    public Bebida(String descricao, double preco) {
        super(descricao);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String getConteudo() {
        return "Bebida: " + getDescricao() + " - R$" + preco + "\n";
    }

    @Override
    public double aceitar(ItemCardapioVisitor visitor) {
        return visitor.visitarBebida(this);
    }
}