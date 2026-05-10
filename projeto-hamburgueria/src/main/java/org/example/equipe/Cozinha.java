package org.example.equipe;

import org.example.pedido.Pedido;

public class Cozinha {

    private Cozinha() {}

    private static class Holder {
        private static final Cozinha INSTANCIA = new Cozinha();
    }

    public static Cozinha getInstance() { return Holder.INSTANCIA; }

    public String processarTarefa(Pedido pedido) {
        ChefMontagem montagem = new ChefMontagem(null);
        ChefFritar fritar = new ChefFritar(montagem);
        return fritar.preparar(pedido);
    }
}
