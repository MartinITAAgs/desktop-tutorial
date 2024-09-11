package com.mycompany.comparativaordenamiento;
import java.util.Scanner;

public class ComparativaOrdenamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números a ordenar: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        System.out.println("Ingrese los números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }
        int[] numerosParaBurbujaMejorada = numeros.clone();

        double inicioBurbuja = System.nanoTime();
        burbuja(numeros);
        double finBurbuja = System.nanoTime();
        double tiempoBurbuja = finBurbuja - inicioBurbuja;

        // Ordenamiento de burbuja mejorada
        numeros = ordenacionBurbuja(numeros);
        double inicioBurbujaMejorada = System.nanoTime();
        ordenacionBurbuja(numerosParaBurbujaMejorada);
        double finBurbujaMejorada = System.nanoTime();
        printVector(numeros);
        double tiempoBurbujaMejorada = finBurbujaMejorada - inicioBurbujaMejorada;

        tiempoBurbuja=tiempoBurbuja/1000;
        tiempoBurbujaMejorada=tiempoBurbujaMejorada/1000;
        System.out.println("El método de la Burbuja Estándar tardó " + tiempoBurbuja + " milisegundos.");
        System.out.println("El método de la Burbuja Mejorada tardó " + tiempoBurbujaMejorada + " milisegundos.");
    }

    // Método Burbuja
    public static void burbuja(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método Burbuja Mejorada
    public static int[] ordenacionBurbuja(int[] vec) {
        boolean chng;
        do {
            chng = false;
            for (int i = 0; i < vec.length - 1; i++) {
                if (vec[i] > vec[i + 1]) {
                    int temp = vec[i];
                    vec[i] = vec[i + 1];
                    vec[i + 1] = temp;
                    chng = true;
                }
            }
        } while (chng);
        return vec;
    }

    public static void printVector(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            
            System.out.print(vec[i] + " ");
        }
        System.out.println("");
    }
}