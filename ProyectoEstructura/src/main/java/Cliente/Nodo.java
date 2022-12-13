package Cliente;

/**
 *
 * @author jafet
 */
public class Nodo {

    private Cliente dato;
    private Nodo next;


    public Nodo(Cliente dato) {
        this.dato = dato;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
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
        return "Los datos del cliente son: Nombre completo: " 
                + dato.getNomCompleto() + " cedula: " + dato.getCedula() 
                + ", correo: " + dato.getCorreo() + ", fecha de nacimiento: " 
                + dato.getFechaNac() + " y categoría: " + dato.getCategoria() 
                + "\n"; 
    }
}
