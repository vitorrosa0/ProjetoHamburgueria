package org.example.equipe;

public class ChefFritar extends FuncionarioCozinha {

    public ChefFritar(FuncionarioCozinha proximo) {
        setResponsabilidade("Fritando a carne");
        setProximoFuncionarioCozinha(proximo);
    }

    public String getDescricaoCargo() {
        return "ChefChapa";
    }

}
