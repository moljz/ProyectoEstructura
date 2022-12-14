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
            while (aux != null && !aux.getDato().getCedula().equals(Cedula)) {
                aux = aux.getNext(); //avanzo en la lista 
            }
            esta = (aux != null && aux.getDato().getCedula().equals(Cedula));
        }
        return esta;
    }

    public void buscarPorCedula(String Cedula) {
        if (existe(Cedula)) {
            if (cabeza != null) {
                //Si hay algo en la lista busca
                NodoCliente aux = (NodoCliente) cabeza;
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux != null && !aux.getDato().getCedula().equals(Cedula)) {
                    aux = aux.getNext(); //avanzo en la lista 
                }
                System.out.println(aux.imprimirDatos() + "\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra la cedula");
        }

    }

    //Esto solo se ejecuta correctamente si la cedula ya existe
    public Cliente traerPersonaCedula(String Cedula) {
        //Si existe
        if (existe(Cedula)) {
            if (cabeza != null) {
                //Si hay algo en la lista busca
                NodoCliente aux = (NodoCliente) cabeza;
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux != null && !aux.getDato().getCedula().equals(Cedula)) {
                    aux = aux.getNext(); //avanzo en la lista 
                }
                //Regresa el cliente a la solicitud
                return aux.getDato();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta cedula no está registrada");
        }
        return null;
    }

    public void modificaPorCedula() {
        //Muestra el mensaje para solicitar datos
        JOptionPane.showMessageDialog(null, "Por favor ingrese la cédula a"
                + " modificar seguida de los datos correspondientes.");
        //Crea la instancia para el cambio de datos
        Cliente nuevoCliente = new Cliente();
        //Hace la asignación para validar si la cédula existe
        String Cedula = nuevoCliente.getCedula();
        //Verifica si la cédula existe
        if (existe(Cedula)) {

            if (cabeza != null) {
                //Si hay algo en la lista busca
                NodoCliente aux = (NodoCliente) cabeza;
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux != null && !aux.getDato().getCedula().equals(Cedula)) {
                    aux = aux.getNext(); //avanzo en la lista 
                }
                //Cambio los datos a excepción de la cédula de acuerdo a lo 
                //indicado
                aux.getDato().setCategoria(nuevoCliente.getCategoria());
                aux.getDato().setCorreo(nuevoCliente.getCorreo());
                aux.getDato().setFechaNac(nuevoCliente.getFechaNac());
                aux.getDato().setNomCompleto(nuevoCliente.getNomCompleto());
            }
        } else {
            //Si no está registrada se muestra el mensaje
            JOptionPane
                    .showMessageDialog(null, "Esta cédula no está registrada");
        }

    }

    public void elimina(String cedula) {

        if (cabeza != null) {//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getCedula().equals(cedula)) {
                cabeza = cabeza.getNext();
                JOptionPane.showMessageDialog(null, "Usuario eliminado"
                        + " con exito");
            } else {
                NodoCliente aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux.getNext() != null && !aux.getNext().getDato().getCedula().equals(cedula)) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getCedula().equals(cedula)) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este usuario no está registrado");
        }
    }

    @Override
    public String toString() {
        NodoCliente aux = (NodoCliente) cabeza;
        String s = "Estos son los clientes registrados:\n";
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }
}
