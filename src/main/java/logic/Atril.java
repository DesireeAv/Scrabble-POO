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


//        Metodo para llenar el atril mientras la bolsa no esté vacía 
    public boolean llenarAtril(BolsaFichas bolsa){
        if(isEmpty() && bolsa.isEmpty()) return false;
        while(agregarFicha(bolsa.sacarFicha()));
        return true;
    }
    
    public boolean isEmpty(){
        for(int i = 0; i<7 ; i++){
            if(!listaFichas.get(i).getLetra().equals("  "))
                return false;
        }
        return true;
    }
    
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
}