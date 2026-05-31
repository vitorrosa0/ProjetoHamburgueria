package org.example.equipe;

public class TarefaCozinhaMontar implements TarefaCozinha {

    private TarefaCozinhaMontar() {}

    private static class Holder {
        private static final TarefaCozinhaMontar INSTANCIA = new TarefaCozinhaMontar();
    }

    public static TarefaCozinhaMontar getInstancia() {
        return Holder.INSTANCIA;
    }
}
