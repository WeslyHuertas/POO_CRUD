/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryarchivos;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Wesly
 */
public class ListaDeAmigos {
    private LinkedList<Amigo> amigos;

    public ListaDeAmigos() {
        amigos=new LinkedList();
    }
    
    public void agregar(Amigo a){
        amigos.add(a);
    }
    
    public void eliminar(int indice){
        amigos.remove(indice);
    }
       
       
    public int total(){
        return amigos.size();
    }
    
    public Amigo obtener(int indice){
        return amigos.get(indice);
    }
    
       
    public void cargarAmigos(){
        BDAmigos bd=new BDAmigos();
        amigos=bd.obtener();        
    }
    
    public void guardarEnArchivo(){
        BDAmigos bd=new BDAmigos();
        bd.borrarTodo();
        for (int i=0;i<amigos.size();i++){
            bd.registrarAmigo(amigos.get(i));            
        }
    }

}
