package org.example;

public class FabricaTradicional implements HamburgueriaFactory {

    private FabricaTradicional() {}

    private static class Holder {
        private static final FabricaTradicional INSTANCIA = new FabricaTradicional();
    }

    public static FabricaTradicional getInstancia() {
        return Holder.INSTANCIA;
    }

    public Hamburguer criarBase(ModoPreparo preparo) {
        return new HamburguerTradicional(preparo);
    }

    public Hamburguer adicionarQueijo(Hamburguer base) {
        return HamburgueriaDecoratorFactory.getInstancia().obterIngrediente("QueijoTradicional", base);
    }
}
