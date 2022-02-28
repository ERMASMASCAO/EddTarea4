package com.company;
import java.util.Scanner;
// @author Daniel Prieto Cano

public class Main {


    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();

        // @param vector que guarda la informacion escrita por el user
        int[] vector=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0)
            System.out.println();
            System.out.print(i+1+"\t");
        }
        vector = generarPrimos(dato);
        System.out.println ("Vector de primos hasta: " + teclado);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0)
            System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }

    //@param maximo Genera números primos de 1 al maximo
    public static int[] generarPrimos (int maximo)
    {
        int i,j;
        if (maximo >= 2) {
            // Declaraciones
            int dim = maximo + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];
            // Inicializar el array
            for (i = 0; i < dim; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo [0]= false;
            esPrimo [1] = false;
            // Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j = 2 * i; j < dim; j += i)
                        esPrimo[j] = false;
                }
            }
            //@param contador cuenta cuantos numeros primos hay
            int contador = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i])
                    contador++;
            }

            //@param primos Rellena el vector de números primos
            int[] primos = new int[contador];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            //@return primos devuelve primos
            return primos;
        } else { // maximo < 2
            //@return devuelve el vector vacio si el maximo es mayor que 2
            return new int[0];
            // Vector vacío
        }
    }
}