package Solicitudes;

/**
 *
 * @author Juan Carlos
 */
public class Cola {
        
    //Estos dos nodos comienzan como nulos
    private Nodo frente; 
    private Nodo ultimo;
    private int largo; //Lleva el tamaño de la cola

    //No es necesario ponerlo
    public Cola() {
    }
    
    public void encola(Nodo nuevoNodo){
        if (frente == null) { //Indica que la cola está vacía
            //Esto define al primer nodo como frente y último al no haber más
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            //Toma el último nodo y le setea como nodo de atrás al nuevo nodo
            ultimo.setAtras(nuevoNodo);
            //Define como último al nuevo nodo
            ultimo = nuevoNodo;
        }
        largo++;
    }
    
    public Nodo atiende(){
        //Se usa el auxiliar para poder acceder posteriormente al frente
        Nodo aux = frente;
        if (frente != null) {
            //Esta línea pasa el nodo de frente al siguiente en la cola
            frente = frente.getAtras();
            //Quita la relación con el nodo de atrás ya que define al de atrás 
            //como nulo
            aux.setAtras(null);
            largo--;
        }
        //Este método le devuelve el nodo que sale de la cola al usuario ya que 
        //si esto no se hace el nodo se pierde se utiliza normalmente para 
        //imprimirlo por ejemplo
        return aux;
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = frente;
        while(aux != null){
            //Cuando se sobreescribe el método ToString al pasar el objeto 
            //completo el automáticamente va a obtener el valor
            s+= aux + "\n";
            aux = aux.getAtras();
        }
        return s;
    }
    
    
    
}
