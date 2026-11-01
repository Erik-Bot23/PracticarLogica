package apiConsola.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import apiConsola.Model.ApiModel.Tarea;

public class ApiRepository {
    private final Map<Long, Tarea> db = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public Tarea save(Tarea t){
        // Si viene sin ID es nueva: generamos uno.
        if(t.id() == null){
            t = new Tarea(seq.getAndIncrement(), t.titulo(), t.completada());
        }
        // Siempre guardamos: así también funciona para actualizar.
        db.put(t.id(), t);
        return t;
    }

    public Optional<Tarea> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }

    public List<Tarea> findAll(){
        return new ArrayList<>(db.values());
    }

    public void delete(Long id){
        db.remove(id);
    }
}
