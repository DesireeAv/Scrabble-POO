/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author klob
 */
public class FichasTablero {
    private List <List<Ficha>> matrizFichas = new LinkedList<>();
    private List <Pair<Integer, Integer>> listaRojo = new LinkedList<>();
    private List <Pair<Integer, Integer>> listaCeleste = new LinkedList<>();
    private List <Pair<Integer, Integer>> listaAzul = new LinkedList<>();
    private List <Pair<Integer, Integer>> listaNaranja = new LinkedList<>();
    
    
    public FichasTablero(){
        llenarMatriz();
   }
    
    public void llenarMatriz(){
        for(int i = 0 ; i<15 ; i++){
            List<Ficha> fila = new LinkedList<>();
            for(int j = 0; j<15 ; j++){
                fila.add(new Ficha());
            }
            matrizFichas.add(fila);
        }
    }
    


    
    public Ficha getFicha(int i, int j){
        return matrizFichas.get(i).get(j);
    }
    
    public Ficha getFichaPar(Pair<Integer, Integer> par){
        return matrizFichas.get(par.getFirst()).get(par.getSecond());
    }
    
    public boolean colocarFicha(Ficha fich, int i, int j){
        if(matrizFichas.get(i).get(j).isColocada()) return false;
        fich.setColocada(true);
        matrizFichas.get(i).remove(j);
        matrizFichas.get(i).add(j, fich);
        return true;
    }
    
    public boolean posicionLegal(Trie trie){
        String palabraVertical = "";
        String palabraHorizontal = "";
        for(int i = 0; i<matrizFichas.size() ; i++){
            for(int j = 0; j<matrizFichas.get(0).size(); i++){
                String letraVertical = matrizFichas.get(i).get(j).getLetra();
                String letraHorizontal = matrizFichas.get(j).get(i).getLetra();
                if(letraVertical.equals("  ")){
                    if(!palabraVertical.equals("")){
                        if(!trie.search(palabraVertical)) return false;
                        palabraVertical = "";
                    }
                }
                else
                    palabraVertical+=letraVertical;
                if(!letraHorizontal.equals("  ")){
                    if(!palabraHorizontal.equals("")){
                        if(!trie.search(palabraHorizontal)) return false;
                        palabraHorizontal = "";
                    }
                }
                else
                    palabraHorizontal+=letraHorizontal;
                if(j==14){
                    if(!palabraHorizontal.equals("")){
                        if(!trie.search(palabraHorizontal)) return false;
                        palabraHorizontal = "";
                    }
                    if(!palabraVertical.equals("")){
                        if(!trie.search(palabraVertical)) return false;
                        palabraVertical = "";
                    }
                }
            }
        }
        return true;
    }
    
    
    
    
        public void llenarParesRojos() {
        // Agregar los pares ordenados a la lista
        listaRojo.add(new Pair<>(0, 0));
        listaRojo.add(new Pair<>(0, 7));
        listaRojo.add(new Pair<>(0, 14));
        listaRojo.add(new Pair<>(7, 0));
        listaRojo.add(new Pair<>(7, 14));
        listaRojo.add(new Pair<>(14, 0));
        listaRojo.add(new Pair<>(14, 7));
        listaRojo.add(new Pair<>(14, 14));
    }
    
    public void llenarParesCelestes() {
        // Agregar los pares ordenados a la lista celeste
        listaCeleste.add(new Pair<>(0, 3));
        listaCeleste.add(new Pair<>(0, 11));
        listaCeleste.add(new Pair<>(2, 6));
        listaCeleste.add(new Pair<>(2, 8));
        listaCeleste.add(new Pair<>(3, 0));
        listaCeleste.add(new Pair<>(3, 7));
        listaCeleste.add(new Pair<>(3, 14));
        listaCeleste.add(new Pair<>(6, 2));
        listaCeleste.add(new Pair<>(6, 6));
        listaCeleste.add(new Pair<>(6, 8));
        listaCeleste.add(new Pair<>(6, 12));
        listaCeleste.add(new Pair<>(7, 3));
        listaCeleste.add(new Pair<>(7, 11));
        listaCeleste.add(new Pair<>(12, 0));
        listaCeleste.add(new Pair<>(12, 7));
        listaCeleste.add(new Pair<>(12, 14));
        listaCeleste.add(new Pair<>(13, 6));
        listaCeleste.add(new Pair<>(13, 8));
        listaCeleste.add(new Pair<>(14, 3));
        listaCeleste.add(new Pair<>(14, 12));
    }
    
