package org.example.pagamento;

import java.util.HashMap;
import java.util.Map;

public class SistemaPagamentoLegado {

    private final Map<Integer, String> pagamentos = new HashMap<>();

    public SistemaPagamentoLegado() {
        pagamentos.put(1, "PAGAMENTO_DINHEIRO");
        pagamentos.put(2, "PAGAMENTO_CARTAO");
        pagamentos.put(3, "PAGAMENTO_PIX");
    }

    public String processarPagamentoLegado(int codigo) {
        String resultado = pagamentos.get(codigo);
        if (resultado == null) {
            throw new IllegalArgumentException("Código de pagamento inválido: " + codigo);
        }
        return resultado;
    }
}