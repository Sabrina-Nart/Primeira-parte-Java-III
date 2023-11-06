
package abstratas;

import model.SwingColumn;

abstract public class Base implements java.io.Serializable{
    @SwingColumn(description = "Código")
    private int id;
    @SwingColumn(description = "Nome")
    private String nome;
    //
    public Base() {
        this.setId(0);
        this.setNome("sem nome");
    }
    public Base(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }
    //
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM NOME":nome.toUpperCase();
    }
    //
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    //
    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Base other = (Base) obj;
        return this.id == other.id;
    }
    
}
