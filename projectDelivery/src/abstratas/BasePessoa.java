
package abstratas;

abstract public class BasePessoa extends Base{
    private String telefone;
    //
    public BasePessoa(){
        super();
        this.setTelefone("(00)00000-0000");
    }
    public BasePessoa(int id,String nome,String telefone){
        super(id,nome);
        this.setTelefone(telefone);
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty()?"(00)00000-0000":telefone;
    }
    public String getTelefone() {
        return telefone;
    }    
}
