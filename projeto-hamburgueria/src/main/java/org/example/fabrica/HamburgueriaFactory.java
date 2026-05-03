package org.example.fabrica;

import org.example.preparo.ModoPreparo;
import org.example.produtos.Hamburguer;

public interface HamburgueriaFactory {
    Hamburguer criarBase(ModoPreparo preparo);

    Hamburguer adicionarQueijo(Hamburguer hamburguer);
}
