
package Solicitudes;

/**
 *
 * @author Maria Gabriela
 */
public class Pila {
    Solicitud cima;
    int largo;

    public Pila() {
        //Es un objeto por eso se inicializa en null, cuando la cima deja de 
        //ser nula se crea una pila
        this.cima = null;
        //Inicia en 0 porque no tengo nodos en la pila
        this.largo = 0;
    }

    //Este método valida si la pila está o no vacía
    public boolean vacia() {
        return cima == null;
    }

    public int tamanio() {
        return this.largo;
    }

    public void push(Object valor) {
        //Crea un nodo vacío
        Nodo newNode = new Nodo();
        //Se utiliza para definir el valor que se asigna si es plato o vaso
        if (valor instanceof Vaso) {
            //Un vaso asigna el valor a vaso y deja null plato
            newNode.setPlato(null);
            newNode.setVaso((Vaso) valor);
        } else {
            //Un plato asigna el valor a plato y deja null el vaso
            newNode.setPlato((Plato) valor);
            newNode.setVaso(null);
        }
        //Valida si la pila está vacia
        if (this.vacia()) { 
            //Asigna el nodo como cima porque no hay otro
            this.cima = newNode; 
        } else {
            //Referencia el nodo que está debajo asignando la antigua cima
            newNode.setSiguiente(this.cima);
            //Mueve los cubiertos entre los trastes y las distintas cimas
            moverCubiertos(newNode, this.cima);
            //Asigna el nuevo nodo como una nueva cima
            this.cima = newNode; 
        }
        //Incrementa el tamaño de la pila
        this.largo++; 
    }

    //El sistema solo contempla nodos bajo la cima por lo que no importa si 
    //está asignado si está sobre la cima no se toma en cuenta
    public void pop() {
        //Si la pila está vacía no tiene sentido hacer un cambio
        //!variable es equivalente a un not
        if (!vacia()) {
            //Se encarga de mover los cubiertos a la nueva cima
            quitarCubiertos(this.cima, this.cima.getSiguiente());
            //Asigna como primer nodo el siguiente en la pila
            this.cima = this.cima.getSiguiente();
            this.largo--; //Decrementa el tamaño de la pila
        }
    }

    //Busca un nodo de acuerdo a su valor en la pila
    public boolean search(Object reference) {
        //Crea una copia de la pila para no modificar la pila original y 
        //eliminar nodos
        Nodo aux = cima;
        //Valida si el elemento a buscar existe
        boolean exist = false;
        //Recorre la pila hasta el nodo o hasta el final de la pila
        while (exist != true && aux != null) {
            //Compara si el valor es igual al de la referencia
            if (reference == aux.getPlato() || reference == aux.getVaso()) {
                //Cambia el valor de la bandera
                exist = true;
            } else {
                //Acanza al siguiente nodo
                aux = aux.getSiguiente();
            }
        }
        //Retorna el balor de la bandera
        return exist;
    }

    public void listar() {
        //Crea una copia de la pila
        Nodo aux = cima;
        //Recorre la pila hasta el último nodo
        while (aux != null) {
            if (aux.getPlato() instanceof Plato) {
                //\t es para poner un simbolo en un string
                System.out.println("|\t" + aux.getPlato() + "\t|");
                System.out.println("---------------------------------");
                aux = aux.getSiguiente();
            } else {
                //\t es para poner un simbolo en un string
                System.out.println("|\t" + aux.getVaso() + "\t|");
                System.out.println("---------------------------------");
                aux = aux.getSiguiente();
            }
        }

    }

    
}
