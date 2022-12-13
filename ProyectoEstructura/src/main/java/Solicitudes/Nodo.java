package Solicitudes;

/**
 *
 * @author Juan Carlos
 */
public class Nodo {

    private Solicitud dato;
    private Nodo next;

    public Nodo(Solicitud dato) {
        this.dato = dato;
    }

    public Solicitud getDato() {
        return dato;
    }

    public void setDato(Solicitud dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Detalles de la solicitud: \nCantidad de días: "
                + dato.getCantDias() + "\nMinimo de pasajeros: "
                + dato.getMinPasajeros() + "\nMarca: " + dato.getMarca()
                + "\nModelo: " + dato.getModelo() + "\nAño: " + dato.getAno()
                + "\nExtras: " + dato.getExtras() + "\nEstado: "
                + dato.getEstado() + "\n";
    }

}
