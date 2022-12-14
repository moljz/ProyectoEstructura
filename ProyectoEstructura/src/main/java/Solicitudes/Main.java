package Solicitudes;

import Cliente.Categoria;
import Cliente.Cliente;
import Cliente.ListaCliente;
import Vehiculo.ListaVehiculo;
import Vehiculo.Vehiculo;
import Vehiculo.EstadoVehiculo;

/**
 *
 * @author Juan Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cliente
        ListaCliente listaCliente = new ListaCliente();
        Cliente a = new Cliente("11111", "Jose Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Oro);
        Cliente b = new Cliente("55555", "Luis Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Oro);
        Cliente c = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Zafiro);
        Cliente d = new Cliente("33333", "Daniela Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Zafiro);
        Cliente e = new Cliente("44444", "Mario Fernandez Herrera", "19/02/2022", "1234@hotmail.com", Categoria.Bronce);
        
        listaCliente.inserta(a);
        listaCliente.inserta(b);
        listaCliente.inserta(c);
        listaCliente.inserta(d);
        listaCliente.inserta(e);
        
//        //System.out.println(listaCliente);
//        System.out.println(listaCliente.existe("3444"));
//        listaCliente.modifica(e);
//        System.out.println(listaCliente);
//        listaCliente.elimina("33333");
//        System.out.println(listaCliente);
//        Cliente f = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Plata);
//        listaCliente.inserta(f);
//        System.out.println(listaCliente);
        
        //Vehiculo
        ListaVehiculo listaVehiculo = new ListaVehiculo();

        listaVehiculo.inserta(new Vehiculo(1990, "Nissan", "X312", "98A021", "Azul", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        listaVehiculo.inserta(new Vehiculo(2000, "Nissan", "X312", "971231", "Rojo", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        listaVehiculo.inserta(new Vehiculo(2010, "Nissan", "X312", "9DASD2", "Amarillo", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));

        //laLista.inserta();
        System.out.print(listaVehiculo);
        System.out.println(listaVehiculo.existe("971231"));
        listaVehiculo.modifica(new Vehiculo(1800, "Subaru", "X312", "9DASD2", "Amarillo", 5, "Diesel", EstadoVehiculo.Alquilado, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        //Esto se usa para reacomodar la lista una vez que se modifica un vehículo
        System.out.println(listaVehiculo);
        listaVehiculo.inserta(listaVehiculo.extrae("9DASD2"));
        //System.out.println(listaVehiculo);
        //System.out.println(listaVehiculo);
        listaVehiculo.elimina("971231");
        System.out.println(listaVehiculo);
        
        //Solicitud
        Solicitud PrimeraSolicitud = new Solicitud("20 de diciembre", 15, 2, "Nissan", "X312", 2000, "Vidrio eléctrico", EstadoSolicitud.Registrada, a);
        Solicitud SegundaSolicitud = new Solicitud("21 de diciembre", 15, 2, "Nissan", "X312", 1990, "Vidrio eléctrico", EstadoSolicitud.Registrada, b);
        Solicitud TerceraSolicitud = new Solicitud("22 de diciembre", 15, 2, "Nissan", "X450", 2010, "Vidrio eléctrico", EstadoSolicitud.Registrada, c);
        Solicitud CuartaSolicitud = new Solicitud("23 de diciembre", 15, 2, "Nissan", "P330", 2020, "Vidrio eléctrico", EstadoSolicitud.Registrada, d);
        Solicitud QuintaSolicitud = new Solicitud("23 de diciembre", 15, 2, "Nissan", "P330", 2020, "Vidrio eléctrico", EstadoSolicitud.Registrada, e);
        
        NodoSolicitud Uno = new NodoSolicitud(PrimeraSolicitud);
        NodoSolicitud Dos = new NodoSolicitud(SegundaSolicitud);
        NodoSolicitud Tres = new NodoSolicitud(TerceraSolicitud);
        NodoSolicitud Cuatro = new NodoSolicitud(CuartaSolicitud);
        NodoSolicitud Cinco = new NodoSolicitud(QuintaSolicitud);
        
        Cola laCola = new Cola();
        laCola.encola(Uno);
        laCola.encola(Cinco);
        laCola.encola(Dos);
        laCola.encola(Tres);
        laCola.encola(Cuatro);
        
        laCola.atiende();
        
        System.out.println(laCola);
    }
    
}
