package org.example.pedido;

import org.example.equipe.TarefaCozinha;
import org.example.pagamento.EstrategiaPagamento;
import org.example.produtos.ItemCardapio;

import java.util.Observable;

public class Pedido extends Observable implements Cloneable {

    private ItemCardapio itemCardapio;
    private PedidoEstado pedidoEstado;
    private EstrategiaPagamento estrategiaPagamento;
    private TarefaCozinha tarefaCozinha;
    private HistoricoPedido historico = new HistoricoPedido();

    public Pedido(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
        this.pedidoEstado = PedidoEstadoAceito.getInstancia();
        this.historico.salvar(this.pedidoEstado);
    }

    public ItemCardapio getItemCardapio() { return itemCardapio; }

    public PedidoEstado getEstado() { return pedidoEstado; }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
        this.historico.salvar(this.pedidoEstado);
        this.atualizarPedido();
    }

    public EstrategiaPagamento getEstrategiaPagamento() { return estrategiaPagamento; }

    public void setEstrategiaPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    public TarefaCozinha getTarefaCozinha() { return tarefaCozinha; }

    public void setTarefaCozinha(TarefaCozinha tarefaCozinha) {
        this.tarefaCozinha = tarefaCozinha;
    }

    public HistoricoPedido getHistorico() { return historico; }

    public void restauraEstado(int indice) {
        this.pedidoEstado = historico.restaurar(indice);
    }

    public java.util.List<PedidoEstado> getEstados() {
        java.util.List<PedidoEstado> lista = new java.util.ArrayList<>();
        for (PedidoEstado e : historico) {
            lista.add(e);
        }
        return lista;
    }

    public boolean aceitar()  { return pedidoEstado.aceitar(this); }
    public boolean preparar() { return pedidoEstado.preparar(this); }
    public boolean cancelar() { return pedidoEstado.cancelar(this); }
    public boolean emRota()   { return pedidoEstado.emRota(this); }
    public boolean pronto()   { return pedidoEstado.pronto(this); }
    public boolean entregar() { return pedidoEstado.entregar(this); }
    public boolean devolver() { return pedidoEstado.devolver(this); }

    public void atualizarPedido() {
        pedidoEstado.atualizar(this);
        setChanged();
        notifyObservers();
    }

    public Pedido clone() throws CloneNotSupportedException {
        Pedido pedidoClone = (Pedido) super.clone();
        pedidoClone.itemCardapio = (ItemCardapio) pedidoClone.itemCardapio.clone();
        return pedidoClone;
    }

    @Override
    public String toString() {
        return pedidoEstado.getPedidoEstado();
    }
}