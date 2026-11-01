package cacheProblema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheExperiracion<K, V> {
    private record Entry<V>(V valor, long expiraEn){}
    private final Map<K, Entry<V>> store = new ConcurrentHashMap<>();

    public void put(K key, V value, long ttlMillis){
        // Guardamos el instante exacto en el que el valor deja de ser válido.
        store.put(key, new Entry<>(value, System.currentTimeMillis() + ttlMillis));
    }

    public V get(K key){
        Entry<V> e = store.get(key);
        if(e == null) return null;
        if(System.currentTimeMillis() > e.expiraEn()){
            store.remove(key);
            return null;
        }

        return e.valor();
    }
}
