package Cliente;

/**
 *
 * @author jafet
 */
public class NodoCliente {

    private Cliente dato;
    private NodoCliente next;


    public NodoCliente(Cliente dato) {
        this.dato = dato;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getNext() {
        return next;
    }

    public void setNext(NodoCliente next) {
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
