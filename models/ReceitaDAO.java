package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReceitaDAO {

    Conexao conex = new Conexao();

    public boolean insertReceita(Receita pac) {
        String sql = "INSERT INTO receita VALUES (DEFAULT,?,?,?,?)";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, pac.getId_medico());
            psmt.setInt(2, pac.getId_paciente());
            psmt.setInt(3, pac.getId_cid());
            psmt.setString(4, pac.getDescricao());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir receita!!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean updateReceita(Receita pac) {
        String sql = "UPDATE receita SET rg = ?, nome = ?, nasc = ?, cidade = ? WHERE id_receita = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, pac.getId_medico());
            psmt.setInt(2, pac.getId_paciente());
            psmt.setInt(3, pac.getId_cid());
            psmt.setString(4, pac.getDescricao());
            psmt.setInt(5, pac.getId_receita());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar receita!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deleteReceita(Receita pac) {
        String sql = "DELETE FROM receita WHERE id_receita = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, pac.getId_receita());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir receita!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public ArrayList selectReceita(String nome, String rg, String nasc, String cidade) {
        String sql = "SELECT nome, rg, nasc, cidade FROM receita "
                + "WHERE nome LIKE '%" + nome + "%'";
        if (!rg.isEmpty()) {
            sql += " AND rg LIKE '%" + rg + "%'";
        }
        if (!nasc.isEmpty()) {
            sql += " AND nasc LIKE '%" + nasc + "%'";
        }
        if (!cidade.isEmpty()) {
            sql += " AND cidade LIKE '%" + cidade + "%'";
        }
        ArrayList listaPac = new ArrayList();
        System.out.println(sql);
        conex.conectar();
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                Object[] linha = new Object[]{conex.rs.getString(1), conex.rs.getString(2), conex.rs.getString(3),
                    conex.rs.getString(4)};
                listaPac.add(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lista de receita!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }

        return listaPac;
    }

    public int selectReceita_Id(String rg) {
        String sql = "select id_receita from receita where rg = " + rg + ";";
        conex.conectar();
        int id = 0;
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                id = conex.rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar ID de receita!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
         System.out.println(id);
        return id;
    }
}
