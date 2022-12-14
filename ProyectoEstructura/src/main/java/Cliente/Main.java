package Cliente;

import Solicitudes.ColaSolicitudes;
import Solicitudes.NodoSolicitud;
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
//        Cliente a = new Cliente("11111", "Jose Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Bronce);
//        Cliente b = new Cliente("55555", "Luis Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Oro);
//        Cliente c = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Plata);
//        Cliente d = new Cliente("33333", "Daniela Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Zafiro);
//        Cliente e = new Cliente("44444", "Mario Fernandez Herrera", "19/02/2022", "1234@hotmail.com", Categoria.Bronce);
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite la "
                    + "opción que desea ejecutar:\n1- Registrar cliente \n"
                    + "2- Modificar información del cliente\n3- Eliminar cliente"
                    + " \n4- Consultar cliente \n5- Registrar vehículo "
                    + "\n6- Modificar vehículo \n7- Eliminar vehículo "
                    + "\n8- Consultar vehículo \n9- Registrar solicitud \n10- Atender solicitud \n11- Salir"));
            switch (opcion) {
                case 1:
                    Cliente Insertando = new Cliente();
                    listaCliente.inserta(Insertando);
                    //listaCliente.buscarPorCedula("1");
                    break;

                case 2:
                    listaCliente.modificaPorCedula();
                    //listaCliente.buscarPorCedula("1");
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
                    System.out.println(listaVehiculo);
                    break;
                case 6:
                    listaVehiculo.modificaPorPlaca();
                    System.out.println(listaVehiculo);
                    break;
                case 7:
                    listaVehiculo.elimina(JOptionPane.showInputDialog(null,
                            "Indique la placa que desea eliminar"));
                    System.out.println(listaVehiculo);
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
                    colaSolicitudes.encola(new NodoSolicitud(new Solicitud(listaCliente)));
                    System.out.println(colaSolicitudes);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                case 10:
                    colaSolicitudes.atiende(listaVehiculo, listaVehiculosAsignado, colaAtendida);
                    System.out.println("Cola original");
                    System.out.println(colaSolicitudes);
                    System.out.println("Cola atendida");
                    System.out.println(colaAtendida);
                    System.out.println("Lista de vehiculos original");
                    System.out.println(listaVehiculo);
                    System.out.println("Lista de vehiculos atendida");
                    System.out.println(listaVehiculosAsignado);
                    break;
            }
        } while (opcion != 11);

    }
}

/*
   
        listaPrueba.inserta(a);
        listaPrueba.inserta(b);
        listaPrueba.inserta(c);
        listaPrueba.inserta(d);
        listaPrueba.inserta(e);
        
        //System.out.println(listaPrueba);
        System.out.println(listaPrueba.existe("3444"));
        listaPrueba.modifica(e);
        System.out.println(listaPrueba);
        listaPrueba.elimina("33333");
        System.out.println(listaPrueba);
        Cliente f = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Plata);
        listaPrueba.inserta(f);
        System.out.println(listaPrueba);
    }
 */
