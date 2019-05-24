package models;

public class Paciente {
    private int id_paciente;
    private String rg;
    private String nome;
    private String nasc;
    private String cidade;

    // Construtor exportador
    public Paciente(String rg, String nome, String nasc, String cidade) {
        this.rg = rg;
        this.nome = nome;
        this.nasc = nasc;
        this.cidade = cidade;
    }
    // Construtor importador
    public Paciente(int id_paciente, String rg, String nome, String nasc, String cidade) {
        this.id_paciente = id_paciente;
        this.rg = rg;
        this.nome = nome;
        this.nasc = nasc;
        this.cidade = cidade;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    
}
