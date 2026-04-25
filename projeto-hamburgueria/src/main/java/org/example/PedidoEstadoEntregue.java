package org.example;

public class PedidoEstadoEntregue extends PedidoEstado {

    private PedidoEstadoEntregue() {}

    private static class Holder {
        private static final PedidoEstadoEntregue INSTANCIA = new PedidoEstadoEntregue();
    }

    public static PedidoEstadoEntregue getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Entregue";
    }

    public boolean devolver(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        return true;
    }

}