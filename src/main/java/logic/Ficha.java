/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;
import java.awt.Color;
/**
 *
 * @author klob
 */
public class Ficha {
    private int puntos;
    private String letra;
    private boolean colocada;
    private Color color;
    
    
    public Ficha(int punt, String letr){
        setPuntos(punt);
        setLetra(letr);
        colocada = false;
        setColor(new Color(12, 12, 12));
    }
    
    public Ficha(Ficha fich){
        setPuntos(fich.getPuntos());
        setLetra(fich.getLetra());
        colocada = false;
        setColor(new Color(12, 12, 12));
    }
    
    public Ficha(){
        setPuntos(-1);
        setLetra("  ");
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    
    
}


