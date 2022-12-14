package Solicitudes;

import Cliente.Categoria;
import Vehiculo.EstadoVehiculo;
import Vehiculo.ListaVehiculo;
import Vehiculo.NodoVehiculo;
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

    /*Recibe 2 listas, una cola y una pila con la finalidad de poder hacer el
    movimiento de datos, este método toma los vehículos y los asigna a las 
    solicitudes, moviendo las solicitudes y los vehículos a una estructura de 
    datos nueva que los va a almacenar una vez tratados*/
    //Segundo hay que validar si los parametros de la solicitud cumplen con un vehiculo y priorizar este
    //Se pasa la placa a la solicitud, se cambia el estado del vehículo a asignado
    //Se cambia la solicitud a estado procesada
    //Se debe calcular el monto del alquiler  con el monto diario por la cantidad de días por el 13%
    //El monto tiene que quedar en la solicitud
    //Si el monto es mayor a 70 reds sube la categoría
    //Si no hay vehículos queda como rechazada
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
                listaGlobal.extrae(listaGlobal.getCabeza().getDato().getNumPlaca());
                //Hago el calculo del monto total para colocarlo
                aux.getDato().setMontoTotal(Math.round((extraido.getPrecioDia() * aux.getDato().getCantDias()) * 1.13));
                aux.getDato().ajustarCategoriaMonto();
                //Se usa el auxiliar para poder acceder posteriormente al frente
                if (aux != null) {
                    //Esta línea pasa el nodo de frente al siguiente en la cola
                    aux.getDato().setPlacaVehiculo(extraido.getNumPlaca());
                    aux.getDato().setEstado(EstadoSolicitud.Procesada);
                    frente = frente.getAtras();
                    //Quita la relación con el nodo de atrás ya que define al de atrás 
                    //como nulo
                    aux.setAtras(null);

                } else {
                    JOptionPane.showMessageDialog(null, "No quedan solicitudes "
                            + "pendientes");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay solicitudes en estado 'Registrado'");
        }
        largo--;
    }

    public void devolucion(String Cedula, String Placa, String Estado, 
            ColaSolicitudes colaAtendidos, ListaVehiculo listaVehiculoAtendida){
        if (frente != null) {
            NodoSolicitud aux = frente;
            while (!aux.getDato().getCliente().getCedula().equals(Cedula) && 
                    !aux.getDato().getPlacaVehiculo().equals(Placa)) {                
                if (aux.getAtras() == null) {
                    JOptionPane.showMessageDialog(null, "No hay solicitudes "
                            + "para esta cedula y placa");
                } else {
                    aux = aux.getAtras();
                }
            }
            aux.getDato().setEstado(EstadoSolicitud.Finalizada);
        } else {
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
