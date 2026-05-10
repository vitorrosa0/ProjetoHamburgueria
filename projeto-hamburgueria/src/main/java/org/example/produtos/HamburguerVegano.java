package org.example.produtos;

import org.example.preparo.ModoPreparo;

public class HamburguerVegano extends HamburguerBase {

    public HamburguerVegano(ModoPreparo modoPreparo) {
        super(modoPreparo);
    }

    protected String getCategoria() {
        return "[Vegano]";
    }

    protected String getPao() {
        return "Pão Integral";
    }

    protected String getCarne() {
        return "Grão de Bico";
    }
}
