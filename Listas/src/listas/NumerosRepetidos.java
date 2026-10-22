/*
 Encontrar duplicados
 Dada una lista de enteros, devuelve solo los que aparecen más de una vez (sin repetirlos en el resultado).
 List<Integer> nums = List.of(1, 2, 3, 2, 4, 5, 1, 6);
 [1, 2]
*/
package listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumerosRepetidos {
    public static List<Integer> numerosRepetidos(){
        List<Integer> numeros = List.of(1, 2, 3, 2, 4, 5, 1, 6);

        Set<Integer> vistos = new HashSet<>();
        Set<Integer> duplicados = new HashSet<>();

        for(Integer n : numeros){
            if(!vistos.add(n)) duplicados.add(n);
        }

        return new ArrayList<>(duplicados);
    }

    public static Set<Integer> numerosConjuntos(){
        List<Integer> numeros = List.of(1, 2, 3, 2, 4, 5, 1, 6);

        return numeros.stream().filter(n -> Collections.frequency(numeros, n) > 1).collect(Collectors.toSet());

    }
}
