package org.example.equipe;

public class TarefaCozinhaFritar implements TarefaCozinha {

    private TarefaCozinhaFritar() {}

    private static class Holder {
        private static final TarefaCozinhaFritar INSTANCIA = new TarefaCozinhaFritar();
    }

    public static TarefaCozinhaFritar getInstancia() {
        return Holder.INSTANCIA;
    }
}
