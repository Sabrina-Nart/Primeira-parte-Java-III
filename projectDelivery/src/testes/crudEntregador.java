
package testes;

import controller.daoEntregador;
import java.sql.SQLException;
import model.Entregador;

public class crudEntregador {
    public static void main(String[] args) {
        Entregador e1 = new Entregador(0, "joaquim", "(48)99987-3745");
        Entregador e2 = new Entregador(0, "marquito", "(48)99887-6543");
        Entregador e3 = new Entregador(0, "bola", "(48)99999-1234");
        Entregador e4 = new Entregador(0, "carrasco", "(00)12340-5432");
        daoEntregador dao = new daoEntregador();
        try{
            /*
            dao.create(e1);
            dao.create(e2);
            dao.create(e3);
            dao.create(e4);
            */
            e1.setId(1);
            e1.setNome("joaquim jorge");
            //dao.update(e1);
            Entregador retorno = dao.read(3);
            
            System.out.println(retorno==null ? "Não localizado" : retorno.getNome());
            
            for (Entregador e : dao.read()) {
                System.out.println(e.getId()+"\t"+e.getNome()+"\t"+e.getTelefone());
            }
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
                
    }
}
