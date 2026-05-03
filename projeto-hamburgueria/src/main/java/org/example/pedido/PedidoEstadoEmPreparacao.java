package org.example.pedido;

public class PedidoEstadoEmPreparacao extends PedidoEstado {

    private PedidoEstadoEmPreparacao() {}

    private static class Holder {
        private static final PedidoEstadoEmPreparacao INSTANCIA = new PedidoEstadoEmPreparacao();
    }

    public static PedidoEstadoEmPreparacao getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Em preparacao";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        return true;
    }

    public boolean pronto(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        return true;
    }

}