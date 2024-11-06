
package com.mycompany.grafodesdematriz;
import java.util.ArrayList;
import java.util.List;

//nodo
class Nodo {
    int valor;
    List<Nodo> nodosAdyacentes;
    public Nodo(int valor) {
        this.valor = valor;
        this.nodosAdyacentes = new ArrayList<>();}
    //añadir un nodos adyacente
    public void agregarAdyacente(Nodo nodo) {
        nodosAdyacentes.add(nodo);}}
//grafo
class Grafo {
    private final List<Nodo> nodos;
    public Grafo() {
        this.nodos = new ArrayList<>();}

    // dar un nodo al grafo
    public Nodo agregarNodo(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nodos.add(nuevoNodo);
        return nuevoNodo; }

    //conectar nodos
    public void agregarArista(Nodo nodo1, Nodo nodo2) {
        nodo1.agregarAdyacente(nodo2);
        nodo2.agregarAdyacente(nodo1);}

    public void imprimirGrafo() {
        for (Nodo nodo : nodos) {
            System.out.print("Nodo " + nodo.valor + ": ");
            for (Nodo adyacente : nodo.nodosAdyacentes) {
                System.out.print(adyacente.valor + " ");}
            System.out.println();}
    }
    public void bornfrommatrix(int[][] matrizAdyacencia) {
        Nodo[] nodosCreados = new Nodo[matrizAdyacencia.length];
        // nodos
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            nodosCreados[i] = agregarNodo(i);
        }
        // aristas
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = i + 1; j < matrizAdyacencia[i].length; j++) {
                if (matrizAdyacencia[i][j] == 1) {
                    agregarArista(nodosCreados[i], nodosCreados[j]);
                }
            }
        }
    }
}
public class GrafoMatrix {
    public static void main(String[] args) {
        int[][] matrizAdyacencia = {
            {0, 1, 0, 0, 1}, // 0 1 2 3 4
            {1, 0, 0, 0, 0}, // 1
            {0, 0, 0, 0, 0}, // 2
            {0, 0, 0, 0, 0}, // 3
            {1, 0, 0, 0, 0}  // 4
        };
        Grafo grafo = new Grafo();
        grafo.bornfrommatrix(matrizAdyacencia);
        grafo.imprimirGrafo();}}
