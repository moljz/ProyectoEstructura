package Vehiculo;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela
 */
//Molina: Consultar al profe si las estructuras están limitadas a las que indica 
//el enunciado o si se puede usar cualquiera de las vistas en el curso ya que 
//de ser limitado es necesario actualizar esta lista a circular
//Gabriela:Como hablamos,el profe me puso en el msj que las vistas en clase 
//entonces todo gucci :) 
public class ListaVehiculo {

    //Atributos 
    private NodoVehiculo cabeza;

    public NodoVehiculo getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoVehiculo cabeza) {
        this.cabeza = cabeza;
    }

    //Molina: La lista inserta los elementos en el orden deseado; sin embargo,
    //duplica el primer elemento que se ingresa en la lista por lo que es necesario 
    //solventarlo para darlo por corregido
    //Gabriela: Creo que ya habíamos solucionado esto de la lista verdad ?
    public void inserta(Vehiculo v) {
        if (cabeza == null) { //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new NodoVehiculo(v);
        } else if (v.getAno() < cabeza.getDato().getAno()) {//Sí existe un nodo 
            //adentro y el nodo a agregar tiene un id menor al nodo que ya existe 
            NodoVehiculo aux = new NodoVehiculo(v); //Creo el nodo aux con v de parámetro
            aux.setNext(cabeza);   //Coloco aux a la izq de la cabeza 
            cabeza = aux;     //Cabeza ahora hace referencia al nuevo elemento 
            //Este else if funciona si la lista ya tiene un solo elemento 
        } else if (cabeza.getNext() == null) {
            //Caso:3 Si debo insertar a la derecha de la cabeza valido que no 
            //haya nada ahí 
            cabeza.setNext(new NodoVehiculo(v));
        } else {
            //Este método lo usamos para insertar al medio y al final de la lista 
            NodoVehiculo aux = cabeza;
            while (aux.getNext() != null && aux.getNext().getDato().getAno() < v.getAno()) {
                aux = aux.getNext();
            }
            //ya ubicado se procede a realizar los enlaces (medio) 
            NodoVehiculo temp = new NodoVehiculo(v);//Creo temp para crear el nodo p 
            temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
            aux.setNext(temp); //Enlazo el siguiente de aux al temp 
        }

    }

    //Molina: Funcional
    //Consulta vehículo por numero de placa 
    public boolean existe(String NumPlaca) {
        boolean esta = false; //Busca en la lista y retorna true si un
        //Vehiculo tiene ese número de placa 
        if (cabeza != null) {
            //Si hay algo en la lista busca
            NodoVehiculo aux = cabeza;
            //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && !aux.getDato().getNumPlaca().equals(NumPlaca)) {
                aux = aux.getNext(); //avanzo en la lista 
            }
            esta = (aux != null && aux.getDato().getNumPlaca().equals(NumPlaca));
        }
        return esta;
    }

    public void buscarPorPlaca(String NumPlaca) {
        if (existe(NumPlaca)) {
            //Vehiculo tiene ese número de placa 
            if (cabeza != null) {
                //Si hay algo en la lista busca
                NodoVehiculo aux = cabeza;
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux != null && !aux.getDato().getNumPlaca().equals(NumPlaca)) {
                    aux = aux.getNext(); //avanzo en la lista 
                }
                System.out.println(aux);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe esa placa.");
        }

    }

    public void modificaPorPlaca() {
        //Muestra el mensaje para solicitar datos
        JOptionPane.showMessageDialog(null, "Por favor ingrese la placa a"
                + " modificar seguida de los datos correspondientes.");
        //Crea la instancia para el cambio de datos
        Vehiculo nuevoVehiculo = new Vehiculo();
        //Hace la asignación para validar si la cédula existe
        String Placa = nuevoVehiculo.getNumPlaca();
        //Verifica si la cédula existe
        if (existe(Placa)) {

            if (cabeza != null) {
                //Si hay algo en la lista busca
                NodoVehiculo aux = (NodoVehiculo) cabeza;
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux != null && !aux.getDato().getNumPlaca().equals(Placa)) {
                    aux = aux.getNext(); //avanzo en la lista 
                }
                //Cambio los datos a excepción de la cédula de acuerdo a lo 
                //indicado
                aux.getDato().setAno(nuevoVehiculo.getAno());
                aux.getDato().setMarca(nuevoVehiculo.getMarca());
                aux.getDato().setModelo(nuevoVehiculo.getModelo());
                aux.getDato().setColor(nuevoVehiculo.getColor());
                aux.getDato().setNumPasajeros(nuevoVehiculo.getNumPasajeros());
                aux.getDato().setCombustible(nuevoVehiculo.getCombustible());
                aux.getDato().setEstado(nuevoVehiculo.getEstado());
                aux.getDato().setPrecioDia(nuevoVehiculo.getPrecioDia());
                aux.getDato().setCilindrada(nuevoVehiculo.getCilindrada());
                aux.getDato().setExtras(nuevoVehiculo.getExtras());
            }
        } else {
            //Si no está registrada se muestra el mensaje
            JOptionPane
                    .showMessageDialog(null, "Esta placa no está registrada");
        }

    }

    //Molina: Funcional
    //Busca un vehículo por NumPlaca y lo elimina 
    public void elimina(String NumPlaca) {
        if (existe(NumPlaca)) {
            //Buscamos el vehículo por num plac, si lo encuentra lo elimina
            if (cabeza != null && cabeza.getDato().isAlquilado() != true) {//Si hay algo en la lista buscamos 
                if (cabeza.getDato().getNumPlaca().equals(NumPlaca)) {
                    cabeza = cabeza.getNext();
                    JOptionPane.showMessageDialog(null, "Se eliminó el vehículo con éxito");
                } else {
                    NodoVehiculo aux = cabeza;//Utilizo aux como indice 
                    //Mientras no se acabe la lista y el elemento de la lista sea 
                    //diferente del buscado
                    while (aux.getNext() != null && !aux.getNext().getDato().getNumPlaca().equals(NumPlaca)) {
                        aux = aux.getNext();
                    }//Avanzo en la lista
                    //Si es el de adelante lo borro
                    if (aux.getNext() != null && aux.getNext().getDato().getNumPlaca().equals(NumPlaca)) {
                        aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                    }
                    JOptionPane.showMessageDialog(null, "Se eliminó el vehículo con éxito");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este vehículo no se puede eliminar debido a que ha sido alquilado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Esta placa no está registrada");
        }

    }

    public Vehiculo extrae(String NumPlaca) {
        Vehiculo v = null;
        //si una persona tiene el id, lo extrae (eliminando y retornando)
        if (cabeza != null) { //Si hay algo en la lista buscaré
            if (cabeza.getDato().getNumPlaca().equals(NumPlaca)) {
                cabeza = cabeza.getNext();
            } else {
                NodoVehiculo aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext() != null && !aux.getNext().getDato().getNumPlaca().equals(NumPlaca)) {
                    aux = aux.getNext();
                    //avanzo en la lista
                }
                // Si es el de adelante... quardo la persona y lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getNumPlaca().equals(NumPlaca)) {
                    v = aux.getNext().getDato();
                    aux.setNext(aux.getNext().getNext());//cambio las referencias
                }
            }
        }
        return v;
    }

    @Override
    public String toString() {
        NodoVehiculo aux = cabeza;
        String s = "Lista: ";
        while (aux != null) {
            s += aux + "\n ";
            aux = aux.getNext();
        }
        return s;
    }

}
