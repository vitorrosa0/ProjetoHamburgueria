package org.example.produtos;

import org.example.preparo.ModoPreparo;

public class HamburguerVegano extends HamburguerBase {


    public HamburguerVegano(ModoPreparo modoPreparo) {
        super("Pão Integral", "Grão de Bico", modoPreparo);
    }

    public String montaHamburguer() {
        return "[Vegano] " + super.montaHamburguer();
    }
}
