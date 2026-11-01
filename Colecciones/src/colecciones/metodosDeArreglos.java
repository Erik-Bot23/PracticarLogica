package colecciones;

import java.util.Arrays;
import java.util.Scanner;

public class metodosDeArreglos {

    // Recibe el Scanner desde main para no cerrar System.in por accidente.
    public void arregloIngresado(Scanner sc){
        System.out.println("Ingresa el tamaño del arreglo:");
        int tamano = sc.nextInt();

        int[] nums = new int[tamano];

        for(int i = 0; i < nums.length; i++){
            System.out.println("Ingresa el número " + (i + 1) + ":");
            nums[i] = sc.nextInt();
        }

        System.out.println("Los números del arreglo son:");
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }

        System.out.println("Otra forma de imprimir el arreglo es la siguiente:");
        System.out.println(Arrays.toString(nums));
    }
}
