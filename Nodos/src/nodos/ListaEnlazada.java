
package nodos;

public class ListaEnlazada {
    private NodoBasico cabeza; //Primer nodo
    private int tamaño;
    
    public ListaEnlazada(){
        this.cabeza = null;
        this.tamaño = 0;
    }
    
    //Agregar nodo al final
    public void agregar(int valor){
        NodoBasico nuevo = new NodoBasico(valor);
        
        if(cabeza == null){
           cabeza = nuevo;
        } else {
            NodoBasico actual = cabeza;
            
            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            
            actual.siguiente = nuevo;
        }
        tamaño ++;
    }
    
    //Agregar al inicio
    public void agregarAlInicio(int valor){
        NodoBasico nuevo = new NodoBasico(valor);
        
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño ++;
    }
    
    //Obtener índice
    public int obtener(int indice){
        if(indice < 0 || indice >= tamaño){
            throw new IndexOutOfBoundsException("Índice válido: " + indice);
        }
        
        NodoBasico actual = cabeza;
        for(int i = 0; i < indice; i++){
            actual = actual.siguiente;
        }
        
        return actual.valor;
    }
    
    //Eliminar por valor
    public boolean eliminar(int valor){
        if(cabeza == null) return false;
        
        if(cabeza.valor == valor){
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }
        
        NodoBasico actual = cabeza;
        while(actual.siguiente != null){
            if(actual.siguiente.valor == valor){
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
    
    //Recorrer e imprimir
    public void imprimir(){
        NodoBasico actual = cabeza;
        
        while(actual != null){
            System.out.print(actual.valor + " -> ");
            actual = actual.siguiente;
        }
        System.out.print("null\n");
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    //Invertir una lista enlazada
    public NodoBasico invertir(NodoBasico cabeza){
        NodoBasico anterior = null;
        NodoBasico actual = cabeza;
        
        while(actual != null){
            NodoBasico siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        return anterior;
    }
    
    //Regresar toda la lista
    
    
    //Detectar ciclo (algoritmo de Floyd)
    
    
    //Encontrar el nodo del medio
    
    
    //Eliminar duplicados de una lista ordenada
    
    
    //Fusionar dos listas ordenadas
    
    
}
