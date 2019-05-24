package models;

public class Consulta {
    private int id_consulta;
    private int id_ambu;
    private int id_medico;
    private int id_paciente;
    private int id_receita;
    private String data_marcada;
    private int hora;
   
    // Construtor exportador
    public Consulta(int id_ambu, int id_medico, int id_paciente, int id_receita, String data_marcada, int hora) {
        this.id_ambu = id_ambu;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.id_receita = id_receita;
        this.data_marcada = data_marcada;
        this.hora = hora;
    } 

    // Construtor importador
    public Consulta(int id_consulta, int id_ambu, int id_medico, int id_paciente, int id_receita, String data_marcada, int hora) {
        this.id_consulta = id_consulta;
        this.id_ambu = id_ambu;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.id_receita = id_receita;
        this.data_marcada = data_marcada;
        this.hora = hora;
    }

    // getter & setter
    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public int getId_ambu() {
        return id_ambu;
    }

    public void setId_ambu(int id_ambu) {
        this.id_ambu = id_ambu;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_receita() {
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
    }

    public String getData_marcada() {
        return data_marcada;
    }

    public void setData_marcada(String data_marcada) {
        this.data_marcada = data_marcada;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
   
}