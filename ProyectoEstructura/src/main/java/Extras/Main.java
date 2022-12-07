package Extras;

/**
 *
 * @author Juan Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola laCola = new Cola();
        laCola.encola(new Nodo("Vidrio polarizado"));
        laCola.encola(new Nodo("Aire acondicionado"));
        laCola.encola(new Nodo("Luces LED"));
        
        System.out.println(laCola);
    }
    
}
