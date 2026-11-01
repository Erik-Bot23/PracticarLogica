/*
 Implementa el patrón Strategy
 Crea una interfaz CalculadoraDescuento con implementaciones:

 DescuentoNavidad (20%)
 DescuentoBlackFriday (50%)
 SinDescuento (0%)

 Luego un servicio que reciba el tipo por parámetro y calcule el precio final.

 Esto es exactamente lo que harás con @Service e inyección de dependencias.
*/

package descuento.Interfaces;

public interface Descuento {
    double aplicar(double precio);
} 