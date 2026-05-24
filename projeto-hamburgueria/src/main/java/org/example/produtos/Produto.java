package org.example.produtos;

public class Produto extends ItemCardapio {

    private Hamburguer hamburguer;
    private double preco;

    public Produto(Hamburguer hamburguer, double preco) {
        super(hamburguer.montaHamburguer());
        this.hamburguer = hamburguer;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String getConteudo() {
        return "Produto: " + getDescricao() + " - R$" + preco + "\n";
    }
}
