package Cliente;

import Solicitudes.ColaSolicitudes;
import Solicitudes.NodoSolicitud;
import Solicitudes.PilaSolicitud;
import Solicitudes.Solicitud;
import Vehiculo.ListaVehiculo;
import Vehiculo.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCliente listaCliente = new ListaCliente();
        ListaVehiculo listaVehiculo = new ListaVehiculo();
        ColaSolicitudes colaSolicitudes = new ColaSolicitudes();
        ColaSolicitudes colaAtendida = new ColaSolicitudes();
        ListaVehiculo listaVehiculosAsignado = new ListaVehiculo();
        PilaSolicitud pilaOriginal = new PilaSolicitud();
        PilaSolicitud pilaAtendida = new PilaSolicitud();

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite la "
                    + "opción que desea ejecutar:\n1- Registrar cliente \n"
                    + "2- Modificar información del cliente\n3- Eliminar cliente"
                    + " \n4- Consultar cliente \n5- Registrar vehículo "
                    + "\n6- Modificar vehículo \n7- Eliminar vehículo "
                    + "\n8- Consultar vehículo \n9- Registrar solicitud "
                    + "\n10- Atender solicitud \n11- Consultar solicitudes "
                    + "\n12- Devolver vehiculo \n13- Salir"));
            switch (opcion) {
                case 1:
                    Cliente Insertando = new Cliente();
                    listaCliente.inserta(Insertando);
                    break;

                case 2:
                    listaCliente.modificaPorCedula();
                    break;
                case 3:
                    listaCliente.elimina(JOptionPane.showInputDialog(null,
                            "Indique la cédula que desea eliminar"));
                    break;
                case 4:
                    System.out.println(listaCliente);
                    listaCliente.buscarPorCedula(JOptionPane.
                            showInputDialog("Indique la cédula que desea"
                                    + " visualizar"));
                    break;
                case 5:
                    listaVehiculo.inserta(new Vehiculo());
                    break;
                case 6:
                    listaVehiculo.modificaPorPlaca();
                    break;
                case 7:
                    listaVehiculo.elimina(JOptionPane.showInputDialog(null,
                            "Indique la placa que desea eliminar"));
                    break;
                case 8:
                    int opcion2 = 0;

                    do {
                        opcion2 = Integer.parseInt(JOptionPane
                                .showInputDialog("Seleccione la manera en la que"
                                        + " desea consultar:\n1- Ver todos los"
                                        + " vehículos.\n2- Consultar por placa.\n3-"
                                        + " Salir"));
                        switch (opcion2) {
                            case 1:
                                System.out.println(listaVehiculo);
                                break;
                            case 2:
                                listaVehiculo.buscarPorPlaca(JOptionPane
                                        .showInputDialog("Indique la placa que"
                                                + " desea visualizar"));
                                break;
                        }
                    } while (opcion2 != 3);
                    break;
                case 9:
                    try {
                    Solicitud a = new Solicitud(listaCliente);
                    colaSolicitudes.encola(new NodoSolicitud(a));
                    pilaOriginal.push(a);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    break;
                }
                case 10:
                    colaSolicitudes.atiende(listaVehiculo,
                            listaVehiculosAsignado, colaAtendida, pilaAtendida);
                    break;
                case 11:
                    int opcion3 = 0;

                    do {
                        opcion3 = Integer.parseInt(JOptionPane
                                .showInputDialog("Seleccione la manera en la que"
                                        + " desea consultar:\n1- Consultar"
                                        + " solicitudes registradas.\n2-"
                                        + " Consultar otros estados.\n3-"
                                        + " Salir"));
                        switch (opcion3) {
                            case 1:
                                pilaOriginal.listar();
                                break;
                            case 2:
                                pilaAtendida.listar();
                                break;
                        }
                    } while (opcion3 != 3);
                    break;
                case 12:
                    colaAtendida.devolucion(JOptionPane
                            .showInputDialog("Ingrese la cédula"),
                            JOptionPane.showInputDialog("Ingrese la placa del"
                                    + " vehículo"), JOptionPane
                                    .showInputDialog("Indique el estado"
                                            + " en que vuelve el "
                                            + "vehíoculo"),
                            colaAtendida, listaVehiculosAsignado);
                    break;
            }

        } while (opcion != 13);

    }
}
