package Solicitudes;

import Vehiculo.*;

/**
 *
 * @author Maria Gabriela
 */

public class ListaVehiculoAsignado {

    //Atributos 
    private NodoVehiculo cabeza;


    public void inserta(Vehiculo v) {
        if (cabeza == null) { //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new NodoVehiculo(v);
        } else if (v.getAno() < cabeza.getDato().getAno()) {//Sí existe un nodo 
            //adentro y el nodo a agregar tiene un id menor al nodo
            //que ya existe 
            NodoVehiculo aux = new NodoVehiculo(v); //Creo el nodo aux
            //con v de parámetro
            aux.setNext(cabeza);   //Coloco aux a la izq de la cabeza 
            cabeza = aux;     //Cabeza ahora hace referencia al nuevo elemento 
            //Este else if funciona si la lista ya tiene un solo elemento 
        } else if (cabeza.getNext() == null) {
            //Caso:3 Si debo insertar a la derecha de la cabeza valido que no 
            //haya nada ahí 
            cabeza.setNext(new NodoVehiculo(v));
        } else {
            //Este método lo usamos para insertar al medio y al final
            //de la lista 
            NodoVehiculo aux = cabeza;
            while (aux.getNext() != null && aux.getNext().getDato().getAno() 
                    < v.getAno()) {
                aux = aux.getNext();
            }
            //ya ubicado se procede a realizar los enlaces (medio) 
            NodoVehiculo temp = new NodoVehiculo(v);//Creo temp para crear el nodo p 
            temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
            aux.setNext(temp); //Enlazo el siguiente de aux al temp 
        }

    }

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

    //Molina: Ampliar el método para modificar todos los datos excepto la placa
    //Método para modificar datos excepto NumPlaca
    //Todo gucci por acá ;)
    public void modifica(Vehiculo v) {
        //Busca si hay un vehículo con ese numPlaca y modifica sus datos excepto
        //el número de Placa 
        if (cabeza != null) {
            //Si hay algo en la lista buscamos
            NodoVehiculo aux = cabeza; //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            //Molina: Se cambia el operador de "==" a "!=" ya que si son 
            //iguales el método no ejecuta cambios
            while (aux != null && !aux.getDato().getNumPlaca()
                    .equals(v.getNumPlaca())) {
                aux = aux.getNext(); //avanzo en la lista 
            }//Si lo encuentra hago el cambio de datos
            if (aux != null && aux.getDato().getNumPlaca()
                    .equals(v.getNumPlaca())) {
                //Cambia la marca 
                aux.getDato().setMarca(v.getMarca());
                aux.getDato().setAno(v.getAno());
                aux.getDato().setCilindrada(v.getCilindrada());
                aux.getDato().setModelo(v.getModelo());
                aux.getDato().setColor(v.getColor());
                aux.getDato().setNumPasajeros(v.getNumPasajeros());
                aux.getDato().setPrecioDia(v.getPrecioDia());
                aux.getDato().setCombustible(v.getCombustible());
                aux.getDato().setEstado(v.getEstado());
                //Gabriela: No sé que procede con "estado" que no sé cómo hacer
                //para ponerlo para modificar como es un enum 
            }
        }

    }

    //Molina: Funcional
    //Busca un vehículo por NumPlaca y lo elimina 
    public void elimina(String NumPlaca) {
        //Buscamos el vehículo por num plac, si lo encuentra lo elimina
        if (cabeza != null) {//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getNumPlaca().equals(NumPlaca)) {
                cabeza = cabeza.getNext();
            } else {
                NodoVehiculo aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux.getNext() != null && !aux.getNext().getDato()
                        .getNumPlaca().equals(NumPlaca)) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato()
                        .getNumPlaca().equals(NumPlaca)) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
            }

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
                while (aux.getNext() != null && !aux.getNext().getDato()
                        .getNumPlaca().equals(NumPlaca)) {
                    aux = aux.getNext();
                    //avanzo en la lista
                }
                // Si es el de adelante... quardo la persona y lo borro
                if (aux.getNext() != null && aux.getNext().getDato()
                        .getNumPlaca().equals(NumPlaca)) {
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
            s += aux + ", ";
            aux = aux.getNext();
        }
        return s;
    }

    public NodoVehiculo getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoVehiculo cabeza) {
        this.cabeza = cabeza;
    }

}
