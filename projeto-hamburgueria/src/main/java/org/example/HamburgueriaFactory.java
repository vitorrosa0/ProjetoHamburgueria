package org.example;

public interface HamburgueriaFactory {
    Hamburguer criarBase(ModoPreparo preparo);

    Hamburguer adicionarQueijo(Hamburguer hamburguer);
}
