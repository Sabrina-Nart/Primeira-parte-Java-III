
package enums;

public enum TipoPagamento {
    D("Dinheiro"),
    C("Cartão Débito/Crédito"),
    P("Pix");
    //
    private String descricao;
    //
    private TipoPagamento(String descricao) {
        this.descricao = descricao;
    }
    //
    @Override
    public String toString() {
        return descricao;
    }
}
