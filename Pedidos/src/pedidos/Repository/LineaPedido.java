package pedidos.Repository;

public record LineaPedido(Producto producto, int cantidad) {

    // Una línea sabe calcular su propio subtotal: precio unitario * cantidad.
    public double subtotal(){
        return producto.precio() * cantidad;
    }
}
