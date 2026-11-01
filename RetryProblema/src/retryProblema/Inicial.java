/*
 Implementa un método ejecutarConReintentos(Supplier<T>, intentos) que reintente si lanza excepción.
 Esto lo usarás con @Retryable o Resilience4j.
*/

package retryProblema;

import java.util.concurrent.atomic.AtomicInteger;

public class Inicial {
    public static void main(String[] args){
        AtomicInteger contador = new AtomicInteger();

        // Esta tarea falla las dos primeras veces y funciona a la tercera.
        String resultado = RetryBackoff.ejecutarConReintentos(() -> {
            int intento = contador.incrementAndGet();
            System.out.println("Intento " + intento);
            if(intento < 3){
                throw new RuntimeException("Fallo simulado " + intento);
            }
            return "Conexión exitosa en el intento " + intento;
        }, 5);

        System.out.println(resultado);
    }
}
