/**
   1. Filtrar y transformar listas
   Dado un List<String> de nombres, devuelve una lista solo con los que empiecen por "A", en mayúsculas y ordenados alfabéticamente.
   List<String> nombres = List.of("Ana", "pedro", "Antonio", "Luis", "alberto");
   Resultado esperado: ["ALBERTO", "ANA", "ANTONIO"]
 */

package listas;

import java.util.List;

public class FiltrarTransformarListas {
    //Lógica dentro de un método estatico para que pueda ser llamada en main
    public static List<String> filtrarYTransformar(){
        List<String> nombres = List.of("Ana", "pedro", "Antonio", "Luis", "alberto");

        return nombres.stream().filter(n -> n.toLowerCase().startsWith("a")).map(String::toUpperCase).sorted().toList();
    }
}
