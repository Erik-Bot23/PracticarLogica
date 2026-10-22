package mapas;

import java.util.Map;

public class Mapas {
    public static void main(String[] args){
        Map<String, Integer> frecuencia = RepetirPalabras.frecuencia();

        System.out.println("El resultado es: " + frecuencia);
    }
}
