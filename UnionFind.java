/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EXPERIMENTOS;

/**
 *
 * @author LENOVO
 */
public class UnionFind {
    private int[] padre;
    private int[] rango;

    public UnionFind(int cantidad) {

        padre = new int[cantidad];
        rango = new int[cantidad];

        // Cada vertice comienza en su propio conjunto
        for (int i = 0; i < cantidad; i++) {
            padre[i] = i;
            rango[i] = 0;
        }
    }

    // Buscar el representante del conjunto
    public int find(int x) {

        if (padre[x] != x) {
            padre[x] = find(padre[x]);
        }

        return padre[x];
    }

    // Unir dos conjuntos
    public boolean union(int x, int y) {

        int raizX = find(x);
        int raizY = find(y);

        // Si tienen la misma raiz, forman un ciclo
        if (raizX == raizY) {
            return false;
        }

        // Union por rango
        if (rango[raizX] < rango[raizY]) {

            padre[raizX] = raizY;

        } else if (rango[raizX] > rango[raizY]) {

            padre[raizY] = raizX;

        } else {

            padre[raizY] = raizX;
            rango[raizX]++;
        }

        return true;
    }
}


