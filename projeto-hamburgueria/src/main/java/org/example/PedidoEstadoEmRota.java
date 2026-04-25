package org.example;

public class PedidoEstadoEmRota extends PedidoEstado {

    private PedidoEstadoEmRota() {}

    private static class Holder {
        private static final PedidoEstadoEmRota INSTANCIA = new PedidoEstadoEmRota();
    }

    public static PedidoEstadoEmRota getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Em rota";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        return true;
    }

    public boolean entregar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        return true;
    }

}
