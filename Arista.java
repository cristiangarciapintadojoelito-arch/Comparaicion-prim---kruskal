/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;

/**
 *
 * @author LENOVO
 */
public class Arista {
    private Vertice origen;
    private Vertice destino;
    private double peso;

    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
        this.peso = origen.calcularDistancia(destino);
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return origen.getId() + " - " + destino.getId()
                + " | Peso: " + peso;
    }
}


