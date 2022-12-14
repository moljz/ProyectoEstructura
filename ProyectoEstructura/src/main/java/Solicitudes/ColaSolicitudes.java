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
//            if (nuevoNodo.getDato().getCliente().getCategoria() == Categoria.Zafiro) {
//                nuevoNodo.setNext(frente);
//                frente = nuevoNodo;
//            } else if (nuevoNodo.getDato().getCliente().getCategoria() == Categoria.Oro) {
//                while (aux.getDato() != null && aux.getDato().getCliente().getCategoria() == Categoria.Zafiro) {
//                    aux = aux.getNext();
//                }
//                ultimo.setNext(nuevoNodo);
//                ultimo = nuevoNodo;
//
//            } else if (nuevoNodo.getDato().getCliente().getCategoria() == Categoria.Plata) {
//                while (aux.getDato() != null && aux.getDato().getCliente().getCategoria() != Categoria.Plata) {
//                    aux = aux.getNext();
//                }
//                ultimo.setNext(nuevoNodo);
//                ultimo = nuevoNodo;
//
//            } else {
//                //Toma el último nodo y le setea como nodo de atrás al nuevo nodo
//                ultimo.setNext(nuevoNodo);
//            //Define como último al nuevo nodo
//                ultimo = nuevoNodo;
//            }
            ultimo.setAtras(nuevoNodo);
            //Define como último al nuevo nodo
            ultimo = nuevoNodo;
        }
        largo++;
    }

    //Primero necesito acceder a los vehículos para tomar el número de placa y asignarlo a la solicitud
    //Segundo hay que validar si los parametros de la solicitud cumplen con un vehiculo y priorizar este
    //Se pasa la placa a la solicitud, se cambia el estado del vehículo a asignado
    //Se cambia la solicitud a estado procesada
    //Se debe calcular el monto del alquiler  con el monto diario por la cantidad de días por el 13%
    //El monto tiene que quedar en la solicitud
    //Si el monto es mayor a 70 reds sube la categoría
    //Si no hay vehículos queda como rechazada
    public void atiende(ListaVehiculo listaGlobal, ListaVehiculo listaVehiculoAsignado, ColaSolicitudes colaAtendida) {
        if (frente != null) {
            NodoSolicitud aux = frente;
            colaAtendida.encola(aux);
            if (listaGlobal.getCabeza() == null) {
                aux.getDato().setEstado(EstadoSolicitud.Rechazada);
                JOptionPane.showMessageDialog(null, "No hay vehículos, esta"
                        + " solicitud se coloca como rechazada");
            } else {
                Vehiculo extraido = listaGlobal.getCabeza().getDato();
                extraido.setEstado(EstadoVehiculo.Alquilado);
                listaVehiculoAsignado.inserta(extraido);
                listaGlobal.extrae(listaGlobal.getCabeza().getDato().getNumPlaca());

                aux.getDato().setMontoTotal(Math.round((extraido.getPrecioDia() * aux.getDato().getCantDias()) * 1.13));
                aux.getDato().ajustarCategoriaMonto();
                System.out.println(aux.getDato().getMontoTotal());
                //Se usa el auxiliar para poder acceder posteriormente al frente
                if (aux != null) {
                    //Esta línea pasa el nodo de frente al siguiente en la cola
                    aux.getDato().setPlacaVehiculo(extraido.getNumPlaca());
                    aux.getDato().setEstado(EstadoSolicitud.Procesada);
                    System.out.println(aux.getDato().getEstado());
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

//Este método le devuelve el nodo que sale de la cola al usuario ya que 
        //si esto no se hace el nodo se pierde se utiliza normalmente para 
        //imprimirlo por ejemplo
        largo--;
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
