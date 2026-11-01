package repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

record Usuario(Long id, String nombre, String email) {};

public class UsuarioRepository {
    private final Map<Long, Usuario> db = new HashMap<>();
    //AtomicLong evita condiciones de carrera (thread-safe). Spring usa cosas similares internamente.
    private final AtomicLong contador = new AtomicLong(1);

    public Usuario save(Usuario u){
        if(u.id() == null){
            u = new Usuario(contador.getAndIncrement(), u.nombre(), u.email());
        }

        db.put(u.id(), u);
        return u;
    }

    public Optional<Usuario> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }

    public List<Usuario> findAll(){
        return new ArrayList<>(db.values());
    }

    public void deleteById(Long id) {
        db.remove(id);
    }
}
