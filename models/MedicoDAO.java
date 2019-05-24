package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MedicoDAO {

    Conexao conex = new Conexao();

    //selectMedico incluso em FuncionarioDAO.SelectFuncionario()
    public void insertMedico(Medico med) {
        String sql = "INSERT INTO medico VALUES (DEFAULT,?,?,?)";
        conex.conectar();
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, med.getCrm());
            psmt.setInt(2, med.getId_medico());
            psmt.setInt(3, med.getId_espec());
            psmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
    }

    public boolean updateMedico(Medico med) {
        String sql = "UPDATE medico SET crm = ?, id_func = ?, id_espec = ? WHERE id_med = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, med.getCrm());
            psmt.setInt(2, med.getId_func());
            psmt.setInt(3, med.getId_espec());
            psmt.setInt(4, med.getId_medico());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar médico!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deleteFuncionario(Medico med) {
        String sql = "DELETE FROM funcionario WHERE id_func = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, med.getId_medico());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public int selectFuncionario_Id(String crm) {
        String sql = "select id_medico from medico where crm = " + crm + ";";
        conex.conectar();
        int id = 0;
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                id = conex.rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
        return id;
    }
}
