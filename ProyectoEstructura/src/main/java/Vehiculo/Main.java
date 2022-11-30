
package Vehiculo;

/**
 *
 * @author Juan Carlos
 * @author Gabriela Jimenez 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hola, este es el proyecto");
        
        
         Cola cola1 = new Cola();

        cola1.encola(new Nodo(new Vehiculo()));
        cola1.encola(new Nodo(new Vehiculo()));
        cola1.encola(new Nodo(new Vehiculo()));
        cola1.encola(new Nodo(new Vehiculo()));
        cola1.encola(new Nodo(new Vehiculo()));
        cola1.encola(new Nodo(new Vehiculo()));

        System.out.println(cola1);
    }
    
}
