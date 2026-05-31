package org.example.visitors;

import org.example.produtos.Bebida;
import org.example.produtos.Combo;
import org.example.produtos.Produto;

public interface ItemCardapioVisitor {
    double visitarProduto(Produto produto);
    double visitarBebida(Bebida bebida);
    double visitarCombo(Combo combo);
}
