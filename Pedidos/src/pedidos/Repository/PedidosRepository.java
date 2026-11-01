package pedidos.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PedidosRepository {
    private final List<Pedido> pedidos;

    public PedidosRepository(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    // Cliente -> suma de lo que gastó en todos sus pedidos.
    public Map<Cliente, Double> gastoPorCliente(){
        return pedidos.stream()
                      .collect(Collectors.groupingBy(
                          Pedido::cliente,                       // clave: el cliente del pedido
                          Collectors.summingDouble(Pedido::total) // valor: suma de totales
                      ));
    }

    // Cliente que más gastó (el nombre, no el objeto).
    public String clienteQueMasGasto(){
        return gastoPorCliente().entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(entry -> entry.getKey().nombre())
                                .orElse(null);
    }

    // Producto más vendido por unidades.
    public String productoMasVendido(){
        return pedidos.stream()
                      .flatMap(p -> p.lineas().stream())          // una sola corriente de líneas
                      .collect(Collectors.groupingBy(
                          linea -> linea.producto().nombre(),
                          Collectors.summingInt(LineaPedido::cantidad)
                      ))
                      .entrySet().stream()
                      .max(Map.Entry.comparingByValue())
                      .map(Map.Entry::getKey)
                      .orElse(null);
    }

    // Cuánto dinero generó cada producto (precio * unidades).
    public Map<String, Double> ingresoPorProducto(){
        return pedidos.stream()
                      .flatMap(p -> p.lineas().stream())
                      .collect(Collectors.groupingBy(
                          linea -> linea.producto().nombre(),
                          Collectors.summingDouble(LineaPedido::subtotal)
                      ));
    }
}
