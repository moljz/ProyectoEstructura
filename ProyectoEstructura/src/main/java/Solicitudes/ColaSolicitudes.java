package Solicitudes;

import Vehiculo.EstadoVehiculo;
import Vehiculo.ListaVehiculo;
import Vehiculo.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Carlos
 */
public class ColaSolicitudes {

    //Estos dos nodos comienzan como nulos
    private NodoSolicitud frente;
    private NodoSolicitud ultimo;
    private int largo; //Lleva el tamaño de la cola

    //No es necesario ponerlo
    public ColaSolicitudes() {
    }

    public void encola(NodoSolicitud nuevoNodo) {
        //NodoSolicitud aux = frente;
        if (frente == null) { //Indica que la cola está vacía
            //Esto define al primer nodo como frente y último al no haber más
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setAtras(nuevoNodo);
            //Define como último al nuevo nodo
            ultimo = nuevoNodo;
        }
        largo++;
    }

    public void atiende(ListaVehiculo listaGlobal, ListaVehiculo 
            listaVehiculoAsignado, ColaSolicitudes colaAtendida, PilaSolicitud 
                    pilaAtendida) {
        //Verifica si hay solicitudes en estado registrado de acuerdo a la cola
        if (frente != null) {
            //Si hay genera un auxiliar
            NodoSolicitud aux = frente;
            //Mueve la solicitud a la cola de solicitudes que no están registradas
            colaAtendida.encola(aux);
            //Ingresa la misma solicitud a una pila para imprimirlas en orden correcto
            pilaAtendida.push(aux.getDato());
            //Verifica si hay vehículos disponibles
            if (listaGlobal.getCabeza() == null) {
                //Si no los hay, coloca como rechazada la solicitud
                aux.getDato().setEstado(EstadoSolicitud.Rechazada);
                //Informa al usuario
                JOptionPane.showMessageDialog(null, "No hay vehículos, esta"
                        + " solicitud se coloca como rechazada");
                //Retira la solicitud de la cola de registradas
                frente = frente.getAtras();
                //Extrae el nodo
                aux.setAtras(null);
            } else {
                //Si hay vehículos disponibles
                //Extraigo el primer vehículo de la lista global
                Vehiculo extraido = listaGlobal.getCabeza().getDato();
                //Cambio el estado del vehiculo a alquilado
                extraido.setEstado(EstadoVehiculo.Alquilado);
                //Lo coloca como alquilado para evitar que se elimine
                extraido.setAlquilado(true);
                //Inserta en la lista de vehiculos alquilados el vehiculo
                listaVehiculoAsignado.inserta(extraido);
                //Saco de la global el primer nodo
                listaGlobal.extrae(listaGlobal.getCabeza().getDato()
                        .getNumPlaca());
                //Hago el calculo del monto total para colocarlo
                aux.getDato().setMontoTotal(Math.round((extraido.getPrecioDia() 
                        * aux.getDato().getCantDias()) * 1.13));
                //Valida si hay que cambiar la categoría de acuerdo al monto de
                //la solicitud
                aux.getDato().ajustarCategoriaMonto();
                //Se usa el auxiliar para poder acceder posteriormente al frente
                if (aux != null) {
                    //Define la placa del vehículo que se asigna en la solicitud
                    aux.getDato().setPlacaVehiculo(extraido.getNumPlaca());
                    //Cambia el estado de la solicitud a procesada
                    aux.getDato().setEstado(EstadoSolicitud.Procesada);
                    //Extrae de esta cola el nodo
                    frente = frente.getAtras();
                    //Quita la relación con el nodo de atrás ya que define al 
                    //de atrás como nulo
                    aux.setAtras(null);
                } else {
                    //Notifica al usuario
                    JOptionPane.showMessageDialog(null, "No quedan solicitudes "
                            + "pendientes");
                }
            }

        } else {
            //Indica al usuario que no hay solicitudes nuevas
            JOptionPane.showMessageDialog(null, "No hay solicitudes en estado"
                    + " 'Registrado'");
        }
        largo--;
    }

    //Registra las devoluciones de vehiculos
    public void devolucion(String Cedula, String Placa, String Estado, 
            ColaSolicitudes colaAtendidos, ListaVehiculo listaVehiculoAtendida){
        //Mientras tenga algo en la cola
        if (frente != null) {
            //Asigno auxiliar al primero
            NodoSolicitud aux = frente;
            //Mientras no encuentre la placa y cedula
            while (!aux.getDato().getCliente().getCedula().equals(Cedula) && 
                    !aux.getDato().getPlacaVehiculo().equals(Placa)) {   
                //Mientras siga avanzando en la lista
                if (aux.getAtras() == null) {
                    //Si no hay más se indica al usuario
                    JOptionPane.showMessageDialog(null, "No hay solicitudes "
                            + "para esta cedula y placa");
                } else {
                    //Si las hay sigo recorriendo
                    aux = aux.getAtras();
                }
            }
//            Vehiculo extraido = listaVehiculoAtendida.extrae(Placa);
//            listaVehiculoAtendida.inserta(extraido);
            //Cambia el estado de la solicitud
            aux.getDato().setEstado(EstadoSolicitud.Finalizada);
        } else {
            //Indica que no hay más solicitudes
            JOptionPane.showMessageDialog(null, "No hay solicitudes en proceso");
        }
        
    }

    @Override
    public String toString() {
        String s = "";
        NodoSolicitud aux = frente;
        while (aux != null) {
            //Cuando se sobreescribe el método ToString al pasar el objeto 
            //completo el automáticamente va a obtener el valor
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s;
    }

}
