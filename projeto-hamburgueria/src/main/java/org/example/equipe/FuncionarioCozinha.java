package org.example.equipe;

import org.example.pedido.Pedido;

public abstract class FuncionarioCozinha {

    private TarefaCozinha responsabilidade;
    private FuncionarioCozinha proximoFuncionarioCozinha;

    public void setProximoFuncionarioCozinha(FuncionarioCozinha proximo) {
        this.proximoFuncionarioCozinha = proximo;
    }

    public void setResponsabilidade(TarefaCozinha responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public abstract String getDescricaoCargo();

    public String preparar(Pedido pedido) {
        if (responsabilidade == pedido.getTarefaCozinha()) {
            return getDescricaoCargo();
        }

        if (proximoFuncionarioCozinha != null) {
            return proximoFuncionarioCozinha.preparar(pedido);
        }

        return "Nenhum chef disponível";
    }
}
