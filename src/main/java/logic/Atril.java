/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author klob
 */
public class Atril {
    private List <Ficha> listaFichas = new LinkedList<>();
    //Constructor por defecto, no recibe nada
    public Atril(){
        llenarDeFichas();
    }
    
    //Constructor, recibe un atril, usado para hacer copias
    public Atril(Atril copia){
        for(Ficha ficha : copia.getListaFichas()){
            listaFichas.add(new Ficha(ficha));
        }
    }
            
//        Metodo para llenar el atril mientras la bolsa no esté vacía 
    public boolean llenarAtril(BolsaFichas bolsa){
        if(isEmpty() && bolsa.isEmpty()) return false;
        while(agregarFicha(bolsa.sacarFicha()));
        return true;
    }

    public List<Ficha> getListaFichas() {
        return listaFichas;
    }
    
    
    //Metodo para saber si el atril esta vacio
    public boolean isEmpty(){
        for(int i = 0; i<7 ; i++){
            if(!listaFichas.get(i).getLetra().equals("  "))
                return false;
        }
        return true;
    }
    
    
    //Metodo que devuelve la ficha que esta en el indice que recibe la funcion
    public Ficha getFicha(int index){
        if(index < 0 || index > 6 )return null;
        return listaFichas.get(index);
    }
    
    
    //Metodo para agregar Ficha al atril
    public boolean agregarFicha(Ficha fich){
        if(fich == null) return false;
        for(int i=0; i<7 ; i++){
            if(listaFichas.get(i).getLetra().equals("  ")){
                listaFichas.remove(i);
                listaFichas.add(i, fich);
                return true;
            }
        }
        return false;
    }
    
    //Metodo para quitar y devolver la ficha del atril que esta en el indice que recibe,
    public Ficha sacarFicha(int index){
        if(listaFichas.get(index).getLetra().equals("  "))return null;
        Ficha res = new Ficha(listaFichas.get(index));
        listaFichas.set(index, new Ficha());
        return res;
    }
    
    // Metodo para cambiar las fichas del atril con una aleatoria de la bolsa
    public int cambiarFicha(int indice, BolsaFichas bolsa){
        if(bolsa.isEmpty()){
            return 0; // bolsa vacia
        }
        if(listaFichas.get(indice).getLetra().equals("  ")) return 1; // No hay ficha
        Ficha fichaNueva = bolsa.sacarFicha();
        bolsa.insertarFicha(new Ficha(listaFichas.get(indice)));
        listaFichas.remove(indice);
        listaFichas.add(indice, fichaNueva);
        return 2; // Ficha cambiada con exito
    }
    
    //Metdo para llenar un atril
    private void llenarDeFichas(){
        for(int i = 0 ; i < 7 ; i++){
            listaFichas.add(new Ficha());
        }
    }
}