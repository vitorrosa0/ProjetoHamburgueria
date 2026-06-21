package org.example.pedido;

import org.example.interprete.InterpretadorExpressao;
import org.example.interprete.InterpretadorExpressoesAritmeticas;

public class RegraDesconto {

    public static String formula = "preco * 0.1 - fidelidade";

    public static double calcularDesconto(double preco, double fidelidade) {
        String expressao = formula.replace("preco", Double.toString(preco));
        expressao = expressao.replace("fidelidade", Double.toString(fidelidade));
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}