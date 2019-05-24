package models;

public class Remedio {
    private int id_remedio;
    private String descricao;
    private String tipo;

    // Construtor exportador
    public Remedio(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }
    // Construtor importador
    public Remedio(int id_remedio, String tipo, String descricao) {    
        this.id_remedio = id_remedio;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    // Getter & Setter
    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
