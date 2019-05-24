package models;

public class Medico {
    private int id_medico;
    private int crm;
    private int id_func;
    private int id_espec;
    
    // Construtor exportador
    public Medico(int crm, int id_func, int id_espec) {
        this.crm = crm;
        this.id_func = id_func;
        this.id_espec = id_espec;
    }
    // Construtor importador
    public Medico(int id_medico, int crm, int id_func, int id_espec) {
        this.id_medico = id_medico;
        this.crm = crm;
        this.id_func = id_func;
        this.id_espec = id_espec;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public int getId_espec() {
        return id_espec;
    }

    public void setId_espec(int id_espec) {
        this.id_espec = id_espec;
    }
      
}