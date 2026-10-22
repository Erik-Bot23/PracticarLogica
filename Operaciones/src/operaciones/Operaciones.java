/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.util.Scanner;

/**
 *
 * @author IraCar-Technologies
 */
public class Operaciones {

    //Función para multiplos de números
    public void multiplos(){
        Scanner sc = new Scanner(System.in);
        int numero;
        
        System.out.println("Introduce un número  entero: ");
        numero = sc.nextInt();
        
        double dob = 2*numero;
        double tri = 3*numero;
        
        System.out.println("El doble del número" + numero + " -> " + dob);
        System.out.println("El triple del número" + numero + " -> " + tri);
    }
    
    //Función para conversión de °C a °F
    private double grados(double gradC){
        double gradF;
        gradF = 32 + (9 * gradC / 5);
        System.out.println("La conversión de los "+ gradC + "°C = " + gradF + "°F");
        return gradF;
    }
    
    public static void main(String[] args) {
       Operaciones gd = new Operaciones();
       //gd.multiplos();
       
       Scanner sc = new Scanner(System.in);
       System.out.println("Ingresa los grados centigrados: ");
       double gradC;
       gradC = sc.nextDouble();
       sc.close();
       gd.grados(gradC);
       
    }
}