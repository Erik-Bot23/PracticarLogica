package nodos;

public class Nodos {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregarAlInicio(5);

        lista.imprimir(); // 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Valor en índice 2: " + lista.obtener(2)); // 20
        System.out.println("Tamaño: " + lista.getTamaño());

        lista.eliminar(20);
        lista.imprimir(); // 5 -> 10 -> 30 -> null

        lista.invertir();
        System.out.print("Invertida: ");
        lista.imprimir(); // 30 -> 10 -> 5 -> null

        System.out.println("Como lista: " + lista.aLista());
        System.out.println("Nodo del medio: " + lista.nodoMedio());
        System.out.println("¿Tiene ciclo? " + lista.tieneCiclo());

        // Duplicados en lista ordenada
        ListaEnlazada conDuplicados = new ListaEnlazada();
        conDuplicados.agregar(1);
        conDuplicados.agregar(1);
        conDuplicados.agregar(2);
        conDuplicados.agregar(3);
        conDuplicados.agregar(3);
        conDuplicados.eliminarDuplicados();
        System.out.print("Sin duplicados: ");
        conDuplicados.imprimir(); // 1 -> 2 -> 3 -> null

        // Fusionar dos listas ordenadas
        ListaEnlazada a = new ListaEnlazada();
        a.agregar(1);
        a.agregar(4);
        a.agregar(7);

        ListaEnlazada b = new ListaEnlazada();
        b.agregar(2);
        b.agregar(3);
        b.agregar(8);

        ListaEnlazada fusionada = a.fusionar(b);
        System.out.print("Fusionada: ");
        fusionada.imprimir(); // 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> null
    }
}
