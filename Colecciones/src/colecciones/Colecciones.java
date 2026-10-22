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
public class Colecciones {
    
    public static void arregloDefinido(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        
        for(int i = 0; i < nums.length; i++){
            System.out.println("Ingresa el número " + (i+1) + ":");
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        for(int i=0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        int[] nums1 = {2,3,5,6};
        int[] nums2 = {10,6,3,9};
        
        findMedianSortedArrays arr = new findMedianSortedArrays();
        metodosDeArreglos met = new metodosDeArreglos();
        
        while(opcion != 4){
            System.out.println("Elige una opción:\n1. Arreglo definido\n2. "
                    + "Ingresar el tamaño del arreglo\n3. Media de dos arreglos.\n4. Salir");
            opcion = sc.nextInt();
            sc.close();
        
            switch(opcion){
              case 1:
                  met.arregloIngresado();
                  break;
              case 2:
                  arregloDefinido();
                  break;
              case 3:
                  System.out.println(arr.medianSorted(nums1, nums2));
                  break;
              default: 
                  System.out.println("Ingresa un valor válido.");
              }  
        }
    }
    
}
