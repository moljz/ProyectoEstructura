package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class ListaCliente {

    private NodoCliente cabeza;

    public void inserta(Cliente c) {
        if (existe(c.getCedula())) {
            JOptionPane.showMessageDialog(null, "la cedula agregada ya existe");

        } else {
            if (cabeza == null) { //Si la lista está vacía 
                //solo asignamos nuevo nodo 
                cabeza = new NodoCliente(c);
            } else if (cabeza.getNext() == null) {
                cabeza.setNext(new NodoCliente(c));

            } else {
                NodoCliente aux = (NodoCliente) cabeza;
                NodoCliente temp = new NodoCliente(c);//Creo temp para crear 
                //el nodo p 
                temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
                aux.setNext(temp); //Enlazo el siguiente de aux al temp 
            }
        }

    }

    //Molina: Funcional
    public boolean existe(String Cedula) {
        boolean esta = false; //Busca en la lista y retorna true si un

        if (cabeza != null) {
            //Si hay algo en la lista busca
            NodoCliente aux = (NodoCliente) cabeza;
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

    public void modifica(Cliente c) {
        if (cabeza != null) {
            //Si hay algo en la lista buscamos
            NodoCliente aux = cabeza; //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && aux.getDato().getCedula() != c.getCedula()) {
                aux = aux.getNext(); //avanzo en la lista 
            }//Si lo encuentra hago el cambio de datos
            if (aux != null && aux.getDato().getCedula() == c.getCedula()) {
                aux.getDato().setCategoria(c.getCategoria());
                aux.getDato().setCorreo(c.getCorreo());
                aux.getDato().setFechaNac(c.getFechaNac());
                aux.getDato().setNomCompleto(c.getNomCompleto());

            }
        }

    }


    public void elimina(String cedula) {

        if (cabeza != null) {//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getCedula() == cedula) {
                cabeza = cabeza.getNext();
                JOptionPane.showMessageDialog(null, "Usuario eliminado"
                        + " con exito");
            } else {
                NodoCliente aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux.getNext() != null && aux.getNext().getDato().getCedula() != cedula) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getCedula() == cedula) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            }
        }
    }

    @Override
    public String toString() {
        NodoCliente aux = (NodoCliente) cabeza;
        String s = "Lista: ";
        while (aux != null) {
            s += aux + ", ";
            aux = aux.getNext();
        }
        return s;
    }
}
