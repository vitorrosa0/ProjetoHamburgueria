package org.example.pedido;

public class PedidoEstadoCancelado extends PedidoEstado {

    private PedidoEstadoCancelado() {}

    private static class Holder {
        private static final PedidoEstadoCancelado INSTANCIA = new PedidoEstadoCancelado();
    }

    public static PedidoEstadoCancelado getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Cancelado";
    }

}