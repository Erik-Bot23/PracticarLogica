package colectores;

import java.util.Map;

public class Colectores {
    public static void main(String[] args){
        Map<String, Long> resultado = AgrupacionColectores.personaCiudad();
        System.out.println("El resultado del registro es: " + resultado);
    }
}
