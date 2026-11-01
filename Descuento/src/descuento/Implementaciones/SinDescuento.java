package descuento.Implementaciones;

import descuento.Interfaces.Descuento;

public class SinDescuento implements Descuento {
    public double aplicar(double precio){
        return precio;
    }
}
