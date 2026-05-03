package org.example.pedido;

import java.util.Observable;
import java.util.Observer;

public abstract class PedidoEstado implements Observer {

    private String ultimaNotificacao;

    public abstract String getPedidoEstado();

    public boolean aceitar(Pedido pedido) { return false; }

    public boolean preparar(Pedido pedido) { return false; }

    public boolean cancelar(Pedido pedido) { return false; }

    public boolean emRota(Pedido pedido) { return false; }

    public boolean pronto(Pedido pedido) { return false; }

    public boolean entregar(Pedido pedido) { return false; }

    public boolean devolver(Pedido pedido) { return false; }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void atualizar(Pedido pedido) {
        pedido.addObserver(this);
    }

    public void update(Observable pedido, Object arg1) {
        this.ultimaNotificacao = "Pedido atualizado para: " + pedido.toString();
    }
}
