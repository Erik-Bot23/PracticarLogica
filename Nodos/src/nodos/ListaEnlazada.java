package nodos;

import java.util.ArrayList;
import java.util.List;

public class ListaEnlazada {
    private NodoBasico cabeza; // Primer nodo
    private int tamaño;

    public ListaEnlazada(){
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Agregar nodo al final
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
        tamaño++;
    }

    // Agregar al inicio
    public void agregarAlInicio(int valor){
        NodoBasico nuevo = new NodoBasico(valor);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    // Obtener el valor de una posición
    public int obtener(int indice){
        if(indice < 0 || indice >= tamaño){
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }

        NodoBasico actual = cabeza;
        for(int i = 0; i < indice; i++){
            actual = actual.siguiente;
        }

        return actual.valor;
    }

    // Eliminar el primer nodo que contenga el valor
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

    // Recorrer e imprimir
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

    public boolean estaVacia(){
        return cabeza == null;
    }

    // Invertir la lista in-place (sin crear otra lista).
    public void invertir(){
        NodoBasico anterior = null;
        NodoBasico actual = cabeza;

        while(actual != null){
            NodoBasico siguiente = actual.siguiente; // guardamos el resto
            actual.siguiente = anterior;             // damos la vuelta al enlace
            anterior = actual;                       // avanzamos anterior
            actual = siguiente;                      // avanzamos actual
        }
        cabeza = anterior;
    }

    // Devolver toda la lista como List<Integer> (para poder compararla/imprimirla).
    public List<Integer> aLista(){
        List<Integer> resultado = new ArrayList<>();
        NodoBasico actual = cabeza;

        while(actual != null){
            resultado.add(actual.valor);
            actual = actual.siguiente;
        }
        return resultado;
    }

    // Detectar ciclo con el algoritmo de Floyd (tortuga y liebre).
    public boolean tieneCiclo(){
        NodoBasico lento = cabeza;
        NodoBasico rapido = cabeza;

        while(rapido != null && rapido.siguiente != null){
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if(lento == rapido) return true;
        }
        return false;
    }

    // Encontrar el valor del nodo del medio (si hay dos, devuelve el segundo).
    public int nodoMedio(){
        if(cabeza == null) throw new IllegalStateException("Lista vacía");

        NodoBasico lento = cabeza;
        NodoBasico rapido = cabeza;

        while(rapido != null && rapido.siguiente != null){
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }
        return lento.valor;
    }

    // Eliminar duplicados de una lista ORDENADA.
    public void eliminarDuplicados(){
        NodoBasico actual = cabeza;

        while(actual != null && actual.siguiente != null){
            if(actual.valor == actual.siguiente.valor){
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
            } else {
                actual = actual.siguiente;
            }
        }
    }

    // Fusionar esta lista con otra lista ORDENADA y devolver una nueva lista ordenada.
    public ListaEnlazada fusionar(ListaEnlazada otra){
        ListaEnlazada resultado = new ListaEnlazada();
        NodoBasico a = this.cabeza;
        NodoBasico b = otra.cabeza;

        while(a != null && b != null){
            if(a.valor <= b.valor){
                resultado.agregar(a.valor);
                a = a.siguiente;
            } else {
                resultado.agregar(b.valor);
                b = b.siguiente;
            }
        }

        while(a != null){
            resultado.agregar(a.valor);
            a = a.siguiente;
        }

        while(b != null){
            resultado.agregar(b.valor);
            b = b.siguiente;
        }

        return resultado;
    }
}
