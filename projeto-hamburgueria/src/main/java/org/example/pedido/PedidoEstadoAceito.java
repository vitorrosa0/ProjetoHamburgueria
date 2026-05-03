package org.example.pedido;

public class PedidoEstadoAceito extends PedidoEstado {

    private PedidoEstadoAceito() {}

    private static class Holder {
        private static final PedidoEstadoAceito INSTANCIA = new PedidoEstadoAceito();
    }

    public static PedidoEstadoAceito getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getPedidoEstado() {
        return "Aceito";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        return true;
    }

}
