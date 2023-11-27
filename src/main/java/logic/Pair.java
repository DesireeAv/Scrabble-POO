/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;
import java.util.Objects;

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
    
    public void setFirst(A first){
        this.first = first;
    }

    public void setSecond(B second) {
        this.second = second;
    }
    
//    Metodo que verifica si es elemento de una lista
    public boolean elementoDe(List <Pair<A,B>> lista){
        for(int i=0; i<lista.size();i++){
            if(lista.get(i).equals(this)){
                return true;}
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair that = (Pair) obj;
        return first == that.first && second==that.second;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}