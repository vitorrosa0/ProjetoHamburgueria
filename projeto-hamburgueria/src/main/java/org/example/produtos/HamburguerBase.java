package org.example.produtos;

import org.example.preparo.ModoPreparo;

public abstract class HamburguerBase implements Hamburguer {

    private String pao;
    private String carne;
    private ModoPreparo modoPreparo;

    public HamburguerBase(String pao, String carne, ModoPreparo modoPreparo) {
        this.pao = pao;
        this.carne = carne;
        this.modoPreparo = modoPreparo;
    }

    public String montaHamburguer() {
        return "Pão: " + pao + ", Carne: " + carne + " - " + modoPreparo.preparar();
    }

}
