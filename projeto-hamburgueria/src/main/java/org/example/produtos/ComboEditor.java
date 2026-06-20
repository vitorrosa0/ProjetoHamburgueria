package org.example.produtos;

import java.util.ArrayList;
import java.util.List;

public class ComboEditor {

    private List<Operacao> operacoes = new ArrayList<>();

    public void executarOperacao(Operacao operacao) {
        operacoes.add(operacao);
        operacao.executar();
    }

    public void cancelarUltimaOperacao() {
        if (!operacoes.isEmpty()) {
            Operacao operacao = operacoes.get(operacoes.size() - 1);
            operacao.cancelar();
            operacoes.remove(operacoes.size() - 1);
        }
    }
}