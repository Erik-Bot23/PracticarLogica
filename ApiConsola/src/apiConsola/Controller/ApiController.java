package apiConsola.Controller;

import java.util.Scanner;

import apiConsola.Repository.ApiRepository;
import apiConsola.Service.ApiService;

public class ApiController {
    private final ApiService service = new ApiService(new ApiRepository());
    private final Scanner sc = new Scanner(System.in);

    // El bucle va dentro de un método: en Java no puede haber código suelto en el cuerpo de una clase.
    public void iniciar(){
        boolean salir = false;

        while(!salir){
            System.out.println("\n1.Crear 2.Listar 3.Completar 4.Borrar 5.Salir");
            System.out.print("Opción: ");
            String opcion = sc.nextLine().trim();

            switch(opcion){
                case "1" -> {
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.println("Creada: " + service.crear(titulo));
                }
                case "2" -> service.listar().forEach(System.out::println);
                case "3" -> {
                    System.out.print("ID: ");
                    Long id = Long.parseLong(sc.nextLine().trim());
                    System.out.println("Completada: " + service.completar(id));
                }
                case "4" -> {
                    System.out.print("ID: ");
                    Long id = Long.parseLong(sc.nextLine().trim());
                    service.borrar(id);
                    System.out.println("Borrada la tarea " + id);
                }
                case "5" -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
