package org.example.produtos;

import org.example.preparo.ModoPreparo;

public class HamburguerTradicional extends HamburguerBase {


    public HamburguerTradicional(ModoPreparo modoPreparo) {
        super(modoPreparo);
    }

    protected String getCategoria() {
        return "[Tradicional]";
    }

    protected String getPao() {
        return "Pão Brioche";
    }

    protected String getCarne() {
        return "Carne bovina";
    }
}
