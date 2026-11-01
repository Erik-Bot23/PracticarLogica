/*
 Agrupación con Collectors
 Dada una lista de Persona(nombre, edad, ciudad), agrúpalas por ciudad y cuenta cuántas hay en cada una.
 record Persona(String nombre, int edad, String ciudad) {}
 Map<String, Long>
 */
package colectores;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgrupacionColectores {
    public static Map<String, Long> personaCiudad(){
        record Persona(String nombre, int edad, String ciudad) {};

        List<Persona> personas = List.of(
            new Persona("Ana", 25, "Madrid"),
            new Persona("Luis", 30, "Madrid"),
            new Persona("Eva", 22, "Barcelona")
        );

        return personas.stream().collect(Collectors.groupingBy(Persona::ciudad, Collectors.counting()));
    }
}
