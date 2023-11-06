
package testes;

import controller.daoCidade;
import java.sql.SQLException;
import model.Cidade;

public class crudCidade {
    public static void main(String[] args) {
        Cidade c1 = new Cidade(0, "criciuma");
        Cidade c2 = new Cidade(0, "cocal do sul");
        Cidade c3 = new Cidade(0, "nova veneza");
        Cidade c4 = new Cidade(0, "sideropolis");
        //criar um objeto para acesar os recursos da table cidade
        daoCidade dao = new daoCidade();
        try{
            /*
            dao.create(c1);
            dao.create(c2);
            dao.create(c3);
            dao.create(c4);

            Cidade c = new Cidade(2, "cocal");
            //System.out.println(dao.update(c));
            System.out.println(dao.delete(c));
            */
            Cidade c = dao.read(3);
            System.out.println((c==null?"Não Localizado":c.getNome()));
            //
            //
            for (Cidade cidade : dao.read()) {
                System.out.println(cidade.getId()+"\t"+cidade.getNome());
            }
            
        }catch(SQLException ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
    }
    
}
