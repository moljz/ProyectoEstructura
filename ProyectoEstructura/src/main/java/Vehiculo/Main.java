
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
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        laLista.inserta(new Vehiculo());
        //laLista.inserta();
        System.out.print(laLista);
     
    
}
}