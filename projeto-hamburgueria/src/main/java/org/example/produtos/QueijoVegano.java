package org.example.produtos;

public class QueijoVegano extends HamburguerDecorator {

    public QueijoVegano(Hamburguer hamburguer) {
        super(hamburguer);
    }

    public String getIngrediente() {
        return ", Queijo Vegano";
    }
}
