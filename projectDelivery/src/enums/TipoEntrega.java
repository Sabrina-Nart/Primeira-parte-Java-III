
package enums;

public enum TipoEntrega {
    E("Entrega"),
    R("Retirar no Balcão");
    //
    private String descricao;
    //
    private TipoEntrega(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }
}
