package org.example.produtos;

import org.example.preparo.PreparoGrelhado;
import org.example.preparo.PreparoNaChapa;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {

    @Test
    void deveRetornarProdutos() {
        Estoque estoque = new Estoque();
        estoque.adicionar(new PreparoGrelhado(), false, "Queijo", "Laticinios");
        estoque.adicionar(new PreparoNaChapa(), false, "Queijo", "Laticinios");
        estoque.adicionar(new PreparoGrelhado(), true, "Tofu", "Proteina Vegetal");

        List<String> saida = Arrays.asList(
                "Produto: [Tradicional] Pão: Pão Brioche, Carne: Carne bovina - grelhado na brasa, ingrediente='Queijo', tipo='Laticinios' - R$25.0\n",
                "Produto: [Tradicional] Pão: Pão Brioche, Carne: Carne bovina - na chapa, ingrediente='Queijo', tipo='Laticinios' - R$25.0\n",
                "Produto: [Vegano] Pão: Pão Integral, Carne: Grão de Bico - grelhado na brasa, ingrediente='Tofu', tipo='Proteina Vegetal' - R$22.0\n");

        assertEquals(saida, estoque.obterProdutos());
    }

    @Test
    void deveRetornarTotalIngredientes() {
        Estoque estoque = new Estoque();
        estoque.adicionar(new PreparoGrelhado(), false, "Queijo", "Laticinios");
        estoque.adicionar(new PreparoNaChapa(), false, "Queijo", "Laticinios");
        estoque.adicionar(new PreparoGrelhado(), true, "Tofu", "Proteina Vegetal");

        assertEquals(2, estoque.getTotalIngredientes());
    }
}