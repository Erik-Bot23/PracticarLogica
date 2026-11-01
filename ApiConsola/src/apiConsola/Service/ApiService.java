package apiConsola.Service;

import java.util.List;

import apiConsola.Model.ApiModel.Tarea;
import apiConsola.Repository.ApiRepository;

public class ApiService {
    private final ApiRepository repo;

    public ApiService(ApiRepository repo){
        this.repo = repo;
    }

    public Tarea crear(String titulo){
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("Titulo vacío");
        }

        return repo.save(new Tarea(null, titulo, false));
    }

    public Tarea completar(Long id){
        // orElseThrow recibe un Supplier<RuntimeException>: una función que crea el error.
        Tarea t = repo.findById(id)
                      .orElseThrow(() -> new RuntimeException("No existe la tarea " + id));

        return repo.save(new Tarea(t.id(), t.titulo(), true));
    }

    public List<Tarea> listar(){
        return repo.findAll();
    }

    public void borrar(Long id){
        repo.delete(id);
    }
}
