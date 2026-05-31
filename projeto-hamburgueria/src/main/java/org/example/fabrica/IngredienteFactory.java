package org.example.fabrica;

import org.example.produtos.Ingrediente;

import java.util.HashMap;
import java.util.Map;

public class IngredienteFactory {

    private Map<String, Ingrediente> ingredientes = new HashMap<>();

    public Ingrediente getIngrediente(String nome, String tipo) {
        Ingrediente ingrediente = ingredientes.get(nome);
        if (ingrediente == null) {
            ingrediente = new Ingrediente(nome, tipo);
            ingredientes.put(nome, ingrediente);
        }
        return ingrediente;
    }

    public int getTotalIngredientes() {
        return ingredientes.size();
    }
}
