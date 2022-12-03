
package Vehiculo;

/**
 *
 * @author Juan Carlos
 * @author Gabriela Jimenez 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hola, este es el proyecto");
        
         Lista laLista = new Lista();
        //Llamamos al método inserta y como este pide un obj de tipo P tenemos que 
        //crear un nuevo obj p y le pasamos los parámetros que este pide 
        laLista.inserta(new Vehiculo(1990, "Nissan", "X312", "98A021", "Azul", 5, "Diesel", 5000, 1200, "Ventana eléctrica"));
        laLista.inserta(new Vehiculo(2000, "Nissan", "X312", "971231", "Rojo", 5, "Diesel", 5000, 1200, "Ventana eléctrica"));
        laLista.inserta(new Vehiculo(2010, "Nissan", "X312", "9DASD2", "Amarillo", 5, "Diesel", 5000, 1200, "Ventana eléctrica"));
        
        //laLista.inserta();
        System.out.print(laLista);
        System.out.println(laLista.existe("971231"));
        laLista.modifica( new Vehiculo(1800, "Subaru", "X312", "9DASD2", "Amarillo", 5, "Diesel", 5000, 1200, "Ventana eléctrica"));
        System.out.println(laLista);
        laLista.elimina("971231");
        System.out.println(laLista);
    
}
}