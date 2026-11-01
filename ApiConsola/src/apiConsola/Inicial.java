/*
 API de tareas en consola
 Sin Spring todavía, haz una app de consola que:
 Permita crear, listar, completar y borrar tareas
 Use Map<Long, Tarea> como "base de datos"
 Separe en capas: TareaRepository, TareaService, TareaController (consola)
 Este es el 90% del trabajo mental que haces en Spring Boot.
*/

package apiConsola;

import apiConsola.Controller.ApiController;

public class Inicial {
    public static void main(String[] args){
        new ApiController().iniciar();
    }
}
