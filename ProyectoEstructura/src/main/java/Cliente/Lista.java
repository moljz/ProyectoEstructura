package Cliente;

/**
 *
 * @author jafet
 */
//Molina: Consultar al profe si las estructuras están limitadas a las que indica 
//el enunciado o si se puede usar cualquiera de las vistas en el curso ya que 
//de ser limitado es necesario actualizar esta lista a circular
public class Lista {

    private Nodo cabeza;

    //Molina: Hay que revisar el funcionamiento de este método ya que si se 
    //insertan 4 clientes (1, 2, 3, 4) el resultado del output es 
    //1, 4, 3, 2, 1, 1 generando dos copias adicionales del primer nodo y 
    //colocando los otros al revés
    
    public void inserta(Cliente c) {
        if (cabeza == null) { //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new Nodo(c);
            Nodo aux = new Nodo(c);
            aux.setNext(cabeza);
            cabeza = aux;
        } else if (cabeza.getNext() == null) {
            cabeza.setNext(new Nodo(c));

        }
        Nodo aux = (Nodo) cabeza;
        Nodo temp = new Nodo(c);//Creo temp para crear el nodo p 
        temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
        aux.setNext(temp); //Enlazo el siguiente de aux al temp 
    }

    //Molina: Funcional
    public boolean existe(String Cedula) {
        boolean esta = false; //Busca en la lista y retorna true si un
        //Vehiculo tiene ese número de placa 
        if (cabeza != null) {
            //Si hay algo en la lista busca
            Nodo aux = (Nodo) cabeza;
            //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && aux.getDato().getCedula() != Cedula) {
                aux = aux.getNext(); //avanzo en la lista 
            }
            esta = (aux != null && aux.getDato().getCedula() == Cedula);
        }
        return esta;
    }

    //Molina: Se debe ampliar el método para que permita editar todos los datos 
    //excepto la cedula del usuario ya que actualmente solo cambia el correo
    public void modifica(Cliente c) {
        //Busca si hay un vehículo con ese numPlaca y modifica sus datos excepto
        //el número de Placa 
        if (cabeza != null) {
            //Si hay algo en la lista buscamos
            Nodo aux = (Nodo) cabeza; //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            //Molina: Se ajusta el while de "aux != null && aux.getDato().getCedula() == c.getCedula()" 
            //a "aux != null && aux.getDato().getCedula() != c.getCedula()" ya 
            //que para avanzar la cédula debe ser distinta
            while (aux != null && aux.getDato().getCedula() != c.getCedula()) {
                aux = aux.getNext(); //avanzo en la lista 
            }//Si lo encuentra hago el cambio de datos
            if (aux != null && aux.getDato().getCedula() == c.getCedula()) {
                //Cambia la marca 
                aux.getDato().setCorreo(c.getCorreo());
            }

        }
    }

    //Molina: Hacer el método más transparente al usuario, con una salida o algo
    //que inidique que se eliminó el usuario o bien que no se encuentra
    public void elimina(String cedula) {
        //Buscamos el vehículo por num plac, si lo encuentra lo elimina
        if (cabeza != null) {//Si hay algo en la lista buscamos 
            //Molina: Se modifica el metodo de "cabeza.getDato().getCorreo() == cedula" 
            //a "cabeza.getDato().getCedula() == cedula" ya que compara el 
            //correo contra la cedula por lo que nunca lo va a encontrar
            if (cabeza.getDato().getCedula() == cedula) {
                cabeza = cabeza.getNext();
            } else {
                Nodo aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                //Molina: Se ajusta los get de las condicionales ya que comparan
                //el correo contra la cedula de manera que comparen cedulas
                while (aux.getNext() != null && aux.getNext().getDato().getCedula()!= cedula) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getCedula()== cedula) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
            }
        }
    }

    @Override
    public String toString() {
        Nodo aux = (Nodo) cabeza;
        String s = "Lista: ";
        while (aux != null) {
            s += aux + ", ";
            aux = aux.getNext();
        }
        return s;
    }
}
