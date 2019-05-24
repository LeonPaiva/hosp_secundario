package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CidDAO_select {
    Conexao conex = new Conexao();
    
   public ArrayList selectCid(String cid, String descricao){
        String sql = "SELECT id_cid, descricao FROM cid"
                + "WHERE id_cid = '%"+cid+"%'";
        if (!cid.isEmpty()){
            sql += " and descricao LIKE '%"+descricao+"%'";
        }
        ArrayList lista = new ArrayList();
        System.out.println(sql);
        conex.conectar();
            try {
                conex.executarSQL(sql);
                while(conex.rs.next()){
                    Object[] linha = new Object[]{conex.rs.getString(1),conex.rs.getString(2),
                            conex.rs.getString(4)};
                    lista.add(linha);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar lista de CID!");
                System.out.println(ex);
            } finally{
                conex.desconectar();
            }
            return lista;
     }
}
