/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumardosnumeros;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author IraCar-Technologies
 */
public class SumarDosNumeros {

    public static int[] twoSum(int[] nums, int target){
        //Creamos un mapa: clave = número, valor = índice donde aparece
        Map<Integer,Integer> mapa = new HashMap<>();
        
        //Recorremos el arreglo una sola vez
        for(int i = 0; i < nums.length; i++){
            //Calculamos qué número necesitamos para llegar al target
            int complemento = target - nums[i];
            
            //Si ya vimos ese complemento antes, tenemos la respuesta
            if(mapa.containsKey(complemento)){
                return new int[]{mapa.get(complemento),i};
            }
            
            //Si no, guardamos el número actual con su indice
            mapa.put(nums[i], i);
        }
        
        //Nunca debería llegar aquí segun el enunciado
        return new int[]{};
    }
            
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target))); //[0,1]
    }
    
}
