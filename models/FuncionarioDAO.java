package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Conexao conex = new Conexao();

    public boolean insertFuncionario(Funcionario func) {
        String sql = "INSERT INTO funcionario VALUES (DEFAULT,?,?,?,?,?)";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setString(1, func.getRg());
            psmt.setString(2, func.getNome());
            psmt.setString(3, func.getNasc());
            psmt.setString(4, func.getCidade());
            psmt.setInt(5, func.getSalario());
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

    public ArrayList selectFuncionario(String nome, String rg, int id_espec) {
        String sql = "SELECT f.nome, f.rg, f.nasc, f.cidade, f.salario, med.crm, esp.nome FROM funcionario as f "
                + "LEFT JOIN medico as med "
                + "ON med.id_func = f.id_func "
                + "LEFT JOIN especialidade as esp "
                + "ON esp.id_espec = med.id_espec "
                + "WHERE f.nome LIKE '%" + nome + "%'";
        if (id_espec != 0) {
            sql += " AND med.id_espec = '" + id_espec + "' ";
        }
        if (!rg.isEmpty()) {
            sql += " AND f.rg = '" + rg + "'";
        }
        ArrayList listaFuncs = new ArrayList();

        conex.conectar();
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                Object[] linha = new Object[]{conex.rs.getString(1), conex.rs.getString(2), conex.rs.getString(3),
                    conex.rs.getString(4), conex.rs.getString(5), conex.rs.getString(6), conex.rs.getString(7)};
                listaFuncs.add(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar à base de dados da lista!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }

        return listaFuncs;
    }

    public boolean updateFuncionario(Funcionario func) {
        String sql = "UPDATE funcionario SET rg = ?, nome = ?, nasc = ?, cidade = ?, salario = ? WHERE id_func = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setString(1, func.getRg());
            psmt.setString(2, func.getNome());
            psmt.setString(3, func.getNasc());
            psmt.setString(4, func.getCidade());
            psmt.setInt(5, func.getSalario());
            psmt.setInt(6, func.getId_func());
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

    public boolean deleteFuncionario(Funcionario func) {
        String sql = "DELETE FROM funcionario WHERE id_func = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, func.getId_func());
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

    public int selectFuncionario_Id(String rg) {
        String sql = "select id_func from funcionario where rg = " + rg + ";";
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
