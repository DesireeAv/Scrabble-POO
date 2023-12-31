/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author klob
 */
public class JugadaActual {
    private List <Pair<Integer, Integer>> posicionesNuevas = new LinkedList<>();
    private boolean vertical;
    private Set<Pair<Integer, Integer>> inicioVertical = new HashSet<>();
    private Set<Pair<Integer, Integer>> inicioHorizontal = new HashSet<>();
    

    
    //Añade una posicion de acuerdo al tipo de jugada que se esta realizando, si la jugada llega a ser ilegal retorna falso
    public boolean agregarPosicion(Pair<Integer, Integer> par){
        if(posicionesNuevas.isEmpty()){
            posicionesNuevas.add(par); return true;
        }
        if(posicionesNuevas.size()==1){
            if(posicionesNuevas.get(0).getFirst() == par.getFirst()){
                vertical = false;
            }
            else if(posicionesNuevas.get(0).getSecond() == par.getSecond()){
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
        posicionesNuevas.add(par);
        return true;
    }
    
    
    
    //Metodo que regresa el par ordenado de las coordenadas donde inicia la palabra
    private Pair<Integer, Integer> inicioPalabra(FichasTablero table, boolean vertical, Pair<Integer, Integer>  par){
        Pair<Integer, Integer> res = new Pair(par);
        if(vertical){
            while(table.getFichaPar(par).isColocada() &&  -1 < par.getFirst()){
                res = new Pair(par);
                par.setFirst(par.getFirst()-1);
            }
            return res;
        }
        while(table.getFichaPar(par).isColocada() && -1 < par.getSecond()){
            res = new Pair(par);
            par.setSecond(par.getSecond()-1);
        }
        return res;
    }
    
    
    //Metodo que devuelve los puntos totales de una palabra
    private int puntosPalabra(FichasTablero table, boolean vertical, Pair<Integer, Integer> inicio){
        int total = 0;
        int duplic = 0;
        int triplic = 0;
        
        if(vertical){
            while(inicio.getFirst()< 15 && table.getFichaPar(inicio).isColocada()){
                int valorLetra = table.getFichaPar(inicio).getPuntos();
                if(inicio.elementoDe(table.getListaAzul())){
                    valorLetra*=3; table.getListaAzul().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaCeleste())){
                    valorLetra*=2; table.getListaCeleste().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaNaranja())){
                    duplic++; table.getListaNaranja().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaRojo())){
                    triplic++; table.getListaRojo().remove(inicio);
                }
                total+=valorLetra;
                
                inicio.setFirst(inicio.getFirst()+1);
            }
        }
        
        else{
            while(inicio.getSecond()< 15 && table.getFichaPar(inicio).isColocada()){
                int valorLetra = table.getFichaPar(inicio).getPuntos();
                if(inicio.elementoDe(table.getListaAzul())){
                    valorLetra*=3; table.getListaAzul().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaCeleste())){
                    valorLetra*=2; table.getListaCeleste().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaNaranja())){
                    duplic++; table.getListaNaranja().remove(inicio);
                }
                else if(inicio.elementoDe(table.getListaRojo())){
                    triplic++; table.getListaRojo().remove(inicio);
                }
                total+=valorLetra;
                
                inicio.setSecond(inicio.getSecond()+1);
            }
        }
        while(triplic!=0){
            triplic--;
            total*=3;
        }
        while(duplic!=0){
            duplic--;
            total*=2;
        }
        
        return total;
    }
    
    
    //Metodo que devuelve verdadero si la ficha que se ingresa tiene otra ficha colocada a la izquierda o a la derecha
    private boolean buscarLados(Pair<Integer, Integer> par, FichasTablero table){
        int columnaAct = par.getSecond();
        if(columnaAct + 1 < 15 && table.getFicha(par.getFirst(), columnaAct + 1).isColocada()) return true;
        if(columnaAct - 1 > -1 && table.getFicha(par.getFirst(), columnaAct - 1).isColocada()) return true;
        return false;
    }
    
        //Metodo que devuelve verdadero si la ficha que se ingresa tiene otra ficha colocada arriba o abajo
    private boolean buscarArrAbaj(Pair<Integer, Integer> par, FichasTablero table){
        int filaAct = par.getFirst();
        if(filaAct + 1 < 15 && table.getFicha(filaAct + 1, par.getSecond()).isColocada()) return true;
        if(filaAct - 1 > -1 && table.getFicha(filaAct - 1, par.getSecond()).isColocada()) return true;
        return false;
    }
    
    
    
    
    //Metodo que devuelve el total de puntos de una jugada
    public int puntosJugada(FichasTablero table){
        int total = 0;
        for(Pair<Integer, Integer> pares : posicionesNuevas){
            if(buscarLados(pares, table)){
                inicioHorizontal.add(inicioPalabra(table, false, pares));
            }
            if(buscarArrAbaj(pares, table)){
                inicioVertical.add(inicioPalabra(table, true, pares));
            }
        }
        for(Pair<Integer, Integer> paresVert : inicioVertical){
            total += puntosPalabra(table, true, new Pair(paresVert));
        }
        
        for(Pair<Integer, Integer> paresHorz : inicioHorizontal){
            total += puntosPalabra(table, false, new Pair(paresHorz));
        }
        
        return total;
    }
    
}
