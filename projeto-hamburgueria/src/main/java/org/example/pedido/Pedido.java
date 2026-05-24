package org.example.pedido;

import org.example.equipe.Cozinha;
import org.example.pagamento.EstrategiaPagamento;
import org.example.preparo.ModoPreparo;
import org.example.produtos.Hamburguer;
import org.example.produtos.ItemCardapio;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pedido extends Observable {

    private ItemCardapio itemCardapio;
    private PedidoEstado pedidoEstado;
    private EstrategiaPagamento estrategiaPagamento;
    private String tarefaCozinha;
    private List<PedidoEstado> memento = new ArrayList<PedidoEstado>();

    public Pedido(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
        this.pedidoEstado = PedidoEstadoAceito.getInstancia();
        this.memento.add(this.pedidoEstado);
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }


    public PedidoEstado getEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
        this.memento.add(this.pedidoEstado);
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

    public static Pedido fazerPedido(ModoPreparo preparo, EstrategiaPagamento pagamento, boolean vegano) {
        if (vegano) {
            return PedidoFacade.fazerPedidoVegano(preparo, pagamento);
        }
        return PedidoFacade.fazerPedidoTradicional(preparo, pagamento);
    }

    public static Pedido fazerCombo(ModoPreparo preparo, EstrategiaPagamento pagamento, boolean vegano) {
        return PedidoFacade.fazerCombo(preparo, pagamento, vegano);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.pedidoEstado = this.memento.get(indice);
    }

    public List<PedidoEstado> getEstados() {
        return this.memento;
    }

    @Override
    public String toString() {
        return pedidoEstado.getPedidoEstado();
    }
}
