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
    
    //Contructor, recibe la letra y los puntos que vale esa letra
    public Ficha(int punt, String letr){
        setPuntos(punt);
        setLetra(letr);
        colocada = false;
        setColor(new Color(210, 247, 197));
    }
    
    //Contructor, recibe una ficha, usado para crear copias
    public Ficha(Ficha fich){
        setPuntos(fich.getPuntos());
        setLetra(fich.getLetra());
        colocada = fich.isColocada();
        setColor(fich.getColor());
    }
    
    //Constructor por defecto, no recibe nada
    public Ficha(){
        colocada = false;
        setPuntos(-1);
        setLetra("  ");
        setColor(new Color(15, 51, 39));
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


