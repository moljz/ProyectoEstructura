
package Vehiculo;

/**
 *
 * @author Maria Gabriela
 */
public class Nodo {
    private Vehiculo dato;
    private Nodo atras;

    public Nodo(Vehiculo dato) {
        this.dato = dato;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    
    /* Editar el toString para mostrar toda la información del vehículo*/
   @Override
    public String toString() {
        return "El valor es: " + String.valueOf(dato.getNumPlaca());
    }
}
