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
    
    public String imprimirDatos() {
        return "Los datos del cliente indicado son:\nNombre completo: " 
                + dato.getNomCompleto() + "\nCedula: " + dato.getCedula() 
                + "\nCorreo: " + dato.getCorreo() + "\nFecha de nacimiento: " 
                + dato.getFechaNac() + "\nCategoría: " + dato.getCategoria() 
                + "\n"; 
    }
    
    @Override
    public String toString() {
        return "Nombre completo: " 
                + dato.getNomCompleto() + " cedula: " + dato.getCedula() + "\n"; 
    }
}
