
package controller;

import abstratas.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Entregador;

public class daoEntregador extends BaseDao{
        public int create(Entregador entregador) throws SQLException{
        String SQL="insert into entregador (nome,telefone) values (?,?)";
        return super.executeUpdate(SQL, entregador.getNome(),entregador.getTelefone());
    }
    public int update(Entregador entregador) throws SQLException{
        String SQL="update entregador set nome=?, telefone=? where id=?";
        return super.executeUpdate(SQL, entregador.getNome(),entregador.getTelefone(),entregador.getId());
    }    
    public int delete(Entregador entregador) throws SQLException{
        String SQL="delete entregador where id=?";
        return super.executeUpdate(SQL, entregador.getId());
    }
    //
    public Entregador read(int id) throws SQLException{
        String SQL="select * from entregador where id="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? this.createObject(rs) : null);
    }
    public List<Entregador> read() throws SQLException{
        String SQL="select * from entregador order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Entregador> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(this.createObject(rs));
        }
        return (retorno);
    }    
    //
    private Entregador createObject(ResultSet rs) throws SQLException{
        return new Entregador(rs.getInt("id"), rs.getString("nome"),rs.getString("telefone"));
    }

    
}
