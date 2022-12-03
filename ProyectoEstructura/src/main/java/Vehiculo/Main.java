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

        Lista laLista = new Lista();
        Cola laCola = new Cola();
        
        //ESTE FRAGMENTO SEPARA UNA LISTA DE EXTRAS EN UN NODO CADA UNA DE ACUERDO A LA ,
        String extras = "Vidrio polarizado, Aire acondicionado, Luces LED";
        String[] detalle = new String[extras.length()];
        for (int i = 0; i < detalle.length; i++) {
            detalle = extras.split(",");
            laCola.encola(new Extras.Nodo(detalle[i]));
        }
        
//        laCola.encola(new Extras.Nodo("Aire acondicionado"));
//        laCola.encola(new Extras.Nodo("Luces LED"));
        //Llamamos al método inserta y como este pide un obj de tipo P tenemos que 
        //crear un nuevo obj p y le pasamos los parámetros que este pide 
        laLista.inserta(new Vehiculo(1990, "Nissan", "X312", "98A021", "Azul", 5, "Diesel", 5000, 1200, laCola));
        laLista.inserta(new Vehiculo(2000, "Nissan", "X312", "971231", "Rojo", 5, "Diesel", 5000, 1200, laCola));
        laLista.inserta(new Vehiculo(2010, "Nissan", "X312", "9DASD2", "Amarillo", 5, "Diesel", 5000, 1200, laCola));

        //laLista.inserta();
        System.out.print(laLista);
        System.out.println(laLista.existe("971231"));
        laLista.modifica(new Vehiculo(1800, "Subaru", "X312", "9DASD2", "Amarillo", 5, "Diesel", 5000, 1200, laCola));
        System.out.println(laLista);
        laLista.elimina("971231");
        System.out.println(laLista);

    }
}
