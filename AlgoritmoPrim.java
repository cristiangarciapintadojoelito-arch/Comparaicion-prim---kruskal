/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;
import java.util.*;



/**
 *
 * @author LENOVO
 */
public class AlgoritmoPrim {
    public List<Arista> ejecutar(Grafos grafo) {

        List<Arista> resultado = new ArrayList<>();

        List<Vertice> vertices = grafo.getVertices();
        List<Arista> aristas = grafo.getAristas();

        if (vertices.isEmpty()) {
            return resultado;
        }

        // Crear lista de adyacencia
        Map<Vertice, List<Arista>> adyacencias = new HashMap<>();

        for (Vertice v : vertices) {
            adyacencias.put(v, new ArrayList<>());
        }

        for (Arista a : aristas) {
            adyacencias.get(a.getOrigen()).add(a);
            adyacencias.get(a.getDestino()).add(a);
        }

        // Ordenar las aristas por peso
        PriorityQueue<Arista> cola = new PriorityQueue<>(
                Comparator.comparingDouble(Arista::getPeso)
        );

        Set<Vertice> visitados = new HashSet<>();

        // Comenzar desde el primer vertice
        Vertice inicio = vertices.get(0);
        visitados.add(inicio);

        cola.addAll(adyacencias.get(inicio));

        while (!cola.isEmpty() && resultado.size() < vertices.size() - 1) {

            Arista actual = cola.poll();

            Vertice origen = actual.getOrigen();
            Vertice destino = actual.getDestino();

            boolean origenVisitado = visitados.contains(origen);
            boolean destinoVisitado = visitados.contains(destino);

            if (origenVisitado && destinoVisitado) {
                continue;
            }

            resultado.add(actual);

            Vertice nuevo = origenVisitado ? destino : origen;

            visitados.add(nuevo);

            for (Arista a : adyacencias.get(nuevo)) {

                Vertice vecino = a.getOrigen().equals(nuevo)
                        ? a.getDestino()
                        : a.getOrigen();

                if (!visitados.contains(vecino)) {
                    cola.add(a);
                }
            }
        }

        if (resultado.size() != vertices.size() - 1) {
            throw new IllegalStateException("El grafo no es conexo");
        }

        return resultado;
    }
}


