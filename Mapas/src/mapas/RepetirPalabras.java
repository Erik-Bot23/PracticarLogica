/*
 Contar frecuencia de palabras
 Dada una frase, devuelve un Map<String, Integer> con la frecuencia de cada palabra.
 String frase = "spring boot es genial spring es rapido";
 {spring=2, boot=1, es=2, genial=1, rapido=1}
*/
package mapas;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RepetirPalabras {
    public static Map<String, Integer> frecuencia(){
        String frase = "spring boot es genial spring es rapido";

        return Arrays.stream(frase.split("\\s+")).collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));

    }
}
