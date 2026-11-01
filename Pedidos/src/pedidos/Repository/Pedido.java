package pedidos.Repository;

import java.util.List;

public record Pedido(Long id, Cliente cliente, List<LineaPedido> lineas) {

    // El total del pedido es la suma de los subtotales de sus líneas.
    public double total(){
        return lineas.stream()
                     .mapToDouble(LineaPedido::subtotal)
                     .sum();
    }
}
