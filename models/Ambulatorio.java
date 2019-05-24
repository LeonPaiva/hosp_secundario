package models;

public class Ambulatorio {

    private int id_ambu;
    private int numero;
    private int andar;
    private int capacidade;

    // Construtor exportador
    public Ambulatorio(int numero, int andar, int capacidade) {
        this.numero = numero;
        this.andar = andar;
        this.capacidade = capacidade;
    }

    // Construtor importador
    public Ambulatorio(int id_ambu, int numero, int andar, int capacidade) {
        this.id_ambu = id_ambu;
        this.numero = numero;
        this.andar = andar;
        this.capacidade = capacidade;
    }

    // Getter e setter
    public int getId_ambu() {
        return id_ambu;
    }

    public void setId_ambu(int id_ambu) {
        this.id_ambu = id_ambu;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
