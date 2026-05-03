package org.example.equipe;

public class ChefMontagem extends FuncionarioCozinha {

    public ChefMontagem(FuncionarioCozinha proximo) {
        setResponsabilidade("Montando o sanduiche");
        setProximoFuncionarioCozinha(proximo);
    }

    public String getDescricaoCargo() {
        return "ChefMontagem";
    }
}
