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
public class FichasTablero {
    private List <List<Ficha>> matrizFichas = new LinkedList<>();
    
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
    
}
