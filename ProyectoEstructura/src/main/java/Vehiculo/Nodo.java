package Vehiculo;

/**
 *
 * @author Maria Gabriela
 */
public class Nodo {

    private Vehiculo dato; //donde se almacenará la info de la persona 
    private Nodo next; //la referencia al siguiente obj de tipo Nodo que
    //contiene una persona 

    //Constructor que solo recibe persona, no se incluye el next 
    public Nodo(Vehiculo dato) {
        this.dato = dato;
    }
    //Get and sets 

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    //Molina: Falta completar el toString para mostrar la información del vehículo
    //De acuerdo a todos los atributos del vehículo
    //Gabriela: Todo gucci por acá 
    @Override
    public String toString() {
        return "Año: " + dato.getAno()+"Marca: " + dato.getMarca()+
                "Modelo: " + dato.getModelo() +"Número de placa: " + 
                dato.getNumPlaca() +"Color: " + dato.getColor()
                +"Número de pasajeros: " + dato.getNumPasajeros() +
                "Tipo de combustible: " + dato.getCombustible() +"Estado: " + 
                "Precio del día: " + dato.getPrecioDia()+"Cilindrada: " 
                + dato.getCilindrada()+ " Las extras son: " + dato.getExtras() 
                + "\n";
    }
 
    
}
