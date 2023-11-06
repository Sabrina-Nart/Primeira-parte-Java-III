package controller;
import java.sql.*;
import abstratas.BaseDao;
import java.util.LinkedList;
import java.util.List;
import model.Item;
import model.Pedido;

public class daoItem extends BaseDao{
    public int create(Item item) throws SQLException{
        String SQL = "insert into item(id_pedido,"
                + "id_produto,"
                + "observacoes,"
                + "quantidade,preco) values (?,?,?,?,?)";
        
        return super.executeUpdate(SQL, item.getPedido().getId(),
                                        item.getProduto().getId(),
                                        item.getObservacoes(), 
                                        item.getQuantidade(), 
                                        item.getPreco()
                                        );
    }   
    
    public int update(Item item) throws SQLException{
        String SQL = "update item set id_pedido=?"
                + "id_produto=?,"
                + "observacoes=?,"
                + "quantidade=?,preco=? where id=?";
        
         return super.executeUpdate(SQL, item.getPedido().getId(),
                                        item.getProduto().getId(),
                                        item.getObservacoes(), 
                                        item.getQuantidade(), 
                                        item.getPreco()
                                        );
    }
    
    public int delete(Item item) throws SQLException{
        return super.executeUpdate("Delete from item where id=?", item.getId());
    }
    
  
//
public Item read(int id) throws SQLException{
    String SQL="select * from item where id="+id;
    ResultSet rs = super.executeQuery(SQL);
    return(rs.next()? createObject(rs):null);
    
    }    

public List<Item> read (Pedido pedido) throws SQLException{
    String SQL = "select * from item where id_pedido";
    ResultSet rs = super.executeQuery(SQL, pedido.getId());
    List<Item> retorno = new LinkedList<>();
    while (rs.next()){
        retorno.add(createObject(rs));        
    }
    return retorno;
}

public Item createObject(ResultSet rs) throws SQLException{
     return new Item(
             rs.getInt("id"),
             new daoPedido().read(rs.getInt("id pedido")),
            new daoProduto().read(rs.getInt("id produto")),
         rs.getString("Observacoes"),
          rs.getDouble("Quantidade"),
             rs.getDouble("peco"));
 }

}
