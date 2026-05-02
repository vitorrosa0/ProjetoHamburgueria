package org.example;

import java.util.Observable;

public class Pedido extends Observable {

    private Hamburguer hamburguer;
    private PedidoEstado pedidoEstado;
    private EstrategiaPagamento estrategiaPagamento;

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
        this.atualizarPedido();
    }

    public EstrategiaPagamento getEstrategiaPagamento() {
        return estrategiaPagamento;
    }

    public void setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
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

    public void atualizarPedido() {
        pedidoEstado.atualizar(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return pedidoEstado.getPedidoEstado();
    }
}
