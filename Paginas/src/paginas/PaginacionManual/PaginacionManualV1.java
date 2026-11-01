package paginas.PaginacionManual;

import java.util.ArrayList;
import java.util.List;

public class PaginacionManualV1 {
    public static <T> List<T> obtenerPagina(List<T> listaCompleta, int numeroPagina, int tamanoPagina){
        //Validar que la página sea al menos 1
        if(numeroPagina <1 ){
            numeroPagina = 1;  
        }

        int indiceInicial = (numeroPagina - 1) * tamanoPagina;

        //Si el índice inicial excede el tamaño de la lista, devolver lista vacía
        if(indiceInicial >= listaCompleta.size()){
            return new ArrayList<>();
        }

        int indiceFinal = Math.min(indiceInicial + tamanoPagina, listaCompleta.size());

        return listaCompleta.subList(indiceInicial, indiceFinal);
    }
}
