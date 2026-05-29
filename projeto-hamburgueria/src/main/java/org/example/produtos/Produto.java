package org.example.produtos;

public class Produto extends ItemCardapio {

    private Hamburguer hamburguer;
    private double preco;
    private Ingrediente ingrediente;

    public Produto(Hamburguer hamburguer, double preco) {
        super(hamburguer.montaHamburguer());
        this.hamburguer = hamburguer;
        this.preco = preco;
        this.ingrediente = null;
    }

    public Produto(Hamburguer hamburguer, double preco, Ingrediente ingrediente) {
        super(hamburguer.montaHamburguer());
        this.hamburguer = hamburguer;
        this.preco = preco;
        this.ingrediente = ingrediente;
    }

    public double getPreco() { return preco; }
    public Ingrediente getIngrediente() { return ingrediente; }

    public String getConteudo() {
        String base = "Produto: " + getDescricao() + " - R$" + preco + "\n";
        if (ingrediente != null) {
            base = "Produto: " + getDescricao() +
                    ", ingrediente='" + ingrediente.getNome() + "'" +
                    ", tipo='" + ingrediente.getTipo() + "'" +
                    " - R$" + preco + "\n";
        }
        return base;
    }
}
