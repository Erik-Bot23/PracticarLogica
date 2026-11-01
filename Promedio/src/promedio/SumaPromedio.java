/*
 Suma y promedio condicional
 Dada una lista de Producto(nombre, precio, categoria),
 calcula el precio promedio de productos de categoría "ELECTRONICA" cuyo precio sea > 100.
*/

package promedio;

import java.util.List;

public class SumaPromedio {
    public static double sumPro(){
        record Producto(String nombre, double precio, String categoria) {};

        List<Producto> productos = List.of(
            new Producto("Celular Xiomi", 4500, "Electronica"),
            new Producto("Smart TV Samsung", 10000, "Electronica"),
            new Producto("Arroz", 300, "Alimentos")
        );

        return productos.stream()
                        .filter(p -> "Electronica".equalsIgnoreCase(p.categoria()))
                        .filter(p -> p.precio() > 100)
                        .mapToDouble(Producto::precio)
                        .average()
                        .orElse(0.0);
    }
}
