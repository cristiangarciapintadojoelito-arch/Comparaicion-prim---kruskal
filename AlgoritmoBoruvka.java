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
public class AlgoritmoBoruvka {
    public List<Arista> ejecutar(Grafos grafo) {

        List<Arista> resultado = new ArrayList<>();

        int cantidadVertices = grafo.getVertices().size();

        if (cantidadVertices == 0) {
            return resultado;
        }

        UnionFind unionFind = new UnionFind(cantidadVertices);

        int componentes = cantidadVertices;

        while (componentes > 1) {

            Arista[] mejorArista = new Arista[cantidadVertices];

            for (Arista arista : grafo.getAristas()) {

                int origen = arista.getOrigen().getId() - 1;
                int destino = arista.getDestino().getId() - 1;

                int raizOrigen = unionFind.find(origen);
                int raizDestino = unionFind.find(destino);

                if (raizOrigen == raizDestino) {
                    continue;
                }

                if (mejorArista[raizOrigen] == null
                        || arista.getPeso()
                        < mejorArista[raizOrigen].getPeso()) {
                    mejorArista[raizOrigen] = arista;
                }

                if (mejorArista[raizDestino] == null
                        || arista.getPeso()
                        < mejorArista[raizDestino].getPeso()) {
                    mejorArista[raizDestino] = arista;
                }
            }

            int uniones = 0;

            for (Arista arista : mejorArista) {

                if (arista == null) {
                    continue;
                }

                int origen = arista.getOrigen().getId() - 1;
                int destino = arista.getDestino().getId() - 1;

                if (unionFind.union(origen, destino)) {
                    resultado.add(arista);
                    componentes--;
                    uniones++;
                }
            }

            if (uniones == 0) {
                throw new IllegalStateException("El grafo no es conexo");
            }
        }

        return resultado;
    }
}
