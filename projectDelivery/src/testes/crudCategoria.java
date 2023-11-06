
package testes;

import banco.Dados;
import java.sql.*;

public class crudCategoria {
    public static int addCategoria(String nome) throws SQLException{
        String SQL="insert into categoria (nome) values(?)";
        PreparedStatement pst = 
        Dados.getConnection().prepareStatement(SQL);
        pst.setString(1, nome.toUpperCase());
        return pst.executeUpdate();        
    }
    //
    public static void main(String[] args) {
        try{
            addCategoria("refrigerantes");
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }    
}
