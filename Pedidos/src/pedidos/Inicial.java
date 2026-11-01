/*
 Sistema de pedidos
 Modela Cliente, Pedido, Producto con relaciones. Calcula:
 Total de un pedido
 Cliente que más gastó
 Producto más vendido
*/

package pedidos;

import java.util.List;

import pedidos.Repository.Cliente;
import pedidos.Repository.LineaPedido;
import pedidos.Repository.Pedido;
import pedidos.Repository.PedidosRepository;
import pedidos.Repository.Producto;

public class Inicial {
    public static void main(String[] args){
        // Catálogo de productos
        Producto leche   = new Producto(1L, "Leche", 2.50);
        Producto jamon   = new Producto(2L, "Jamón", 8.00);
        Producto cereal  = new Producto(3L, "Cereal", 4.00);

        // Clientes
        Cliente ana = new Cliente(1L, "Ana");
        Cliente luis = new Cliente(2L, "Luis");

        // Pedidos: cada pedido tiene un cliente y varias líneas
        Pedido p1 = new Pedido(1L, ana, List.of(
            new LineaPedido(leche, 4),
            new LineaPedido(jamon, 2)
        ));
        Pedido p2 = new Pedido(2L, luis, List.of(
            new LineaPedido(cereal, 3),
            new LineaPedido(leche, 2)
        ));
        Pedido p3 = new Pedido(3L, ana, List.of(
            new LineaPedido(jamon, 1)
        ));

        PedidosRepository repo = new PedidosRepository(List.of(p1, p2, p3));

        System.out.println("Total pedido 1: " + p1.total());
        System.out.println("Total pedido 2: " + p2.total());
        System.out.println("Total pedido 3: " + p3.total());
        System.out.println("Gasto por cliente: " + repo.gastoPorCliente());
        System.out.println("Cliente que más gastó: " + repo.clienteQueMasGasto());
        System.out.println("Producto más vendido: " + repo.productoMasVendido());
        System.out.println("Ingreso por producto: " + repo.ingresoPorProducto());
    }
}
