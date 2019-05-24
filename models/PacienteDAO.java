package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteDAO {

    Conexao conex = new Conexao();

    public boolean insertPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente VALUES (DEFAULT,?,?,?,?)";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setString(1, paciente.getRg());
            psmt.setString(2, paciente.getNome());
            psmt.setString(3, paciente.getNasc());
            psmt.setString(4, paciente.getCidade());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir paciente!!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean updatePaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET rg = ?, nome = ?, nasc = ?, cidade = ? WHERE id_paciente = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setString(1, paciente.getRg());
            psmt.setString(2, paciente.getNome());
            psmt.setString(3, paciente.getNasc());
            psmt.setString(4, paciente.getCidade());
            psmt.setInt(5, paciente.getId_paciente());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar paciente!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deletePaciente(Paciente paciente) {
        String sql = "DELETE FROM paciente WHERE id_paciente = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, paciente.getId_paciente());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir paciente!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public ArrayList selectPaciente(String nome, String rg, String nasc, String cidade) {
        String sql = "SELECT nome, rg, nasc, cidade FROM paciente "
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
            JOptionPane.showMessageDialog(null, "Erro ao consultar lista de paciente!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }

        return listaPac;
    }

    public int selectPaciente_Id(String rg) {
        String sql = "select id_paciente from paciente where rg = " + rg + ";";
        conex.conectar();
        int id = 0;
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                id = conex.rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar ID de paciente!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
         System.out.println(id);
        return id;
    }
}
