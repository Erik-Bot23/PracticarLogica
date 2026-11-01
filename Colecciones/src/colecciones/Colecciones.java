/*
 * Ejercicios de arreglos y media de dos arreglos ordenados.
 */
package colecciones;

import java.util.Arrays;
import java.util.Scanner;

public class Colecciones {

    // Lee exactamente 5 números y los imprime de tres formas.
    public static void arregloDefinido(Scanner sc){
        int[] nums = new int[5];

        for(int i = 0; i < nums.length; i++){
            System.out.println("Ingresa el número " + (i + 1) + ":");
            nums[i] = sc.nextInt();
        }

        System.out.println("Impresión con for:");
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }

        System.out.println("Impresión con Arrays.toString:");
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        // Un solo Scanner para toda la aplicación.
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // IMPORTANTE: el algoritmo de mediana asume que ambos arreglos ya están ordenados.
        int[] nums1 = {2, 3, 5, 6};
        int[] nums2 = {3, 6, 9, 10};

        findMedianSortedArrays arr = new findMedianSortedArrays();
        metodosDeArreglos met = new metodosDeArreglos();

        while(opcion != 4){
            System.out.println("\nElige una opción:\n1. Arreglo definido (5 números)\n"
                    + "2. Ingresar el tamaño del arreglo\n3. Media de dos arreglos.\n4. Salir");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    arregloDefinido(sc);
                    break;
                case 2:
                    met.arregloIngresado(sc);
                    break;
                case 3:
                    System.out.println("La mediana es: " + arr.medianSorted(nums1, nums2));
                    break;
                case 4:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Ingresa un valor válido.");
            }
        }

        sc.close();
    }
}
