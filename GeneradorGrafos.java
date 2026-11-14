/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author LENOVO
 */
public class GeneradorGrafos {
    public Grafos generar(int cantidadVertices, double densidad, long semilla) {

        if (cantidadVertices < 1 || densidad < 0 || densidad > 1) {
            throw new IllegalArgumentException("Parametros invalidos");
        }

        Grafos grafo = new Grafos();
        Random random = new Random(semilla);

        List<Vertice> vertices = new ArrayList<>();

        boolean[][] existe = new boolean[cantidadVertices][cantidadVertices];

        // 1. Crear los vertices con coordenadas aleatorias
        for (int i = 0; i < cantidadVertices; i++) {

            Vertice vertice = new Vertice(
                    i + 1,
                    random.nextDouble() * 100,
                    random.nextDouble() * 100
            );

            vertices.add(vertice);
            grafo.agregarVertice(vertice);
        }

        // 2. Conectar los vertices para garantizar conectividad
        for (int i = 1; i < cantidadVertices; i++) {

            int anterior = random.nextInt(i);

            grafo.agregarArista(vertices.get(i), vertices.get(anterior));

            existe[i][anterior] = true;
            existe[anterior][i] = true;
        }

        // 3. Calcular la cantidad de aristas deseadas
        int maxAristas = cantidadVertices * (cantidadVertices - 1) / 2;

        int cantidadAristas = (int) Math.round(densidad * maxAristas);

        cantidadAristas = Math.max(cantidadAristas, cantidadVertices - 1);

        // 4. Agregar conexiones adicionales
        int actuales = cantidadVertices - 1;

        while (actuales < cantidadAristas) {

            int i = random.nextInt(cantidadVertices);
            int j = random.nextInt(cantidadVertices);

            if (i != j && !existe[i][j]) {

                grafo.agregarArista(vertices.get(i), vertices.get(j));

                existe[i][j] = true;
                existe[j][i] = true;

                actuales++;
            }
        }

        return grafo;
    }
}


