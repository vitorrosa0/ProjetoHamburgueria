package org.example.equipe;

public class ChefFritar extends FuncionarioCozinha {

    public ChefFritar(FuncionarioCozinha proximo) {
        setResponsabilidade(TarefaCozinhaFritar.getInstancia());
        setProximoFuncionarioCozinha(proximo);
    }

    public String getDescricaoCargo() {
        return "ChefChapa";
    }

}
