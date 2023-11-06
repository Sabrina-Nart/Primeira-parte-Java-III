
package model;

import abstratas.Base;

public class Produto extends Base{
    private String descricao;
    private double preco;
    private Categoria categoria;
    //
    public Produto() {
        super();
        this.setDescricao("vazio");
        this.setPreco(0);
        this.setCategoria(null);
    }
    public Produto(int id, String nome,String descricao, double preco, Categoria categoria) {
        super(id, nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setCategoria(categoria);    
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty()?"VAZIA":descricao.toUpperCase();
    }

    public void setPreco(double preco) {
        this.preco = preco<0 ? 0.01 : preco;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    //
    public String getDescricao() {
        return this.descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
}
