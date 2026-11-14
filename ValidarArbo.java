/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ValidarArbo {
     public boolean validar(Grafos grafo, List<Arista> resultado) {

        int cantidadVertices = grafo.getVertices().size();

        // Comprobar la cantidad de aristas
        if (resultado.size() != cantidadVertices - 1) {
            return false;
        }

        // Crear UnionFind para verificar ciclos y conectividad
        UnionFind unionFind = new UnionFind(cantidadVertices);

        // Revisar cada arista del resultado
        for (Arista arista : resultado) {

            int origen = arista.getOrigen().getId() - 1;
            int destino = arista.getDestino().getId() - 1;

            // Si no se pueden unir, existe un ciclo
            if (!unionFind.union(origen, destino)) {
                return false;
            }
        }

        // Comprobar que todos los vertices pertenezcan
        // al mismo conjunto
        int representante = unionFind.find(0);

        for (int i = 1; i < cantidadVertices; i++) {

            if (unionFind.find(i) != representante) {
                return false;
            }
        }

        return true;
    }
}
