/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Grafos {
    private List<Vertice> vertices;
    private List<Arista> aristas;
public Grafos(){
     vertices = new ArrayList<>();
        aristas = new ArrayList<>();
}
    public void agregarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void agregarArista(Vertice origen, Vertice destino) {
        Arista arista = new Arista(origen, destino);
        aristas.add(arista);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public void mostrarGrafo() {
        System.out.println("VERTICES:");

        for (Vertice v : vertices) {
            System.out.println(v);
        }

        System.out.println("\nARISTAS:");

        for (Arista a : aristas) {
            System.out.println(a);
        }
    }
}


