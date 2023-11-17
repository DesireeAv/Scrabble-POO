/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author klob
 */
public class BolsaFichas {
    private List <Ficha> listaFichas = new LinkedList<>();
    private List <Integer> ordenSalida = new LinkedList<>();
    
    
    public BolsaFichas(){
        llenarBolsa();
        cargarOrdenRandom();
    }
 
//Metodo que crea un arreglo con enteros ordenados de forma aleatoria, posteriormente utilizados como index
    private void cargarOrdenRandom(){
        ordenSalida.clear();
        for (int i=0;i<listaFichas.size() ;i++){
            ordenSalida.add(i);
        }
        Collections.shuffle(ordenSalida);
    }
//    Metodo que retorna una Ficha retirada de la bolsa
    public Ficha sacarFicha(){
        if(ordenSalida.isEmpty()) return null;
        Ficha fich = listaFichas.get(ordenSalida.get(0)); //se toma del primer valor del arreglo random
        ordenSalida.remove(0); // se elimina este valor para no repetir index
        return fich;
    }
    
    public void insertarFicha(Ficha fich){
        listaFichas.add(fich);
        cargarOrdenRandom();
    }
    
    //    Metodo que indica si la bolsa se encuentra vacia
    public boolean isEmpty(){
        return ordenSalida.isEmpty();
    }
    
    // Para verificar si hay un string en un arreglo de strings
    private boolean contiene(String str, String[] lista) {
        for (String elemento : lista) {
            if (elemento.equals(str)) {
                return true;
            }
        }
        return false;
    }
    
    public int getLetterValue(String letter){
        String fichasUnPunto[] = {"A", "E", "O", "I", "S", "N", "L", "R", "U", "T"};
        String fichasDosPunto[] = {"D", "G"};
        String fichasTresPunto[] = {"C", "B", "M", "P"};
        String fichasCuatroPunto[] = {"H", "F", "V", "Y"};
        String fichasCincoPunto[] = {"Q"};
        String fichasOchoPunto[] = {"J", "K", "Ñ", "W", "X"};
        String fichasDiezPunto[] = {"Z"};
        
        // Verificar en qué lista se encuentra la letra y devolver el valor correspondiente
        if (contiene(letter, fichasUnPunto)) 
            return 1;
        if (contiene(letter, fichasDosPunto)) 
            return 2;
        if (contiene(letter, fichasTresPunto)) 
            return 3;
        if (contiene(letter, fichasCuatroPunto)) 
            return 4;
        if (contiene(letter, fichasCincoPunto)) 
            return 5;
        if (contiene(letter, fichasOchoPunto)) 
            return 8;
        if (contiene(letter, fichasDiezPunto)) 
            return 10;
        // Si la letra no está en ninguna lista
        return 0;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Metodo que agrega (carga) todas las fichas necesarias para el juego
    public void llenarBolsa(){
        for(int i = 0;i<12; i++){
            listaFichas.add(new Ficha(getLetterValue("A"), "A"));
            listaFichas.add(new Ficha(getLetterValue("E"), "E"));
        }
        for(int i=0; i<9; i++){
            listaFichas.add(new Ficha(getLetterValue("O"), "O"));
        }
        for(int i = 0;i<6; i++){
            listaFichas.add(new Ficha(getLetterValue("I"), "I"));
            listaFichas.add(new Ficha(getLetterValue("S"), "S"));
        }
        for(int i=0; i<5; i++){
            listaFichas.add(new Ficha(getLetterValue("N"), "N"));
            listaFichas.add(new Ficha(getLetterValue("R"), "R"));
            listaFichas.add(new Ficha(getLetterValue("U"), "U"));
            listaFichas.add(new Ficha(getLetterValue("D"), "D"));
        }
        for(int i=0; i<4; i++){
            listaFichas.add(new Ficha(getLetterValue("L"), "L"));
            listaFichas.add(new Ficha(getLetterValue("T"), "T"));
            listaFichas.add(new Ficha(getLetterValue("C"), "C"));
        }
        for(int i=0; i<2; i++){
            listaFichas.add(new Ficha(getLetterValue(" "), " "));
            listaFichas.add(new Ficha(getLetterValue("G"), "G"));
            listaFichas.add(new Ficha(getLetterValue("B"), "B"));
            listaFichas.add(new Ficha(getLetterValue("M"), "M"));
            listaFichas.add(new Ficha(getLetterValue("P"), "P"));
            listaFichas.add(new Ficha(getLetterValue("H"), "H"));
            listaFichas.add(new Ficha(getLetterValue("Q"), "Q"));
        }
        listaFichas.add(new Ficha(getLetterValue("F"), "F"));
        listaFichas.add(new Ficha(getLetterValue("V"), "V"));
        listaFichas.add(new Ficha(getLetterValue("Y"), "Y"));
        listaFichas.add(new Ficha(getLetterValue("M"), "M"));
        listaFichas.add(new Ficha(getLetterValue("J"), "J"));
        listaFichas.add(new Ficha(getLetterValue("K"), "K"));
        listaFichas.add(new Ficha(getLetterValue("Ñ"), "Ñ"));
        listaFichas.add(new Ficha(getLetterValue("X"), "X"));
        listaFichas.add(new Ficha(getLetterValue("W"), "W"));
        listaFichas.add(new Ficha(getLetterValue("Z"), "Z"));
    }
}



