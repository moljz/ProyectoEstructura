package Vehiculo;

import Extras.Cola;

/**
 *
 * @author Juan Carlos
 * @author Gabriela Jimenez
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hola, este es el proyecto");

        ListaVehiculo laLista = new ListaVehiculo();

        laLista.inserta(new Vehiculo(1990, "Nissan", "X312", "98A021", "Azul", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        laLista.inserta(new Vehiculo(2000, "Nissan", "X312", "971231", "Rojo", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        laLista.inserta(new Vehiculo(2010, "Nissan", "X312", "9DASD2", "Amarillo", 5, "Diesel", EstadoVehiculo.Disponible, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));

        //laLista.inserta();
        System.out.print(laLista);
        System.out.println(laLista.existe("971231"));
        laLista.modifica(new Vehiculo(1800, "Subaru", "X312", "9DASD2", "Amarillo", 5, "Diesel", EstadoVehiculo.Alquilado, 5000, 1200, "Vidrio polarizado,Aire acondicionado,Luces LED"));
        //Esto se usa para reacomodar la lista una vez que se modifica un vehículo
        laLista.inserta(laLista.extrae("9DASD2"));
        System.out.println(laLista);
        laLista.elimina("971231");
        System.out.println(laLista);

    }
}
