package org.example.equipe;

public class ChefMontagem extends FuncionarioCozinha {

    public ChefMontagem(FuncionarioCozinha proximo) {
        setResponsabilidade(TarefaCozinhaMontar.getInstancia());
        setProximoFuncionarioCozinha(proximo);
    }

    public String getDescricaoCargo() {
        return "ChefMontagem";
    }
}
