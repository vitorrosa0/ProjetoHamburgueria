package org.example.visitors;

import org.example.produtos.Bebida;
import org.example.produtos.Combo;
import org.example.produtos.ItemCardapio;
import org.example.produtos.Produto;

public class CalculadoraPrecoVisitor implements ItemCardapioVisitor {

    @Override
    public double visitarProduto(Produto produto) {
        return produto.getPreco();
    }

    @Override
    public double visitarBebida(Bebida bebida) {
        return bebida.getPreco();
    }

    @Override
    public double visitarCombo(Combo combo) {
        double total = 0;
        for (ItemCardapio item : combo.getItens()) {
            total += item.aceitar(this);
        }
        return total;
    }
}

