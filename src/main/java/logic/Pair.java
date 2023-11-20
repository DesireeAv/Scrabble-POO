/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;

/**
 *
 * @author klob
 */
public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    
    public Pair(Pair<A,B> copia){
        this.first = copia.getFirst();
        this.second = copia.getSecond();
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
    
//    Metodo que verifica si es elemento de una lista
    public boolean elementoDe(List <Pair<A,B>> lista){
        for(int i=0; i<lista.size();i++){
            if(lista.get(i).getFirst() == first  && lista.get(i).getSecond() == second)
                return true;
        }
        return false;
    }
}