package org.example.pedido;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.FabricaVegana;
import org.example.pagamento.EstrategiaPagamento;
import org.example.preparo.ModoPreparo;
import org.example.produtos.Bebida;
import org.example.produtos.Combo;
import org.example.produtos.Hamburguer;
import org.example.produtos.Produto;

public class PedidoFacade {

    public static Pedido fazerPedidoTradicional(ModoPreparo preparo, EstrategiaPagamento pagamento) {
        Hamburguer hamburguer = FabricaTradicional.getInstancia().criarBase(preparo);
        Produto produto = new Produto(hamburguer, 25.0);
        return new PedidoBuilder()
                .setItemCardapio(produto)
                .setEstrategiaPagamento(pagamento)
                .setTarefaCozinha("Fritando a carne")
                .build();
    }

    public static Pedido fazerPedidoVegano(ModoPreparo preparo, EstrategiaPagamento pagamento) {
        Hamburguer hamburguer = FabricaVegana.getInstancia().criarBase(preparo);
        Produto produto = new Produto(hamburguer, 22.0);
        return new PedidoBuilder()
                .setItemCardapio(produto)
                .setEstrategiaPagamento(pagamento)
                .setTarefaCozinha("Fritando a carne")
                .build();
    }

    public static Pedido fazerCombo(ModoPreparo preparo, EstrategiaPagamento pagamento, boolean vegano) {
        Hamburguer hamburguer = vegano
                ? FabricaVegana.getInstancia().criarBase(preparo)
                : FabricaTradicional.getInstancia().criarBase(preparo);

        Combo combo = new Combo("Combo");
        combo.addItem(new Produto(hamburguer, vegano ? 22.0 : 25.0));
        combo.addItem(new Bebida("Refrigerante", 8.0));

        return new PedidoBuilder()
                .setItemCardapio(combo)
                .setEstrategiaPagamento(pagamento)
                .setTarefaCozinha("Fritando a carne")
                .build();
    }
}
