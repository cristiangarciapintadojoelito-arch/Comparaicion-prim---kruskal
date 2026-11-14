/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;

/**
 *
 * @author LENOVO
 */
public class Vertice {
    private int id;
    private double x;
    private double y;

    public Vertice(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double calcularDistancia(Vertice otro) {
        double dx = this.x - otro.x;
        double dy = this.y - otro.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Vertice " + id + " (" + x + ", " + y + ")";
    }
}


