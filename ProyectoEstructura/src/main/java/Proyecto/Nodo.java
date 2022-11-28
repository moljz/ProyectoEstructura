
package Proyecto;

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

   @Override
    public String toString() {
        return "El valor es: " + String.valueOf(dato);
    }
}
