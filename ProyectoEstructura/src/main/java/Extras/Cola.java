
package Extras;

/**
 *
 * @author Maria Gabriela
 */
public class Cola {
    private Nodo frente;
    private Nodo ultimo;

    public Cola() {
    }
    
    public void encola(Nodo extra) {
        if (frente == null) {  // significa que la cola esta vacia
            frente = extra;
            ultimo = extra;
        } else {
            ultimo.setAtras(extra);
            ultimo = extra;
        }
    }

    //Molina: De momento no se usa
    public Nodo atiende() {
        Nodo aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }

    //Molina: De momento no se usa
    public boolean search(String reference) {
        //Crea una copia de la pila para no modificar la pila original y 
        //eliminar nodos
        Nodo aux = frente;
        //Valida si el elemento a buscar existe
        boolean exist = false;
        //Recorre la pila hasta el nodo o hasta el final de la pila
        while (exist != true && aux != null) {
            //Compara si el valor es igual al de la referencia
            if (reference == aux.getDato()) {
                //Cambia el valor de la bandera
                exist = true;
            } else {
                //Acanza al siguiente nodo
                aux = aux.getAtras();
            }
        }
        //Retorna el balor de la bandera
        return exist;
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = frente;
        while (aux != null) {
            s += aux + ", ";
            aux = aux.getAtras();
        }
        return s;
    }
}
