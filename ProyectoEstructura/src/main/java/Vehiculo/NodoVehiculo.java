package Vehiculo;

/**
 *
 * @author Maria Gabriela
 */
public class NodoVehiculo {

    private Vehiculo dato; //donde se almacenará la info de la persona 
    private NodoVehiculo next; //la referencia al siguiente obj de tipo NodoVehiculo que

    //Constructor que solo recibe persona, no se incluye el next 
    public NodoVehiculo(Vehiculo dato) {
        this.dato = dato;
    }
    //Get and sets 

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public NodoVehiculo getNext() {
        return next;
    }

    public void setNext(NodoVehiculo next) {
        this.next = next;
    }

    //Molina: Falta completar el toString para mostrar la información del vehículo
    //De acuerdo a todos los atributos del vehículo
    //Gabriela: Todo gucci por acá 
    //Molina2: No gucci, acomodar las extras separadas por coma en una sola línea
    @Override
    public String toString() {
        return "Año: " + dato.getAno()+"\nMarca: " + dato.getMarca()+
                "\nModelo: " + dato.getModelo() +"\nNúmero de placa: " + 
                dato.getNumPlaca() +"\nColor: " + dato.getColor()
                +"\nNúmero de pasajeros: " + dato.getNumPasajeros() +
                "\nTipo de combustible: " + dato.getCombustible() +"\nEstado: " 
                + dato.getEstado() + "\nPrecio del día: " + dato.getPrecioDia()
                + "\nCilindrada: " + dato.getCilindrada() + "\nLas extras son: "
                + dato.getExtras() + "\n";
    }
    
}
