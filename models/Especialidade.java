package models;

public class Especialidade {
    private int id_espec;
    private String nome;

    // Construtor exportador
    public Especialidade(String nome) {
        this.nome = nome;
    }

    public Especialidade() {
    }
    
    // Construtor importador
    public Especialidade(int id_espec, String nome) {
        this.id_espec = id_espec;
        this.nome = nome;
    }

    public int getId_espec() {
        return id_espec;
    }

    public void setId_espec(int id_espec) {
        this.id_espec = id_espec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
