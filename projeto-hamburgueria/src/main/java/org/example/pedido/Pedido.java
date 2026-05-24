package org.example.pedido;

import org.example.equipe.Cozinha;
import org.example.pagamento.EstrategiaPagamento;
import org.example.preparo.ModoPreparo;
import org.example.produtos.Hamburguer;

import java.util.Observable;

public class Pedido extends Observable {

    private Hamburguer hamburguer;
    private PedidoEstado pedidoEstado;
    private EstrategiaPagamento estrategiaPagamento;
    private String tarefaCozinha;

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

    public String getTarefaCozinha() {
        return tarefaCozinha;
    }

    public void setTarefaCozinha(String tarefaCozinha) {
        this.tarefaCozinha = tarefaCozinha;
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

    public String processarNaCozinha() {
        return Cozinha.getInstance().processarTarefa(this);
    }

    public static Pedido fazer(ModoPreparo preparo, EstrategiaPagamento pagamento, boolean vegano) {
        if (vegano) {
            return PedidoFacade.fazerPedidoVegano(preparo, pagamento);
        }
        return PedidoFacade.fazerPedidoTradicional(preparo, pagamento);
    }

    @Override
    public String toString() {
        return pedidoEstado.getPedidoEstado();
    }
}
