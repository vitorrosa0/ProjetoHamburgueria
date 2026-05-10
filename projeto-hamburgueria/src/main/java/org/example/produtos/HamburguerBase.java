package org.example.produtos;

import org.example.preparo.ModoPreparo;

public abstract class HamburguerBase implements Hamburguer {

    private ModoPreparo modoPreparo;

    public HamburguerBase(ModoPreparo modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public final String montaHamburguer() {
        return getCategoria() + " Pão: " + getPao() + ", Carne: " + getCarne() + " - " + modoPreparo.preparar();
    }

    protected abstract String getCategoria();
    protected abstract String getPao();
    protected abstract String getCarne();
}
