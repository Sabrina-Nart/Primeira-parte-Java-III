
package model;

import abstratas.BasePessoa;

public class Cliente extends BasePessoa{
    private String endereco;
    private String referencia;
    private Cidade cidade;
    //

    public Cliente() {
        super();
        this.setEndereco("vazio");
        this.setReferencia("");
        this.setCidade(null);        
    }

    public Cliente(int id, String nome, String telefone,String endereco,String referencia,Cidade cidade) {
        super(id, nome, telefone);
        this.setEndereco(endereco);
        this.setReferencia(referencia);
        this.setCidade(cidade);    
    }
    //

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"VAZIO":endereco.toUpperCase();
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia.toUpperCase();
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    //

    public String getEndereco() {
        return this.endereco;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public Cidade getCidade() {
        return this.cidade;
    }
}
