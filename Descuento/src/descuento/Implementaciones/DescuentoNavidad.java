package descuento.Implementaciones;

import descuento.Interfaces.Descuento;

public class DescuentoNavidad implements Descuento {
    public double aplicar(double precio){
        return precio * 0.80;
    }
}
