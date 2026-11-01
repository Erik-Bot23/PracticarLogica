package descuento;

import descuento.Implementaciones.DescuentoBlackFriday;
import descuento.Implementaciones.DescuentoNavidad;
import descuento.Implementaciones.SinDescuento;
import descuento.Service.DescuentoService;

public class DescuentoMain {
    public static void main(String[] args){
        DescuentoService sinDes = new DescuentoService(new SinDescuento());
        DescuentoService desNavidad = new DescuentoService(new DescuentoNavidad());
        DescuentoService desBlack = new DescuentoService(new DescuentoBlackFriday());

        System.out.println("El precio del producto sin descuento es: " + sinDes.calcular(100) + ".\n" +
                            "El precio del producto con descuento de blackfriday es: "+ desBlack.calcular(100) + ".\n" + 
                            "El precio del producto con descuento de navidad es: " + desNavidad.calcular(100) + ".");
    }
}
