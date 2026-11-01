package descuento.Service;

import descuento.Interfaces.Descuento;

public class DescuentoService {
    private final Descuento descuento;

    public DescuentoService(Descuento descuento){
        this.descuento=descuento;
    }

    public double calcular(double precio){
        return descuento.aplicar(precio);
    }
}
