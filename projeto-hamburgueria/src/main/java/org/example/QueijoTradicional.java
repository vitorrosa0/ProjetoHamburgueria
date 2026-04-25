package org.example;

public class QueijoTradicional extends HamburguerDecorator {

    public QueijoTradicional(Hamburguer hamburguer) {
        super(hamburguer);
    }

    public String getIngrediente() {
        return ", Queijo Tradicional";
    }
}
