
package Extras;

/**
 *
 * @author Maria Gabriela
 */
public class Nodo {
    private String dato;
    private Nodo atras;

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    public Nodo(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return dato;
    }

    
}
