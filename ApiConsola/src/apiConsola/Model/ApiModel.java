package apiConsola.Model;

public class ApiModel {

    // Record anidado y público: representa una fila de nuestra "tabla" de tareas.
    public record Tarea(Long id, String titulo, boolean completada) {
    }
}
