package org.example.fabrica;

import org.example.produtos.Hamburguer;
import org.example.produtos.HamburguerDecorator;
import org.example.produtos.QueijoTradicional;
import org.example.produtos.QueijoVegano;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class HamburgueriaDecoratorFactory {

    // após alguns estudos, aprendi que o uso do "Class.forName()" é uma chamada que acontece em runtime
    // com isso, o compilador não sabe se "org.example.QueijoTradicional" existe
    // com o Map, eu registro "QueijoTradicional::new" que é verificado em compile time
    // se renomear a classe, o compilador avisa imediatamente, em vez de só quebrar quando alguém pedir aquele ingrediente
    // erro: reflection
    private final Map<String, Function<Hamburguer, HamburguerDecorator>> decorators = new HashMap<>();

    private HamburgueriaDecoratorFactory() {
        decorators.put("QueijoTradicional", QueijoTradicional::new);
        decorators.put("QueijoVegano", QueijoVegano::new);
    }

    private static class Holder {
        private static final HamburgueriaDecoratorFactory INSTANCIA = new HamburgueriaDecoratorFactory();
    }

    public static HamburgueriaDecoratorFactory getInstancia() {
        return Holder.INSTANCIA;
    }

    public Hamburguer obterIngrediente(String ingrediente, Hamburguer hamburguer) {
        Function<Hamburguer, HamburguerDecorator> construtor = decorators.get(ingrediente);
        if (construtor == null) {
            throw new IllegalArgumentException("Decorator inexistente: " + ingrediente);
        }
        return construtor.apply(hamburguer);
    }
}
