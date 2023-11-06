
package controller;

import abstratas.BaseDao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Produto;

public class daoProduto extends BaseDao {
    public int create(Produto produto) throws SQLException{
        String SQL="insert into produto (nome,descricao,preco,id_categoria) values (?,?,?,?)";
        return super.executeUpdate(SQL, produto.getNome(),produto.getDescricao(),produto.getPreco(),produto.getCategoria().getId());
    }
    public int update(Produto produto) throws SQLException{
        String SQL="update produto set nome=?,descricao=?,preco=?,id_categoria=? where id=?";
        return super.executeUpdate(SQL, produto.getNome(),produto.getDescricao(),produto.getPreco(),produto.getCategoria().getId(),produto.getId());
    }
    public int delete(Produto produto) throws SQLException{
        return super.executeUpdate("delete from produto where id="+produto.getId());
    }
    //
    public Produto read(int id) throws SQLException{
        String SQL="select * from produto where id="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next() ? createObject(rs) : null);
    }
    public List<Produto> read() throws SQLException{
        String SQL="select * from produto order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Produto> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(createObject(rs));
        }
        return retorno;
    }    
    public List<Produto> read(String filtroNome) throws SQLException{
        String SQL="select * from produto where nome like ? order by nome";
        ResultSet rs = super.executeQuery(SQL,"%"+filtroNome.toUpperCase()+"%");
        List<Produto> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(createObject(rs));
        }
        return retorno;
    } 
    private Produto createObject(ResultSet rs) throws SQLException {
        return new Produto(
                rs.getInt("id"), 
                rs.getString("nome"), 
                rs.getString("descricao"), 
                rs.getDouble("preco"), 
                new daoCategoria().read(rs.getInt("id_categoria"))
        );
    }
}
