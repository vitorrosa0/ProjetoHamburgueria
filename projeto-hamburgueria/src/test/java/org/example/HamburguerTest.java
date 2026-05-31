package org.example;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.FabricaVegana;
import org.example.fabrica.HamburgueriaFactory;
import org.example.preparo.PreparoGrelhado;
import org.example.preparo.PreparoNaChapa;
import org.example.produtos.Hamburguer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamburguerTest {

    @Test
    void deveRetornarHamburguerVeganoNaChapa() {
        HamburgueriaFactory fabrica = FabricaVegana.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoNaChapa());
        assertEquals("[Vegano] Pão: Pão Integral, Carne: Grão de Bico - na chapa",
                hamburguer.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerVeganoGrelhado() {
        HamburgueriaFactory fabrica = FabricaVegana.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());
        assertEquals("[Vegano] Pão: Pão Integral, Carne: Grão de Bico - grelhado na brasa",
                hamburguer.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerTradicionalGrelhado() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());
        assertEquals("[Tradicional] Pão: Pão Brioche, Carne: Carne bovina - grelhado na brasa",
                hamburguer.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerTradicionalNaChapa() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoNaChapa());
        assertEquals("[Tradicional] Pão: Pão Brioche, Carne: Carne bovina - na chapa",
                hamburguer.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerTradicionalGrelhadoComQueijo() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer pedido = fabrica.criarBase(new PreparoGrelhado());
        pedido = fabrica.adicionarQueijo(pedido);
        assertEquals("[Tradicional] Pão: Pão Brioche, Carne: Carne bovina - grelhado na brasa, Queijo Tradicional",
                pedido.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerTradicionalNaChapaComQueijo() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer pedido = fabrica.criarBase(new PreparoNaChapa());
        pedido = fabrica.adicionarQueijo(pedido);
        assertEquals("[Tradicional] Pão: Pão Brioche, Carne: Carne bovina - na chapa, Queijo Tradicional",
                pedido.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerVeganoGrelhadoComQueijo() {
        HamburgueriaFactory fabrica = FabricaVegana.getInstancia();
        Hamburguer pedido = fabrica.criarBase(new PreparoGrelhado());
        pedido = fabrica.adicionarQueijo(pedido);
        assertEquals("[Vegano] Pão: Pão Integral, Carne: Grão de Bico - grelhado na brasa, Queijo Vegano",
                pedido.montaHamburguer());
    }

    @Test
    void deveRetornarHamburguerVeganoNaChapaComQueijo() {
        HamburgueriaFactory fabrica = FabricaVegana.getInstancia();
        Hamburguer pedido = fabrica.criarBase(new PreparoNaChapa());
        pedido = fabrica.adicionarQueijo(pedido);
        assertEquals("[Vegano] Pão: Pão Integral, Carne: Grão de Bico - na chapa, Queijo Vegano",
                pedido.montaHamburguer());
    }
}
