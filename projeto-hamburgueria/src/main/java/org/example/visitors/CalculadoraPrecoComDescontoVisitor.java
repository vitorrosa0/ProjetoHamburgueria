package org.example.visitors;

import org.example.pedido.RegraDesconto;
import org.example.produtos.Bebida;
import org.example.produtos.Combo;
import org.example.produtos.Produto;

public class CalculadoraPrecoComDescontoVisitor implements ItemCardapioVisitor {

    private CalculadoraPrecoVisitor calculadoraPreco = new CalculadoraPrecoVisitor();
    private double fidelidade;

    public CalculadoraPrecoComDescontoVisitor(double fidelidade) {
        this.fidelidade = fidelidade;
    }

    @Override
    public double visitarProduto(Produto produto) {
        double precoBruto = calculadoraPreco.visitarProduto(produto);
        return RegraDesconto.calcularDesconto(precoBruto, fidelidade);
    }

    @Override
    public double visitarBebida(Bebida bebida) {
        double precoBruto = calculadoraPreco.visitarBebida(bebida);
        return RegraDesconto.calcularDesconto(precoBruto, fidelidade);
    }

    @Override
    public double visitarCombo(Combo combo) {
        double precoBruto = calculadoraPreco.visitarCombo(combo);
        return RegraDesconto.calcularDesconto(precoBruto, fidelidade);
    }
}