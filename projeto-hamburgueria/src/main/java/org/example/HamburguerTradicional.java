package org.example;

public class HamburguerTradicional extends HamburguerBase {


    public HamburguerTradicional(ModoPreparo modoPreparo) {
        super("Pão Brioche", "Carne bovina", modoPreparo);
    }

    public String montaHamburguer() {
        return "[Tradicional] " + super.montaHamburguer();
    }
}
