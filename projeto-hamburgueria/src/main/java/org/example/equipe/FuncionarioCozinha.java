package org.example.equipe;

import org.example.pedido.Pedido;

public abstract class FuncionarioCozinha {

    private String responsabilidade;
    private FuncionarioCozinha proximoFuncionarioCozinha;

    public void setProximoFuncionarioCozinha(FuncionarioCozinha proximoFuncionarioCozinha) {
        this.proximoFuncionarioCozinha = proximoFuncionarioCozinha;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public abstract String getDescricaoCargo();

    public String preparar(Pedido pedido) {
        if (responsabilidade.equals(pedido.getTarefaCozinha())) {
            return getDescricaoCargo();
        }

        if (proximoFuncionarioCozinha != null) {
            return proximoFuncionarioCozinha.preparar(pedido);
        }

        return "Nenhum chef disponível";
    }
}
