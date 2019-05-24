package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTabela extends AbstractTableModel {
    
    private ArrayList linhas;
    private String[] colunas;

    public ModelTabela(ArrayList linhas, String[] colunas) {
        this.colunas = colunas;
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    @Override
    public String toString() {
        return "ModelTabela{" + "colunas=" + colunas + ", linhas=" + linhas + '}';
    }
    
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    
    @Override
    public int getColumnCount () {
        return colunas.length;
    }
    
    @Override
    public String getColumnName (int numCol){
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha = (Object[]) this.getLinhas().get(rowIndex);
        return linha[columnIndex];
    }
    
}
