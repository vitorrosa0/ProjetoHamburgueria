package org.example.fabrica;

import org.example.produtos.Hamburguer;
import org.example.produtos.HamburguerDecorator;

public class HamburgueriaDecoratorFactory {

    private HamburgueriaDecoratorFactory() {}

    private static class Holder {
        private static final HamburgueriaDecoratorFactory INSTANCIA = new HamburgueriaDecoratorFactory();
    }

    public static HamburgueriaDecoratorFactory getInstancia() {
        return Holder.INSTANCIA;
    }

    public Hamburguer obterIngrediente(String ingrediente, Hamburguer hamburguer) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example.produtos." + ingrediente);
            objeto = classe.getDeclaredConstructor(Hamburguer.class).newInstance(hamburguer);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Decorator inexistente");
        }

        if (!(objeto instanceof HamburguerDecorator)) {
            throw new IllegalArgumentException("Decorator inválido");
        }

        return (Hamburguer) objeto;
    }

}
