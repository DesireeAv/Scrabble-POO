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
        llenarColores();
    }
    
    public FichasTablero(FichasTablero copia){
        for(List<Ficha> fila : copia.getMatrizFichas()){
            matrizFichas.add(new LinkedList<>());
            for(Ficha ficha : fila){
                matrizFichas.get(matrizFichas.size()-1).add(new Ficha(ficha));
            }
        }
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
    
    
    public boolean equals(FichasTablero obj) {
        if (this == obj)
            return true;
        for(int i = 0; i < 15; i++){
            for(int j=0 ; j < 15; j++){
                if(!getFicha(i,j).getLetra().equals(obj.getFicha(i, j).getLetra()))return false;
            }
        }
            
        return true;
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
        matrizFichas.get(i).set(j, fich);
        return true;
    }
    
    public boolean posicionLegal(Trie trie){
        String palabraVertical = "";
        String palabraHorizontal = "";
        for(int i = 0; i<matrizFichas.size() ; i++){
            for(int j = 0; j<matrizFichas.get(0).size(); j++){
                String letraVertical = matrizFichas.get(j).get(i).getLetra();
                String letraHorizontal = matrizFichas.get(i).get(j).getLetra();
                if(letraVertical.length()>1)letraVertical = "  ";
                if(letraHorizontal.length()>1)letraHorizontal = "  ";
//                System.out.println("VERT "+ letraVertical);
//                System.out.println("HORZ "+ letraHorizontal);
                if(letraVertical.equals("  ")){
                    if(!palabraVertical.equals("")){
                        if(palabraVertical.length()>1){
                        System.out.println(palabraVertical);
                        if(!trie.search(palabraVertical)) return false;}
                        palabraVertical = "";
                    }
                }
                else
                    palabraVertical+=letraVertical;
                if(letraHorizontal.equals("  ")){
                    if(!palabraHorizontal.equals("")){
//                        System.out.println(palabraHorizontal);
                        if(palabraHorizontal.length()>1){
                        if(!trie.search(palabraHorizontal)) return false;}
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
        return esConexo();
    }
  
    private int cantFichas(){
        int cant = 0;
        for(int i = 0 ; i<15; i++){
            for(int j = 0 ; j<15 ; j++){
                if(matrizFichas.get(i).get(j).isColocada()) cant++;
            }
        }
        return cant;
    }
    private boolean esValido(int i, int j){
        return (i<15 && i>-1 && j<15 && j>-1);
    }
    
    private boolean esConexo(){
//        System.out.println("Es conexo funcion");
        int contador = 0;
        int cantFichas = cantFichas();
//        System.out.println(cantFichas);
        int[][] matVisitados = new int[15][15];
        int[][] posiciones = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        Pair<Integer, Integer> par = new Pair(7,7);
        if(!getFichaPar(par).isColocada())return true;
        List <Pair<Integer, Integer>> bfs = new LinkedList<>();
        bfs.add(par);
        while(!bfs.isEmpty()){
            int i  = bfs.get(bfs.size() -1).getFirst();
            int j = bfs.get(bfs.size() -1).getSecond();
//            System.out.println(i + " , " + j);
            contador++;
            matVisitados[i][j] = 1;
            for(int [] p : posiciones){
                if(esValido(i+p[0], j+p[1]) && !(matVisitados[i+p[0]][j+p[1]]==1) && matrizFichas.get(i+p[0]).get(j+p[1]).isColocada()){
                    bfs.add(0, new Pair(i+p[0], j+p[1]));
                }
            }
            bfs.remove(bfs.size()-1);
        }
        return contador == cantFichas;
    }
    
    private void llenarParesRojos() {
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
    
    private void llenarParesCelestes() {
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
        listaCeleste.add(new Pair<>(11, 0));
        listaCeleste.add(new Pair<>(11, 7));
        listaCeleste.add(new Pair<>(11, 14));
        listaCeleste.add(new Pair<>(12, 6));
        listaCeleste.add(new Pair<>(12, 8));
        listaCeleste.add(new Pair<>(14, 3));
        listaCeleste.add(new Pair<>(14, 11));
        listaCeleste.add(new Pair<>(8, 2));
        listaCeleste.add(new Pair<>(8, 6));
        listaCeleste.add(new Pair<>(8, 8));
        listaCeleste.add(new Pair<>(8, 12));
        
    }
    
    private void llenarParesAzules() {
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
     
    private void llenarParesNaranja() {
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
        listaNaranja.add(new Pair<>(11, 11));
        listaNaranja.add(new Pair<>(13, 1));
        listaNaranja.add(new Pair<>(12, 2));
        listaNaranja.add(new Pair<>(11, 3));
        listaNaranja.add(new Pair<>(10, 4));
    }
    
    private void llenarColores(){
        llenarParesAzules();
        llenarParesCelestes();
        llenarParesNaranja();
        llenarParesRojos();
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
    
    
    
    public void pintarVerdes(){
        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){
                getFicha(i, j).setColor(new Color(15, 51,39));
                getFicha(i, j).setLetra("  ");
              }
          }     
    }
    
    public void pintarRojas(){
        for(Pair<Integer, Integer> par : listaRojo ){
            getFicha(par.getFirst(),par.getSecond()).setColor(new Color(225, 43, 40));
            getFicha(par.getFirst(),par.getSecond()).setLetra("3P");
        }
    }
    public void pintarCelestes(){
        for(Pair<Integer, Integer> par : listaCeleste ){
            getFicha(par.getFirst(),par.getSecond()).setColor(new Color(44, 206, 180));
            getFicha(par.getFirst(),par.getSecond()).setLetra("2L");
        }
    }
    public void pintarAzules(){
        for(Pair<Integer, Integer> par : listaAzul){
            getFicha(par.getFirst(),par.getSecond()).setColor(new Color(40, 100, 225));
            getFicha(par.getFirst(),par.getSecond()).setLetra("3L");
        }
    }
    public void pintarNaranja(){
        for(Pair<Integer, Integer> par : listaNaranja ){
            getFicha(par.getFirst(),par.getSecond()).setColor(new Color(226, 160, 36));
            getFicha(par.getFirst(),par.getSecond()).setLetra("2P");
        }
    }
    public void llenarCuadros(){
        pintarVerdes();
        pintarRojas();
        pintarCelestes();
        pintarAzules();
        pintarNaranja();
//        getFicha(10,10).setColor(Color.red);
    }
}
