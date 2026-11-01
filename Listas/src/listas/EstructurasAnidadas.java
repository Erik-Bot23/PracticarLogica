/*
 Aplanar estructuras anidadas
 Dada una List<List<Integer>>, aplánala, filtra los pares y sácalos ordenados de mayor a menor.
 List<List<Integer>> datos = List.of(
    List.of(1, 2, 3),
    List.of(4, 5, 6),
    List.of(7, 8, 9)
    );
 [8, 6, 4, 2]
*/

package listas;

import java.util.Comparator;
import java.util.List;

public class EstructurasAnidadas {
    public static List<Integer> estructAnidadas(){
        List<List<Integer>> datos = List.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9)
        );

        return datos.stream()
                    .flatMap(List::stream)
                    .filter(n -> n % 2 == 0)
                    .sorted(Comparator.reverseOrder())
                    .toList();
    }
}
