package com.mycompany.recorridosfinal;
//vector(arbol) {8, 3, 1, 20, 5, 10, 7, 4}
class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    //const
    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;}

    //árbol desde array
    public static Nodo construirArbol(int[] valores) {
        Nodo raiz = null;
        for (int valor : valores) {
            raiz = insertar(raiz, valor);}
        return raiz;}

    //nodos
    private static Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);}
        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);} 
        else {nodo.derecho = insertar(nodo.derecho, valor);}
        return nodo;}

    //preorden
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);}}

    //inorden
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho); }}

    // posorden
    public void posorden(Nodo nodo) {
        if (nodo != null) {
            posorden(nodo.izquierdo);
            posorden(nodo.derecho);
            System.out.print(nodo.valor + " ");}}}

public class RecorridosFinal {
    public static void main(String[] args) {
        
        int[] vector1 = {8, 3, 1, 20, 5, 10, 7, 4};
        Nodo arbol1 = Nodo.construirArbol(vector1);

        System.out.println("Recorrido en preorden:");
        arbol1.preorden(arbol1);

        System.out.println("\nRecorrido en inorden:");
        arbol1.inorden(arbol1);

        System.out.println("\nRecorrido en posorden:");
        arbol1.posorden(arbol1);}}
