
package Proyecto;

/**
 *
 * @author Juan Carlos
 * @author Gabriela Jimenez 
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hola, este es el proyecto");
        
        
         Cola cola1 = new Cola();

        cola1.encola(new Nodo(1));
        cola1.encola(new Nodo(2));
        cola1.encola(new Nodo(3));
        cola1.encola(new Nodo(4));
        cola1.encola(new Nodo(5));
        cola1.encola(new Nodo(6));

        System.out.println(cola1);
    }
    
}
