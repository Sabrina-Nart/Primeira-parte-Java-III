
package model;

import enums.TipoEntrega;
import enums.TipoPagamento;
import java.time.LocalDate;
import java.util.LinkedList;

public class Pedido implements java.io.Serializable{
    private int id;
    private LocalDate data;
    private Cliente cliente;
    private TipoEntrega tipoEntrega;
    private TipoPagamento tipoPagamento;
    private Entregador entregador;
    private double total;
    //o pedido deve conhecer os seus itens
    private LinkedList<Item> listaItem = new LinkedList<>();
    //
    public Pedido() {
        this.setId(0);
        this.setData(null);
        this.setCliente(null);
        this.setTipoEntrega(TipoEntrega.R);
        this.setTipoPagamento(TipoPagamento.D);
        this.setEntregador(null);
        this.setTotal(0);
    }
    public Pedido(int id, LocalDate data, Cliente cliente, TipoEntrega tipoEntrega, TipoPagamento tipoPagamento, Entregador entregador, double total) {
        this.setId(id);
        this.setData(data);
        this.setCliente(cliente);
        this.setTipoEntrega(tipoEntrega);
        this.setTipoPagamento(tipoPagamento);
        this.setEntregador(entregador);
        this.setTotal(total);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setData(LocalDate data) {
        this.data = data==null?LocalDate.now():data;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
    public void setTotal(double total) {
        this.total = total<0 ? 0 : total;
    }
    public void setListaItem(LinkedList<Item> listaItem) {
        this.listaItem = listaItem;
    }  
    //
    public void addItem(Item item){
        this.listaItem.add(item);
    }
    //
    public int getId() {
        return this.id;
    }
    public LocalDate getData() {
        return this.data;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public TipoEntrega getTipoEntrega() {
        return this.tipoEntrega;
    }
    public TipoPagamento getTipoPagamento() {
        return this.tipoPagamento;
    }
    public Entregador getEntregador() {
        return this.entregador;
    }
    public double getTotal() {
        return this.total;
    }
    public LinkedList<Item> getListaItem() {
        return listaItem;
    }    
    //
    @Override
    public String toString() {
        return "Pedido{" + "data=" + data + ", cliente=" + cliente + ", total=" + total + '}';
    }
    //
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.id == other.id;
    }
    
}
