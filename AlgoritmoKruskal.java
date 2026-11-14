/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
/**
 *
 * @author LENOVO
 */
public class AlgoritmoKruskal {
    public List<Arista> ejecutar(Grafos grafo) {

        List<Arista> resultado = new ArrayList<>();

        // Obtener las aristas del grafo
        List<Arista> aristas = new ArrayList<>(grafo.getAristas());

        // Ordenar las aristas por peso
        aristas.sort(Comparator.comparingDouble(Arista::getPeso));

        // Crear UnionFind
        int cantidadVertices = grafo.getVertices().size();

        UnionFind unionFind = new UnionFind(cantidadVertices);

        // Revisar las aristas ordenadas
        for (Arista arista : aristas) {

            int origen = arista.getOrigen().getId() - 1;
            int destino = arista.getDestino().getId() - 1;

            // Intentar unir los dos vertices
            if (unionFind.union(origen, destino)) {

                resultado.add(arista);
            }

            // Detener cuando tengamos V - 1 aristas
            if (resultado.size() == cantidadVertices - 1) {
                break;
            }
        }

        if (resultado.size() != cantidadVertices - 1) {
            throw new IllegalStateException("El grafo no es conexo");
        }

        return resultado;
    }
}

