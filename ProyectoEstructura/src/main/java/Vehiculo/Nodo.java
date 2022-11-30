
package Vehiculo;

/**
 *
 * @author Maria Gabriela
 */
public class Nodo {
    private Vehiculo dato; //donde se almacenará la info de la persona 
    private Nodo next; //la referencia al siguiente obj de tipo Nodo que contiene una persona 

    //Constructor que solo recibe persona, no se incluye el next 

    public Nodo(Vehiculo dato) {
        this.dato = dato;
    }
    //Get and sets 

    public Vehiculo getDato() { return dato; }

    public void setDato(Vehiculo dato) {this.dato = dato;}

    public Nodo getNext() {return next;}

    public void setNext(Nodo next) {this.next = next;}
   
     @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }
    
    /* Editar el toString para mostrar toda la información del vehículo*/
   
}
