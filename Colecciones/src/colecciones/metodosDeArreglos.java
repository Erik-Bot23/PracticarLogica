/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IraCar-Technologies
 */
public class metodosDeArreglos {
    public void arregloIngresado(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa el tamaño del arreglo: \n");
        int opcion = sc.nextInt();
        
        int[] nums = new int[opcion];
        
        for(int i = 0; i < nums.length; i++){
            System.out.println("Ingresa el número " + (i+1) + ":");
            nums[i] = sc.nextInt();
        }
        
        for(int i = 0; i < nums.length; i++){
            System.out.println("Los números del arreglo son: ");
            System.out.println(nums[i]);
        }
        
        System.out.println("Otra forma de imprimir el arreglo es la siguiente:");
        System.out.println(Arrays.toString(nums));
    }
}
