package listas;

import java.util.List;
import java.util.Set;

public class Listas {
    public static void main(String[] args){
        List<String> resultado = FiltrarTransformarListas.filtrarYTransformar();
        List<Integer> numRepetidos = NumerosRepetidos.numerosRepetidos();
        Set<Integer> numConjuntos = NumerosRepetidos.numerosConjuntos();

        System.out.println("El resultado es: " + resultado);
        System.out.println("El resultado es: "+ numRepetidos);
        System.out.println("Otra forma de imprimir la opción dos es: " + numConjuntos);
    }
}
