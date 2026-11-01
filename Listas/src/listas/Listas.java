package listas;

import java.util.List;
import java.util.Set;

public class Listas {
    public static void main(String[] args){
        List<String> resultado = FiltrarTransformarListas.filtrarYTransformar();
        List<Integer> numRepetidos = NumerosRepetidos.numerosRepetidos();
        Set<Integer> numConjuntos = NumerosRepetidos.numerosConjuntos();
        List<Integer> anidados = EstructurasAnidadas.estructAnidadas();
        List<String> top = TopN.top();

        System.out.println("Filtrar y transformar: " + resultado);
        System.out.println("Duplicados (con for): " + numRepetidos);
        System.out.println("Duplicados (con frequency + Set): " + numConjuntos);
        System.out.println("Estructuras anidadas: " + anidados);
        System.out.println("Top 3 productos: " + top);
    }
}
