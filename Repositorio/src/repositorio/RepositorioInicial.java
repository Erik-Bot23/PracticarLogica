/*
 Implementa un mini-repositorio en memoria
 Crea una clase UsuarioRepository con un Map<Long, Usuario> que soporte:
 save(Usuario) -> asigna ID automático
 findById(Long) -> devuelve Optional<Usuario>
 findAll()
 deleteById(Long)
 Esto es literalmente lo que hace Spring Data JPA por debajo.
*/

package repositorio;

public class RepositorioInicial {
    public static void main(String[] args){
        UsuarioRepository repo = new UsuarioRepository();

        // 1. Guardamos usuarios sin ID: el repositorio asigna 1, 2, 3...
        Usuario ana = repo.save(new Usuario(null, "Ana", "ana@mail.com"));
        Usuario luis = repo.save(new Usuario(null, "Luis", "luis@mail.com"));
        repo.save(new Usuario(null, "Eva", "eva@mail.com"));

        System.out.println("Guardados: " + ana + " y " + luis);

        // 2. Buscamos por ID. Optional nos obliga a pensar en el caso "no existe".
        repo.findById(2L).ifPresent(u -> System.out.println("Encontrado: " + u));
        System.out.println("¿Existe el ID 99? " + repo.findById(99L).isPresent());

        // 3. Listamos todo.
        System.out.println("Todos: " + repo.findAll());

        // 4. Actualizamos: si el ID ya existe, save() reemplaza el registro.
        repo.save(new Usuario(1L, "Ana María", "ana.maria@mail.com"));
        System.out.println("Después de actualizar: " + repo.findById(1L).orElseThrow());

        // 5. Borramos y comprobamos.
        repo.deleteById(2L);
        System.out.println("Después de borrar el 2: " + repo.findAll());
    }
}
