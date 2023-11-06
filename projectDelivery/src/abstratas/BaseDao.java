
package abstratas;

import banco.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class BaseDao {
    //retorna um PreparedStatement criado com um SQL
    private PreparedStatement getStatement(String SQL) throws SQLException{
            return Dados.getConnection().prepareStatement(SQL);
    }
    //recebe uma lista de parametros e faz a execução
    //em um PreparedStatement
    protected int executeUpdate(String SQL,Object... args) throws SQLException{
        //criar o pst
        PreparedStatement pst = this.getStatement(SQL);
        //passagem de parametros
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        //executar
        return pst.executeUpdate();
    }
    protected ResultSet executeQuery(String SQL,Object... args) throws SQLException{
        //criar o pst
        PreparedStatement pst = this.getStatement(SQL);
        //passagem de parametros
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        //executar
        return pst.executeQuery();
    }    
}
