
package controller;

import abstratas.BaseDao;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import model.Categoria;

public class daoCategoria extends BaseDao{
    public int create(Categoria categoria) throws SQLException{
        String SQL="insert into categoria (nome) values (?)";
        return super.executeUpdate(SQL, categoria.getNome());
    }
    public int update(Categoria categoria) throws SQLException{
        String SQL="update categoria set nome=? where id=?";
        return super.executeUpdate(SQL, categoria.getNome(),categoria.getId());
    }    
    public int delete(Categoria categoria) throws SQLException{
        String SQL="delete categoria where id=?";
        return super.executeUpdate(SQL, categoria.getId());
    }
    //
    public Categoria read(int id) throws SQLException{
        String SQL="select * from categoria where id="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);
    }
    public List<Categoria> read() throws SQLException{
        String SQL="select * from categoria order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Categoria> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(this.createObject(rs));
        }
        return (retorno);
    }
    
    //
    private Categoria createObject(ResultSet rs) throws SQLException{
        return new Categoria(rs.getInt("id"), rs.getString("nome"));
    }
    
}
