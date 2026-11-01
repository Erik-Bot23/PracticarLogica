/*
 Paginación manual
 Dada una lista de 100 elementos, implementa un método paginar(lista, page, size) 
 que devuelva la sublista correcta y el total de páginas.
 Igual que Pageable de Spring Data
 */

package paginas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import paginas.PaginacionManual.PaginacionManualV1;
import paginas.PaginacionManual.PaginacionManualV2;

public class Paginar {
    public static void main(String[] args){
        //Lista de ejemplo con 25 elementos
        List<Integer> numeros = new ArrayList<>();
        for(int i = 1; i <= 25; i++){
            numeros.add(i);
        }

        int paginaDeseada = 2;
        int elementosPorPagina = 10;

        List<Integer> resultado = PaginacionManualV1.obtenerPagina(numeros, paginaDeseada, elementosPorPagina);
        Map<String, Object> resultado2 = PaginacionManualV2.paginar(numeros, paginaDeseada, elementosPorPagina);

        System.out.println("Página " + paginaDeseada + ": " + resultado);
        System.out.println("Página " + paginaDeseada + ": " + resultado2);
    }
}
