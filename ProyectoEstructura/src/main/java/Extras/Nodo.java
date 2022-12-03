
package Extras;

/**
 *
 * @author Maria Gabriela
 */
public class Nodo {
     private int dato;
    private Nodo atras;

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    public Nodo(int dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "El valor es: " + String.valueOf(dato);
    }

    
}
