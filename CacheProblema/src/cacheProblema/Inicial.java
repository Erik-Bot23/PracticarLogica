/*
 Cache simple con expiración
 Implementa una clase Cache<K,V> que guarde valores con un TTL (tiempo de vida).
 Si pides un valor expirado, devuelve null.
*/

package cacheProblema;

public class Inicial {
    public static void main(String[] args) throws InterruptedException {
        CacheExperiracion<String, String> cache = new CacheExperiracion<>();

        cache.put("usuario:1", "Ana", 500); // vive 500 ms
        System.out.println("Recién guardado: " + cache.get("usuario:1"));

        Thread.sleep(700); // esperamos a que expire

        System.out.println("Después de 700 ms: " + cache.get("usuario:1"));
    }
}
