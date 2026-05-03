package org.example.fabrica;

import org.example.preparo.ModoPreparo;
import org.example.produtos.Hamburguer;
import org.example.produtos.HamburguerVegano;

public class FabricaVegana implements HamburgueriaFactory {

    private FabricaVegana() {}

    private static class Holder {
        private static final FabricaVegana INSTANCIA = new FabricaVegana();
    }

    public static FabricaVegana getInstancia() {
        return Holder.INSTANCIA;
    }


    public Hamburguer criarBase(ModoPreparo preparo) {
        return new HamburguerVegano(preparo);
    }

    public Hamburguer adicionarQueijo(Hamburguer base) {
        return HamburgueriaDecoratorFactory.getInstancia().obterIngrediente("QueijoVegano", base);
    }
}
