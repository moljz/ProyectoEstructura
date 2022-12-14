package Solicitudes;

/**
 *
 * @author Juan Carlos
 */
public class NodoSolicitud {

    private Solicitud dato;
    private NodoSolicitud atras;

    public NodoSolicitud(Solicitud dato) {
        this.dato = dato;
    }

    public Solicitud getDato() {
        return dato;
    }

    public void setDato(Solicitud dato) {
        this.dato = dato;
    }

    public NodoSolicitud getAtras() {
        return atras;
    }

    public void setAtras(NodoSolicitud atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {

        return "\nDetalles de la solicitud: \nFecha:" + dato.getFecha()
                + "\nCedula del cliente: " + 
                dato.getCliente().getCedula() + "\nCategoría: " 
                + dato.getCliente().getCategoria()
                + "\nCantidad de días: "
                + dato.getCantDias() + "\nMinimo de pasajeros: "
                + dato.getMinPasajeros() + "\nMarca: " + dato.getMarca()
                + "\nModelo: " + dato.getModelo() + "\nAño: " + dato.getAno()
                + "\nExtras: " + dato.getExtras() + "\nEstado: "
                + dato.getEstado() + "\nLa placa asignada es: " 
                + dato.getPlacaVehiculo() + "\nEl monto de la solicitud es: " 
                + dato.getMontoTotal();
    }

}
