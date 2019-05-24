package models;

public class Receita {
    private int id_receita;
    private int id_medico;
    private int id_paciente;
    private int id_cid;
    private String descricao;

    // Construtor exportador
    public Receita(int id_medico, int id_paciente, int id_cid, String descricao) {
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.id_cid = id_cid;
        this.descricao = descricao;
    }

    // Construtor importador
    public Receita(int id_receita, int id_medico, int id_paciente, int id_cid, String descricao) {    
        this.id_receita = id_receita;
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.id_cid = id_cid;
        this.descricao = descricao;
    }

    // Getter & Setter
    public int getId_receita() {    
        return id_receita;
    }

    public void setId_receita(int id_receita) {
        this.id_receita = id_receita;
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

    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
