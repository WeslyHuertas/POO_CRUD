/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pryarchivos;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Wesly
 */
public class BDAmigos {
    
    public LinkedList<Amigo> obtener(){
        LinkedList<Amigo> amigos=null;
        Archivo archivo=new Archivo("amigos.txt");
        LinkedList<String> lineas=archivo.obtenerTextoDelArchivo();
        if(lineas!=null){
            amigos=new LinkedList();
            for(int i=0;i<lineas.size();i++){
                String linea=lineas.get(i);
                StringTokenizer tokens=new StringTokenizer(linea,";");
                String nombre=tokens.nextToken();
                long numero=Long.parseLong(tokens.nextToken());                
                amigos.add(new Amigo(nombre, numero));
            }
        }
        return amigos;
    }
    
    public boolean registrarAmigo(Amigo p){
        Archivo archivo=new Archivo("amigos.txt");
        return archivo.registrar(p.getNombre() + ";"
               + p.getNumero());
    }
    
    public boolean borrarTodo(){
        Archivo archivo=new Archivo("amigos.txt");
        return archivo.borrarContenido();                
    }
    
}

