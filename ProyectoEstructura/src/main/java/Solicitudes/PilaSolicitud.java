package Solicitudes;

/**
 *
 * @author Maria Gabriela
 */
public class PilaSolicitud {

    NodoSolicitud cima;
    int largo;

    public PilaSolicitud() {
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

    public void push(Solicitud solicitud) {
        NodoSolicitud newNode = new NodoSolicitud(solicitud); //Crea un nodo vacío
       
        if (this.vacia()) { //Valida si la pila está vacia
            this.cima = newNode; //Asigna el nodo como cima porque no hay otro
        } else {
            newNode.setAtras(this.cima); //Referencia el nodo que está debajo 
            //asignando la antigua cima
            this.cima = newNode; //Asigna el nuevo nodo como una nueva cima
        }
        this.largo++; //Incrementa el tamaño de la pila
    }

    //El sistema solo contempla nodos bajo la cima por lo que no importa si 
    //está asignado si está sobre la cima no se toma en cuenta
    public void pop() {
        //Si la pila está vacía no tiene sentido hacer un cambio
        //!variable es equivalente a un not
        if (!vacia()) {
            //Se encarga de mover los cubiertos a la nueva cima
            //Asigna como primer nodo el siguiente en la pila
            this.cima = this.cima.getAtras();
            this.largo--; //Decrementa el tamaño de la pila
        }
    }

    //Busca un nodo de acuerdo a su valor en la pila
    public boolean buscarPorCedula(String cedula) {
        //Crea una copia de la pila para no modificar la pila original y 
        //eliminar nodos
        NodoSolicitud aux = cima;
        //Valida si el elemento a buscar existe
        boolean exist = false;
        //Recorre la pila hasta el nodo o hasta el final de la pila
        while (aux != null) {
            //Recorre la pila hasta el nodo o hasta el final de la pila
            while (exist != true && aux != null) {
                //Compara si el valor es igual al de la referencia
                if (cedula.equals(aux.getDato().getCliente().getCedula())) {
                    //Cambia el valor de la bandera
                    System.out.println(aux);
                    exist = true;
                } else {
                    //Acanza al siguiente nodo
                    aux = aux.getAtras();
                }
            }
        }
        //Retorna el balor de la bandera
        return exist;
    }

    public boolean buscarPorPlaca(String placa) {
        //Crea una copia de la pila para no modificar la pila original y 
        //eliminar nodos
        NodoSolicitud aux = cima;
        //Valida si el elemento a buscar existe
        boolean exist = false;
        //Recorre la pila hasta el nodo o hasta el final de la pila
        while (aux != null) {
            //Recorre la pila hasta el nodo o hasta el final de la pila
            while (exist != true && aux != null) {
                //Compara si el valor es igual al de la referencia
                if (placa.equals(aux.getDato().getPlacaVehiculo())) {
                    //Cambia el valor de la bandera
                    System.out.println(aux);
                    exist = true;
                } else {
                    //Acanza al siguiente nodo
                    aux = aux.getAtras();
                }
            }
        }
        //Retorna el balor de la bandera
        return exist;
    }

    public boolean buscarPorEstado(EstadoSolicitud estado) {
        //Crea una copia de la pila para no modificar la pila original y 
        //eliminar nodos
        NodoSolicitud aux = cima;
        boolean exist = false;
        while (aux != null) {
            //Recorre la pila hasta el nodo o hasta el final de la pila
            while (exist != true && aux != null) {
                //Compara si el valor es igual al de la referencia
                if (estado == aux.getDato().getEstado()) {
                    //Cambia el valor de la bandera
                    System.out.println(aux);
                    exist = true;
                } else {
                    //Acanza al siguiente nodo
                    aux = aux.getAtras();
                }
            }
        }
        //Valida si el elemento a buscar existe

        //Retorna el balor de la bandera
        return exist;
    }

    public void listar() {
        //Crea una copia de la pila
        NodoSolicitud aux = cima;
        //Recorre la pila hasta el último nodo
        while (aux != null) {
            //\t es para poner un simbolo en un string
            System.out.println("|\t" + aux + "\t|");
            System.out.println("-------------------");
            aux = aux.getAtras();
        }
    }

}
