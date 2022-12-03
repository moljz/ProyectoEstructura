package Cliente;

/**
 *
 * @author Juan Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente a = new Cliente("11111", "Jose Fernandez Herrera", 4, "asasd@hotmail.com", "Bronce");
        Cliente b = new Cliente("11111", "Luis Fernandez Herrera", 4, "asasd@hotmail.com", "Bronce");
        Cliente c = new Cliente("22222", "Francisco Fernandez Herrera", 4, "asasd@hotmail.com", "Bronce");
        Cliente d = new Cliente("33333", "Daniela Fernandez Herrera", 4, "asasd@hotmail.com", "Bronce");
        Cliente e = new Cliente("33333", "Mario Fernandez Herrera", 4, "1234@hotmail.com", "Plata");
        
        Lista listaPrueba = new Lista();
        listaPrueba.inserta(a);
        listaPrueba.inserta(b);
        listaPrueba.inserta(c);
        listaPrueba.inserta(d);
        
        //System.out.println(listaPrueba);
        System.out.println(listaPrueba.existe("3444"));
        listaPrueba.modifica(e);
        System.out.println(listaPrueba);
        listaPrueba.elimina("33333");
        System.out.println(listaPrueba);
    }
    
}
