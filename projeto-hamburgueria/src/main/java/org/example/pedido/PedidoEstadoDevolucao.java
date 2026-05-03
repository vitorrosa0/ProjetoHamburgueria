package org.example.pedido;

public class PedidoEstadoDevolucao extends PedidoEstado {

    private PedidoEstadoDevolucao() {}

    private static class Holder {
        private static final PedidoEstadoDevolucao INSTANCIA = new PedidoEstadoDevolucao();
    }

    public static PedidoEstadoDevolucao getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Devolvido";
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoCancelado.getInstancia());
        return true;
    }

}