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

    //Molina: Revisar si este método es necesario
    void setNext(Object cabeza) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Los datos del cliente son: Nombre completo: " 
                + dato.getNomCompleto() + ", cedula: " + dato.getCedula() 
                + ", correo: " + dato.getCorreo() + ", fecha de nacimiento: " 
                + dato.getFechaNac() + " y categoría: " + dato.getCategoria() 
                + "\n"; 
    }
    
    

}
