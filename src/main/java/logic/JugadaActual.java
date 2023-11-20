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
public class JugadaActual {
    private List <Pair<Integer, Integer>> posicionesNuevas = new LinkedList<>();
    private boolean valida;
    private boolean vertical;
    

    public boolean agregarPosicion(Pair<Integer, Integer> par){
        if(posicionesNuevas.isEmpty()){
            posicionesNuevas.add(par); return true;
        }
        if(posicionesNuevas.size()==1){
            if(posicionesNuevas.get(0).getFirst()==par.getFirst()){
                vertical = false;
            }
            else if(posicionesNuevas.get(0).getSecond()==par.getSecond()){
                vertical = true;
            }
            else 
                return false;
        }
        if(vertical && !(posicionesNuevas.get(0).getSecond() == par.getSecond())) return false;
        if(!vertical && !(posicionesNuevas.get(0).getFirst()== par.getFirst())) return false;
        for(int i=0 ; i<posicionesNuevas.size(); i++){
            if(vertical &&posicionesNuevas.get(i).getFirst() > par.getFirst()){
                posicionesNuevas.add(i, par);
                return true;
            }
            else if(!vertical && posicionesNuevas.get(i).getSecond()> par.getSecond()){
                posicionesNuevas.add(i, par);
                return true;
            }
        }
        return false;
    }
    
    public int puntosJugada(FichasTablero table){
        if(posicionesNuevas.size() == 1){
            
        }
        
        return 0;
    }
    
}
