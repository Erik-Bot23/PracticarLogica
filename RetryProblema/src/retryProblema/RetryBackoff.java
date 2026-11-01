package retryProblema;

import java.util.function.Supplier;

public class RetryBackoff {

    public static <T> T ejecutarConReintentos(Supplier<T> tarea, int intentos){
        RuntimeException ultimoError = null;

        for(int i = 0; i < intentos; i++){
            try{
                return tarea.get(); // Si funciona, salimos inmediatamente.
            } catch(RuntimeException e){
                ultimoError = e;

                // Si ya no quedan intentos, no tiene sentido esperar.
                if(i == intentos - 1) break;

                try{
                    // Backoff exponencial: 100ms, 200ms, 400ms...
                    Thread.sleep((long) Math.pow(2, i) * 100);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(ie);
                }
            }
        }

        throw ultimoError != null ? ultimoError : new RuntimeException("Falló sin excepción.");
    }
}
