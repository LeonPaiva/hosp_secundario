package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AmbulatorioDAO {

    Conexao conex = new Conexao();

    public boolean insertAmbulatorio(Ambulatorio amb) {
        String sql = "INSERT INTO ambulatorio VALUES (DEFAULT,?,?,?)";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, amb.getNumero());
            psmt.setInt(2, amb.getAndar());
            psmt.setInt(3, amb.getCapacidade());
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

    public boolean updateAmbulatorio(Ambulatorio ambu) {
        String sql = "UPDATE ambulatorio SET numero = ?, andar = ?, capacidade = ? WHERE id_ambu = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, ambu.getNumero());
            psmt.setInt(2, ambu.getAndar());
            psmt.setInt(3, ambu.getCapacidade());
            psmt.setInt(4, ambu.getId_ambu());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar ambulatório!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deleteAmbulatorio(Ambulatorio ambu) {
        String sql = "DELETE FROM ambulatorio WHERE id_ambu = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, ambu.getId_ambu());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir ambulatório!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public ArrayList selectAmbulatorio(String num, String andar, String capacidade) {
        String sql = "SELECT numero, andar, capacidade FROM ambulatorio "
                + "WHERE numero LIKE '%" + num + "%'";
        if (!andar.isEmpty()) {
            sql += " AND andar LIKE '%" + andar + "%'";
        }
        if (!capacidade.isEmpty()) {
            sql += " AND capacidade LIKE '%" + capacidade + "%'";
        }
        ArrayList lista = new ArrayList();
        System.out.println(sql);
        conex.conectar();
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                Object[] linha = new Object[]{conex.rs.getString(1), conex.rs.getString(2), conex.rs.getString(3)};
                lista.add(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lista de ambulatório!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }
        return lista;
    }

    public int selectAmbulatorio_Id(int numero, int andar) {
        String sql = "select id_ambu from ambulatorio where numero = " + numero + " AND andar = " + andar + ";";
        conex.conectar();
        int id = 0;
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                id = conex.rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar ID do ambulatório!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
        System.out.println(id);
        return id;
    }
}
