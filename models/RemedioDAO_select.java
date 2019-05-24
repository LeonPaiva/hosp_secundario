package models;

import db.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RemedioDAO_select {

    Conexao conex = new Conexao();

    public ArrayList selectRemedio(String id, String descricao, String tipo) {
        String sql = "SELECT tipo, descricao FROM remedio"
                + "WHERE descricao = '%" + descricao + "%'";
        if (!tipo.isEmpty()) {
            sql += " and tipo LIKE '%" + tipo + "%'";
        }
        ArrayList listaRemedio = new ArrayList();
        System.out.println(sql);
        conex.conectar();
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                Object[] linha = new Object[]{conex.rs.getString(1), conex.rs.getString(2)};
                listaRemedio.add(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar à base de dados da lista!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }

        return listaRemedio;
    }
}
