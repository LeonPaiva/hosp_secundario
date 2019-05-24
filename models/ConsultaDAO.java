package models;

import db.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaDAO {

    Conexao conex = new Conexao();

    public void insertConsulta(Consulta consu) {
        String sql = "INSERT INTO consulta VALUES (DEFAULT,?,?,?,?,?,?)";
        conex.conectar();
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, consu.getId_ambu());
            psmt.setInt(2, consu.getId_medico());
            psmt.setInt(3, consu.getId_paciente());
            psmt.setInt(4, consu.getId_receita());
            psmt.setString(5, consu.getData_marcada());
            psmt.setInt(6, consu.getHora());
            psmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
    }

    public ArrayList selectConsulta(String ambu, String andar, String fNome, String pNome, String dataMarcada, String hora) {
        String sql = "SELECT ambu.numero, ambu.andar, func.nome, pac.nome, con.data_marcada, con.hora from FROM consulta as con"
                + "INNER JOIN paciente as pac on id_paciente "
                + "INNER JOIN ambulatorio as ambu "
                + "INNER JOIN funcionario as func "
                + "WHERE ambu.numero '%" + ambu + "%'";
        if (!andar.isEmpty()) {
            sql += " AND ambu.andar = '" + andar + "'";
        }
        if (!fNome.isEmpty()) {
            sql += " AND func.nome LIKE '%" + fNome + "%'";
        }
        if (!pNome.isEmpty()) {
            sql += " AND pac.nome LIKE '%" + pNome + "%'";
        }
        if (!dataMarcada.isEmpty()) {
            sql += " AND con.data_marcada = '" + dataMarcada + "'";
        }
        if (!hora.isEmpty()) {
            sql += " AND con.hora = '" + hora + "'";
        }
        ArrayList lista = new ArrayList();
        System.out.println(sql);
        conex.conectar();
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                Object[] linha = new Object[]{conex.rs.getString(1), conex.rs.getString(2), conex.rs.getString(3),
                    conex.rs.getString(4)};
                lista.add(linha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar à base de dados de consulta!");
            System.out.println(ex);
        } finally {
            conex.desconectar();
        }

        return lista;
    }

    public boolean updateConsulta(Consulta consu) {
        String sql = "UPDATE consulta SET id_ambu = ?, id_medico = ?, id_paciente = ?, id_receita = ?, data_marcada = ?, hora = ? WHERE id_consulta = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, consu.getId_ambu());
            psmt.setInt(2, consu.getId_medico());
            psmt.setInt(3, consu.getId_paciente());
            psmt.setInt(4, consu.getId_receita());
            psmt.setString(5, consu.getData_marcada());
            psmt.setInt(6, consu.getHora());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar consulta!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }

    public boolean deleteConsulta(Consulta con) {
        String sql = "DELETE FROM consulta WHERE id_consulta = ?";
        conex.conectar();
        boolean flag;
        try {
            PreparedStatement psmt = conex.con.prepareStatement(sql);
            psmt.setInt(1, con.getId_ambu());
            psmt.execute();
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir consulta!" + e);
            System.out.println(e);
            flag = false;
        } finally {
            conex.desconectar();
        }
        return flag;
    }public int selectConsulta_Id(int id_receita) {
        String sql = "select id_ambu from ambulatorio where rg = " + id_receita + ";";
        conex.conectar();
        int id = 0;
        try {
            conex.executarSQL(sql);
            while (conex.rs.next()) {
                id = conex.rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar ID de consulta!" + e);
            System.out.println(e);
        } finally {
            conex.desconectar();
        }
        System.out.println(id);
        return id;
    }}
