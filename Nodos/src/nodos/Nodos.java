
package nodos;

/**
 *
 * @author IraCar-Technologies
 */
public class Nodos {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregarAlInicio(5);
        
        lista.imprimir(); //5->10->20->30->null 
        
        System.out.println(lista.obtener(2)); //20
        lista.eliminar(20);
        lista.imprimir(); //5->10->30->null
        
        //lista.invertir();
        //lista.imprimir(); 
    }
}
