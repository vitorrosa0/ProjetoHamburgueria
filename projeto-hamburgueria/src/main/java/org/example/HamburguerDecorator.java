package org.example;

public abstract class HamburguerDecorator implements Hamburguer {

    private Hamburguer hamburguer;
    public HamburguerDecorator(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }

    public void setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    public abstract String getIngrediente();

    public String montaHamburguer() {
        return this.hamburguer.montaHamburguer() + getIngrediente();
    }
}
