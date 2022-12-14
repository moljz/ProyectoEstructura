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
        /* G;Esto va a dar error porque ahora categoría es un enum entonces hay que 
        pasarle un obj de tipo enum creo */
        ListaCliente listaPrueba = new ListaCliente();
        Cliente a = new Cliente("11111", "Jose Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Bronce);
        Cliente b = new Cliente("55555", "Luis Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Oro);
        Cliente c = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Plata);
        Cliente d = new Cliente("33333", "Daniela Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Zafiro);
        Cliente e = new Cliente("44444", "Mario Fernandez Herrera", "19/02/2022", "1234@hotmail.com", Categoria.Bronce);
        
   
        listaPrueba.inserta(a);
        listaPrueba.inserta(b);
        listaPrueba.inserta(c);
        listaPrueba.inserta(d);
        listaPrueba.inserta(e);
        
        //System.out.println(listaPrueba);
        System.out.println(listaPrueba.existe("3444"));
        listaPrueba.modifica(e);
        System.out.println(listaPrueba);
        listaPrueba.elimina("33333");
        System.out.println(listaPrueba);
        Cliente f = new Cliente("22222", "Francisco Fernandez Herrera", "19/02/2022", "asasd@hotmail.com", Categoria.Plata);
        listaPrueba.inserta(f);
        System.out.println(listaPrueba);
    }
    
}
