package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EspecialidadeDAO {

    Conexao conex = new Conexao();

    public static class listaEspec {

        public int id_espec;
        public String nome;
        public listaEspec ant;
        public listaEspec prox;
    }

    public boolean insertEspecialidade(Especialidade espec) {
        String sql = "INSERT INTO especialidade VALUES (DEFAULT,?)";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setString(1, espec.getNome());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public List<Especialidade> selectEspecialidade() {
        conex.conectar();
        List<Especialidade> listEspec = new ArrayList();
        try {
            Statement st = conex.con.createStatement();
            st.executeQuery("SELECT * FROM especialidade");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Especialidade x = new Especialidade(rs.getInt("id_espec"), rs.getString("nome"));
                listEspec.add(x);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro: " + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
        return listEspec;
    }
    public boolean updateEspecialidade(Especialidade espec) {
        String sql = "UPDATE especialidade SET nome = ? WHERE id_espec = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, espec.getId_espec());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar especialidade!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deleteEspecialidade(Especialidade espec) {
        String sql = "DELETE FROM especialidade WHERE id_espec = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, espec.getId_espec());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir especialidade!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }
}
