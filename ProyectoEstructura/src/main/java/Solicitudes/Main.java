package Solicitudes;

/**
 *
 * @author Juan Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solicitud a = new Solicitud(15, 2, "Nissan", "X312", 2000, "Vidrio eléctrico", Estado.Registrada);
        Solicitud b = new Solicitud(15, 2, "Nissan", "X312", 1990, "Vidrio eléctrico", Estado.Registrada);
        Solicitud c = new Solicitud(15, 2, "Nissan", "X450", 2010, "Vidrio eléctrico", Estado.Registrada);
        Solicitud d = new Solicitud(15, 2, "Nissan", "P330", 2020, "Vidrio eléctrico", Estado.Registrada);
        
        Nodo Uno = new Nodo(a);
        Nodo Dos = new Nodo(b);
        Nodo Tres = new Nodo(c);
        Nodo Cuatro = new Nodo(d);
        
        Cola laCola = new Cola();
        laCola.encola(Uno);
        laCola.encola(Dos);
        laCola.encola(Tres);
        laCola.encola(Cuatro);
        
        System.out.println(laCola);
    }
    
}
