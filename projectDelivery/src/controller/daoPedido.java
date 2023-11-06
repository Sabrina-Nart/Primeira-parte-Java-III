package controller;
import abstratas.BaseDao;
import enums.TipoEntrega;
import enums.TipoPagamento;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import model.Pedido;

public class daoPedido extends BaseDao {
    
    public int create(Pedido pedido) throws SQLException{ // Insert na tabela de PEDIDOS
        String SQL= "insert int pedido(data,id_cliente,tipo_entrega,tipo_pagamento,id_entregador,total)values(?,?,?,?,?,?)";
    
    return super.executeUpdate(SQL, pedido.getData(), 
                                    pedido.getCliente().getId(),
                                    pedido.getTipoEntrega().name(),//.name = identifica oq vc qer pegar
                                    pedido.getTipoPagamento().name(),
                                    pedido.getEntregador().getId(),//chave estrangeira
                                    pedido.getTotal());
    }
    
     public int update(Pedido pedido) throws SQLException{ // Insert na tabela de PEDIDOS
        String SQL= "update pedido set data=?,"
                + "id_cliente=?,"
                + "tipo_entrega=?,"
                + "tipo_pagamento=?,"
                + "id_entregador=?,"
                + "total=? "
                + "where id =?";
    
    return super.executeUpdate(SQL, pedido.getData(), 
                                    pedido.getCliente().getId(),
                                    pedido.getTipoEntrega().name(),//.name = identifica oq vc qer pegar
                                    pedido.getTipoPagamento().name(),
                                    pedido.getEntregador().getId(),//chave estrangeira
                                    pedido.getTotal(),
                                    pedido.getId()
                                    );
    }
     public int delete (Pedido pedido) throws SQLException{
         return super.executeUpdate("delete from pedido where id= " + pedido.getId());
     }
     
     public Pedido read(int id) throws SQLException{
         String SQL = "select * from pedido where id=?";
         ResultSet rs = super.executeQuery(SQL, id);
         return(rs.next()? createObject(rs):null);
     }
     
     public List<Pedido> read() throws SQLException{
         String SQL = "select * from pedido order by";
         ResultSet rs = super.executeQuery(SQL);
         List<Pedido> retorno = new LinkedList<>();
         while(rs.next()){
            retorno.add(createObject(rs));
     }
         return (retorno);
     }
     
     

     public Pedido createObject(ResultSet rs) throws SQLException{
         return new Pedido(
                            rs.getInt("id"),
                            rs.getDate("data").toLocalDate(),
                            new daoCliente().read(rs.getInt("id_cliente")),
                            TipoEntrega.valueOf(rs.getString("tipo entrega")),
                            TipoPagamento.valueOf(rs.getString("tipo pagamento")),
                            new daoEntregador().read(rs.getInt("id_entregador")),
                            rs.getDouble("total"));
     }
}
