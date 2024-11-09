package com.mycompany.nodoarbolbinarioexam;
public class NodoArbolBinarioExam {
    int valor;
    NodoArbolBinarioExam nodoizq;
    NodoArbolBinarioExam nododer;

    // constructor
    public NodoArbolBinarioExam(int valor) {
        this.valor = valor;
        this.nodoizq = null;
        this.nododer = null;}

    // constructor sin valor
    public NodoArbolBinarioExam() {
        this.nodoizq = null;
        this.nododer = null; }

    //calcular el nivel de un nodo (distancia a la raíz)
    public int nivelNodo(NodoArbolBinarioExam nodo, int valor, int nivel) {
        if (nodo == null) {
            return -1; // nodo es nulo=valor no se encuentra
        }
        if (nodo.valor == valor) {
            return nivel; // return nivel actual si encuentra el valor
        }
        // looking for subárbol izquierdo
        int izqNivel = nivelNodo(nodo.nodoizq, valor, nivel + 1);
        if (izqNivel != -1) {
            return izqNivel;}
        // if no left, go right
        return nivelNodo(nodo.nododer, valor, nivel + 1);}

    // calcular la altura del árbol
    public int altura(NodoArbolBinarioExam nodo) {
        if (nodo == null) {
            return -1; // Si el nodo es null, la altura es -1, al no considerar a la raíz para medirse con sí misma
        }
        int alturaIzq = altura(nodo.nodoizq);
        int alturaDer = altura(nodo.nododer);
        return Math.max(alturaIzq, alturaDer) + 1; // Altura máxima más uno
    }

    // calcular el peso del árbol
    public int peso(NodoArbolBinarioExam nodo) {
        if (nodo == null) {
            return 0;}
        return 1 + peso(nodo.nodoizq) + peso(nodo.nododer); // Suma uno y recorre los subárboles
    }

    // calcular la profundidad máxima del árbol, contando los nodos, al no considerar a la raiz como 1, compensando el -1 de los métodos anteriores para que la raíz sea 0.
    public int profundidadMaxima(NodoArbolBinarioExam nodo) {
        return altura(nodo)+1; 
    }
    public int alturanodos(NodoArbolBinarioExam nodo) {
        return altura(nodo)+1; 
    }

    public static void main(String[] args) {
        // Crea el árbol según la imagen proporcionada
        NodoArbolBinarioExam nodo = new NodoArbolBinarioExam(60);
        nodo.nodoizq = new NodoArbolBinarioExam(41);
        nodo.nodoizq.nodoizq = new NodoArbolBinarioExam(16);
        nodo.nodoizq.nodoizq.nododer = new NodoArbolBinarioExam(25);
        nodo.nodoizq.nododer = new NodoArbolBinarioExam(53);
        nodo.nodoizq.nododer.nodoizq = new NodoArbolBinarioExam(46);
        nodo.nodoizq.nododer.nodoizq.nodoizq = new NodoArbolBinarioExam(42);
        nodo.nodoizq.nododer.nododer = new NodoArbolBinarioExam(55);
        
        nodo.nododer = new NodoArbolBinarioExam(74);
        nodo.nododer.nodoizq = new NodoArbolBinarioExam(65);
        nodo.nododer.nodoizq.nodoizq = new NodoArbolBinarioExam(63);
        nodo.nododer.nodoizq.nodoizq.nodoizq = new NodoArbolBinarioExam(62);
        nodo.nododer.nodoizq.nodoizq.nododer = new NodoArbolBinarioExam(64);
        nodo.nododer.nodoizq.nododer = new NodoArbolBinarioExam(70);

        // Pruebas de los métodos
        System.out.println("Nivel del nodo 60 : " + nodo.nivelNodo(nodo, 60, 0));
        System.out.println("Nivel del nodo 41,74 : " + nodo.nivelNodo(nodo, 41, 0));
        System.out.println("Nivel del nodo 16,53,65 : " + nodo.nivelNodo(nodo, 16, 0));
        System.out.println("Nivel del nodo 25, 46, 55, 63, 70: " + nodo.nivelNodo(nodo, 25, 0));
        System.out.println("Nivel del nodo 42, 62, 64 : " + nodo.nivelNodo(nodo, 42, 0));
        System.out.println("Altura del árbol: " + nodo.altura(nodo));
        System.out.println("Peso del árbol (número de nodos): " + nodo.peso(nodo));
        System.out.println("Profundidad máxima del árbol (contando nodos): " + nodo.profundidadMaxima(nodo));
        System.out.println("Altura del árbol (contando nodos): " + nodo.alturanodos(nodo));
    }
}
