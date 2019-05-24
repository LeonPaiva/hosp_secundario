package models;

public class Cid {
    private int id_cid;
    private String descricao;

   // Construtor exportador
    public Cid(String descricao) {
        this.descricao = descricao;
    }

     // Construtor importador
    public Cid(int id_cid, String descricao) {
        this.id_cid = id_cid;
        this.descricao = descricao;
    }
    
    // Getter e Setter
    public int getId_cid() {
        return id_cid;
    }

    public void setId_cid(int id_cid) {
        this.id_cid = id_cid;
    }

    public String getTitulo() {
        return descricao;
    }

    public void setTitulo(String descricao) {
        this.descricao = descricao;
    }  
}