     public void llenarParesAzules() {
        // Agregar los pares ordenados a la lista azul
        listaAzul.add(new Pair<>(1, 5));
        listaAzul.add(new Pair<>(1, 9));
        listaAzul.add(new Pair<>(5, 1));
        listaAzul.add(new Pair<>(5, 5));
        listaAzul.add(new Pair<>(5, 9));
        listaAzul.add(new Pair<>(5, 13));
        listaAzul.add(new Pair<>(9, 1));
        listaAzul.add(new Pair<>(9, 5));
        listaAzul.add(new Pair<>(9, 9));
        listaAzul.add(new Pair<>(9, 13));
        listaAzul.add(new Pair<>(13, 5));
        listaAzul.add(new Pair<>(13, 9));
    } 
     
    public void llenarParesNaranja() {
        // Agregar los pares ordenados a la lista naranja
        listaNaranja.add(new Pair<>(1, 1));
        listaNaranja.add(new Pair<>(1, 13));
        listaNaranja.add(new Pair<>(2, 2));
        listaNaranja.add(new Pair<>(2, 12));
        listaNaranja.add(new Pair<>(3, 3));
        listaNaranja.add(new Pair<>(3, 11));
        listaNaranja.add(new Pair<>(4, 4));
        listaNaranja.add(new Pair<>(4, 10));
        listaNaranja.add(new Pair<>(7, 7));
        listaNaranja.add(new Pair<>(10, 10));
        listaNaranja.add(new Pair<>(12, 12));
        listaNaranja.add(new Pair<>(13, 13));
        listaNaranja.add(new Pair<>(14, 14));
        listaNaranja.add(new Pair<>(14, 1));
        listaNaranja.add(new Pair<>(13, 2));
        listaNaranja.add(new Pair<>(12, 3));
        listaNaranja.add(new Pair<>(11, 4));
    }

    public List<List<Ficha>> getMatrizFichas() {
        return matrizFichas;
    }

    public List<Pair<Integer, Integer>> getListaRojo() {
        return listaRojo;
    }

    public List<Pair<Integer, Integer>> getListaCeleste() {
        return listaCeleste;
    }

    public List<Pair<Integer, Integer>> getListaAzul() {
        return listaAzul;
    }

    public List<Pair<Integer, Integer>> getListaNaranja() {
        return listaNaranja;
    }
    private FichasTablero fichasMesa = new FichasTablero();
    
    
    public void pintarVerdes(){
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                fichasMesa.getFicha(i, j).setColor(Color.green);
                fichasMesa.getFicha(i, j).setLetra("  ");
              }
          }     
    }
    
    public void pintarRojas(){
        for(Pair<Integer, Integer> par : listaRojo ){
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setColor(Color.red);
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setLetra("3P");
        }
    }
    public void pintarCelestes(){
        for(Pair<Integer, Integer> par : listaCeleste ){
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setColor(Color.white);
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setLetra("2L");
        }
    }
    public void pintarAzules(){
        for(Pair<Integer, Integer> par : listaAzul){
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setColor(Color.blue);
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setLetra("3L");
        }
    }
    public void pintarNaranja(){
        for(Pair<Integer, Integer> par : listaNaranja ){
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setColor(Color.orange);
            fichasMesa.getFicha(par.getFirst(),par.getSecond()).setLetra("2P");
        }
    }
    public void pintarTodo(){
        pintarVerdes();
        pintarRojas();
        pintarCelestes();
        pintarAzules();
        pintarNaranja();
    }
}
