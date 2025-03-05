/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryarchivos;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Wesly
 */
public class ModeloAmigos extends AbstractTableModel {
    private  ListaDeAmigos amigos;

    public ModeloAmigos() {
        amigos=new ListaDeAmigos();
        amigos.cargarAmigos();
    }
    
    @Override
    public int getRowCount() {
        return amigos.total();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Amigo aux=amigos.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getNumero();
            default: return aux.getNombre();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0: return "NUMERO";
            default: return "NOMBRE";
        }
    }
    
    @Override
    public Class getColumnClass(int col) {
        switch(col){
            case 0: return String.class;
            default: return Long.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;        
    }
    
    @Override
    public void setValueAt(Object value, int fila, int columna) {
        Amigo aux=amigos.obtener(fila);
        switch(columna){
            case 0: aux.setNombre((String)value);
                    break;
            default: aux.setNumero((long)value);
        }
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarAmigo(Amigo amigo){
        amigos.agregar(amigo);
        this.fireTableDataChanged();   
    }
    
    public void eliminarAmigo(int indice){
        amigos.eliminar(indice);
        this.fireTableDataChanged(); 
    }
    
    public void guardarEnArchivo(){
        amigos.guardarEnArchivo();
    }
}

