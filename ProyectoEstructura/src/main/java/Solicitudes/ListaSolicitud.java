package Solicitudes;

import Cliente.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class ListaSolicitud {

    private Nodo cabeza;

    public void inserta(Solicitud s) {
        if (cabeza == null) { //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new Nodo(s);
        } else if (cabeza.getNext() == null) {
            cabeza.setNext(new Nodo(s));
        } else {
            Nodo aux = (Nodo) cabeza;
            Nodo temp = new Nodo(s);//Creo temp para crear el nodo p 
            temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
            aux.setNext(temp); //Enlazo el siguiente de aux al temp 
        }
    }

    //Molina: Se coloca para buscar por modelo mientras se termina de definir
    public boolean existe(String modelo) {
        boolean esta = false; //Busca en la lista y retorna true si un

        if (cabeza != null) {
            //Si hay algo en la lista busca
            Nodo aux = (Nodo) cabeza;
            //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && aux.getDato().getModelo()!= modelo) {
                aux = aux.getNext(); //avanzo en la lista 
            }
            esta = (aux != null && aux.getDato().getModelo() == modelo);
        }
        return esta;
    }

    public void modifica(Solicitud s) {
        if (cabeza != null) {
            //Si hay algo en la lista buscamos
            Nodo aux = cabeza; //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && aux.getDato().getModelo()!= s.getModelo()) {
                aux = aux.getNext(); //avanzo en la lista 
            }//Si lo encuentra hago el cambio de datos
            if (aux != null && aux.getDato().getModelo()== s.getModelo()) {
                aux.getDato().setAno(s.getAno());
                aux.getDato().setCantDias(s.getCantDias());
                aux.getDato().setEstado(s.getEstado());
                aux.getDato().setExtras(s.getExtras());
                aux.getDato().setMarca(s.getMarca());
                aux.getDato().setMinPasajeros(s.getMinPasajeros());              
            }
        }

    }

    public void elimina(String Modelo) {

        if (cabeza != null) {//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getModelo() == Modelo) {
                cabeza = cabeza.getNext();
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            } else {
                Nodo aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux.getNext() != null && aux.getNext().getDato().getModelo()!= Modelo) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getModelo()== Modelo) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
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
