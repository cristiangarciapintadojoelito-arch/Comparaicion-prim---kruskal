# Comparación experimental de algoritmos de expansión mínima

## Descripción
Este repositorio contiene el código fuente y los datos experimentales utilizados en la investigación sobre la comparación de los algoritmos de Prim y Kruskal para resolver el problema del árbol de expansión mínima en grafos no dirigidos y ponderados.

## Tecnologías utilizadas
- Lenguaje: Java.
- JDK: 21.0.10.
- Entorno de desarrollo: Apache NetBeans 19.
- Sistema operativo: Windows 11.

## Hardware
- Equipo: Lenovo, modelo 82R4.
- Procesador: AMD Ryzen 7 5700U with Radeon Graphics.
- Memoria RAM: 16 GB.

## Configuración experimental
Se utilizaron grafos sintéticos con las siguientes configuraciones:
- 100 vértices, densidades de 0.05 y 0.50.
- 500 vértices, densidades de 0.05 y 0.50.
- 1000 vértices, densidades de 0.05 y 0.50.

La generación de los grafos utilizó la semilla aleatoria 12345.

## Protocolo de medición
- Tres ejecuciones previas de calentamiento por algoritmo.
- Diez mediciones por algoritmo para cada configuración.
- Medición mediante System.nanoTime().
- Conversión de los tiempos a milisegundos.
- Cálculo de la mediana de las mediciones.

## Algoritmos implementados
- Algoritmo de Prim.
- Algoritmo de Kruskal.
- Estructura Union-Find para Kruskal.
- Generador de grafos aleatorios.

## Disponibilidad
En este repositorio se publicarán los códigos fuente Java y los datos obtenidos durante las pruebas experimentales.
