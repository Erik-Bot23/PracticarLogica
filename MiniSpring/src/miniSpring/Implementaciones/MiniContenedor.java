package miniSpring.Implementaciones;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import miniSpring.Interfaces.MiServicio;
import miniSpring.Service.EmailService;
import miniSpring.Service.UserService;

public class MiniContenedor {
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public void escanear(String paquete) throws Exception{
        // Versión simplificada: en un Spring real se recorre el paquete con classpath scanning.
        // Aquí la lista de clases está escrita a mano para concentrarnos en la inyección.
        List<Class<?>> classes = List.of(EmailService.class, UserService.class);

        // PRIMERA PASADA: instanciar las clases que NO tienen dependencias (constructor sin parámetros).
        for(Class<?> c : classes){
            if(!c.isAnnotationPresent(MiServicio.class)) continue;

            Constructor<?>[] constructores = c.getConstructors();

            if(constructores.length > 0 && constructores[0].getParameterCount() == 0){
                beans.put(c, c.getDeclaredConstructor().newInstance());
            }
        }

        // SEGUNDA PASADA: instanciar las que dependen de otros beans.
        for(Class<?> c : classes){
            if(!c.isAnnotationPresent(MiServicio.class) || beans.containsKey(c)) continue;

            Constructor<?> ctor = c.getConstructors()[0];

            // Para cada tipo de parámetro del constructor, buscamos el bean ya creado.
            Object[] args = Arrays.stream(ctor.getParameterTypes())
                                  .map(beans::get)
                                  .toArray();

            beans.put(c, ctor.newInstance(args));
        }
    }

    public <T> T getBean(Class<T> tipo){
        Object bean = beans.get(tipo);
        if(bean == null){
            throw new IllegalArgumentException("No hay bean para " + tipo.getName());
        }
        return tipo.cast(bean);
    }
}
