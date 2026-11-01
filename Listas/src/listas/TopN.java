/*
 Top N con streams
 Dada una lista de ventas Venta(producto, cantidad), devuelve los 3 productos más vendidos.
*/

package listas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopN {
    public static List<String> top(){
        record Venta(String producto, int cantidad) {};

        List<Venta> ventas = List.of(
            new Venta("Leche", 50),
            new Venta("Shampoo", 34),
            new Venta("Jamon", 40),
            new Venta("Cereal", 30)
        );

        Map<String, Integer> totalProducto = ventas.stream()
                                                    .collect(Collectors.groupingBy(
                                                        Venta::producto,
                                                        Collectors.summingInt(Venta::cantidad)
                                                    ));

        return totalProducto.entrySet().stream()
                            .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                            .limit(3)
                            .map(Map.Entry::getKey)
                            .toList();
    }
}
