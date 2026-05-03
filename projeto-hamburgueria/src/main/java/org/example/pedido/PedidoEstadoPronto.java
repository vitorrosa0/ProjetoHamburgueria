package org.example.pedido;

public class PedidoEstadoPronto extends PedidoEstado {

    private PedidoEstadoPronto() {}

    private static class Holder {
        private static final PedidoEstadoPronto INSTANCIA = new PedidoEstadoPronto();
    }

    public static PedidoEstadoPronto getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Pronto";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        return true;
    }

    public boolean emRota(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        return true;
    }

    public boolean entregar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        return true;
    }

}
