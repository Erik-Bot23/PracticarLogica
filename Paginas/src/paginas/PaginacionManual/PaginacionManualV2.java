package paginas.PaginacionManual;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaginacionManualV2 {

    // Misma convención que V1: la página 1 es la primera.
    public static <T> Map<String, Object> paginar(List<T> lista, int page, int size){
        if(page < 1) page = 1;
        if(size < 1) size = 1;

        int total = lista.size();
        int totalPages = (int) Math.ceil((double) total / size);

        int from = Math.min((page - 1) * size, total);
        int to = Math.min(from + size, total);

        // LinkedHashMap conserva el orden de inserción al imprimir.
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("contenido", lista.subList(from, to));
        respuesta.put("page", page);
        respuesta.put("size", size);
        respuesta.put("totalElementos", total);
        respuesta.put("totalPaginas", totalPages);
        return respuesta;
    }
}
