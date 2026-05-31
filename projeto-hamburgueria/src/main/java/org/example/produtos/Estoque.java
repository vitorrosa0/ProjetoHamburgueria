package org.example.produtos;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.FabricaVegana;
import org.example.fabrica.IngredienteFactory;
import org.example.preparo.ModoPreparo;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    private IngredienteFactory ingredienteFactory = new IngredienteFactory();

    public void adicionar(ModoPreparo preparo, boolean vegano, String nomeIngrediente, String tipo) {
        Hamburguer hamburguer = vegano
                ? FabricaVegana.getInstancia().criarBase(preparo)
                : FabricaTradicional.getInstancia().criarBase(preparo);
        Ingrediente ingrediente = ingredienteFactory.getIngrediente(nomeIngrediente, tipo);
        Produto produto = new Produto(hamburguer, vegano ? 22.0 : 25.0, ingrediente);
        produtos.add(produto);
    }

    public List<String> obterProdutos() {
        List<String> saida = new ArrayList<>();
        for (Produto produto : produtos) {
            saida.add(produto.getConteudo());
        }
        return saida;
    }

    public int getTotalIngredientes() {
        return ingredienteFactory.getTotalIngredientes();
    }
}
