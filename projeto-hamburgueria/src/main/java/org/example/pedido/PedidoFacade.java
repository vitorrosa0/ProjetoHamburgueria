package org.example.pedido;

import org.example.fabrica.FabricaTradicional;
import org.example.fabrica.FabricaVegana;
import org.example.pagamento.EstrategiaPagamento;
import org.example.preparo.ModoPreparo;
import org.example.produtos.Hamburguer;

public class PedidoFacade {

    public static Pedido fazerPedidoTradicional(ModoPreparo preparo, EstrategiaPagamento pagamento) {
        Hamburguer hamburguer = FabricaTradicional.getInstancia().criarBase(preparo);
        return new PedidoBuilder()
                .setHamburguer(hamburguer)
                .setEstrategiaPagamento(pagamento)
                .setTarefaCozinha("Fritando a carne")
                .build();
    }

    public static Pedido fazerPedidoVegano(ModoPreparo preparo, EstrategiaPagamento pagamento) {
        Hamburguer hamburguer = FabricaVegana.getInstancia().criarBase(preparo);
        return new PedidoBuilder()
                .setHamburguer(hamburguer)
                .setEstrategiaPagamento(pagamento)
                .setTarefaCozinha("Fritando a carne")
                .build();
    }
}
