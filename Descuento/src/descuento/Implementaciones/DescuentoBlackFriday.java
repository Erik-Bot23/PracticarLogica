package descuento.Implementaciones;

import descuento.Interfaces.Descuento;

public class DescuentoBlackFriday implements Descuento {
    public double aplicar(double precio){
        return precio * 0.50;
    }
}
