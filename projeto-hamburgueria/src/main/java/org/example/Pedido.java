package org.example;

public class Pedido {

    private Hamburguer hamburguer;
    private PedidoEstado pedidoEstado;

    public Pedido(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        this.pedidoEstado = PedidoEstadoAceito.getInstancia();
    }

    public Hamburguer getHamburguer() {
        return hamburguer;
    }


    public PedidoEstado getEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public boolean aceitar() {
        return pedidoEstado.aceitar(this);
    }

    public boolean preparar() {
        return pedidoEstado.preparar(this);
    }

    public boolean cancelar() {
        return pedidoEstado.cancelar(this);
    }

    public boolean emRota() {
        return pedidoEstado.emRota(this);
    }

    public boolean pronto() {
        return pedidoEstado.pronto(this);
    }

    public boolean entregar() {
        return pedidoEstado.entregar(this);
    }

    public boolean devolver() {
        return pedidoEstado.devolver(this);
    }
}
