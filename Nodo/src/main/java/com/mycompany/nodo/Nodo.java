package com.mycompany.nodo;
public class Nodo 
{
    int valor;
    Nodo nodoizq;
    Nodo nododer;

    // constructor
    public Nodo(int valor) {
        this.valor = valor;
        this.nodoizq = null;
        this.nododer = null;}

    // constructor
    public Nodo() 
    {   this.nodoizq = null;
        this.nododer = null;}
    
    public static void main(String[] args) {
        //nodos
        Nodo nodo = new Nodo(60);
        nodo.nodoizq = new Nodo(41);
        nodo.nodoizq.nodoizq = new Nodo(16);
        nodo.nodoizq.nodoizq.nododer = new Nodo(25);
        nodo.nodoizq.nododer = new Nodo(53);
        nodo.nodoizq.nododer.nodoizq = new Nodo(46);
        nodo.nodoizq.nododer.nodoizq.nodoizq = new Nodo(42);
        nodo.nodoizq.nododer.nododer = new Nodo(55);
        
        nodo.nododer = new Nodo(74);
        nodo.nododer.nodoizq = new Nodo(65);
        nodo.nododer.nodoizq.nodoizq = new Nodo(63);
        nodo.nododer.nodoizq.nodoizq.nodoizq = new Nodo(62);
        nodo.nododer.nodoizq.nodoizq.nododer = new Nodo(64);
        nodo.nododer.nodoizq.nododer = new Nodo(70);

        // prints
        System.out.println(
    "Nodo raíz: " + nodo.valor + "\n" +
    "Nodo izquierdo: " + nodo.nodoizq.valor + "\n" +
    "Nodo izquierdo-izquierdo: " + nodo.nodoizq.nodoizq.valor + "\n" +
    "Nodo izquierdo-izquierdo-derecho: " + nodo.nodoizq.nodoizq.nododer.valor + "\n" +
    "Nodo izquierdo-derecho: " + nodo.nodoizq.nododer.valor + "\n" +
    "Nodo izquierdo-derecho-izquierdo: " + nodo.nodoizq.nododer.nodoizq.valor + "\n" +
    "Nodo izquierdo-derecho-izquierdo-izquierdo: " + nodo.nodoizq.nododer.nodoizq.nodoizq.valor + "\n" +
    "Nodo izquierdo-derecho-derecho: " + nodo.nodoizq.nododer.nododer.valor + "\n" +
    "Nodo derecho: " + nodo.nododer.valor + "\n" +
    "Nodo derecho-izquierdo: " + nodo.nododer.nodoizq.valor + "\n" +
    "Nodo derecho-izquierdo-izquierdo: " + nodo.nododer.nodoizq.nodoizq.valor + "\n" +
    "Nodo derecho-izquierdo-izquierdo-izquierdo: " + nodo.nododer.nodoizq.nodoizq.nodoizq.valor + "\n" +
    "Nodo derecho-izquierdo-izquierdo-derecho: " + nodo.nododer.nodoizq.nodoizq.nododer.valor + "\n" +
    "Nodo derecho-izquierdo-derecho: " + nodo.nododer.nodoizq.nododer.valor + "\n");}
}

