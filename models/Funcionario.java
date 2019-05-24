package models;

public class Funcionario {
    private int id_func;
    private String rg;
    private String nome;
    private String nasc;
    private String cidade;
    private int salario;

    // Construtor exportador
    public Funcionario(String rg, String nome, String nasc, String cidade, int salario) {
        this.rg = rg;
        this.nome = nome;
        this.nasc = nasc;
        this.cidade = cidade;
        this.salario = salario;
    }
    // Construtor importador
    public Funcionario(int id_func, String rg, String nome, String nasc, String cidade, int salario) {
        this.id_func = id_func;
        this.rg = rg;
        this.nome = nome;
        this.nasc = nasc;
        this.cidade = cidade;
        this.salario = salario;
    }
    // getter & setter
    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
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

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
}
