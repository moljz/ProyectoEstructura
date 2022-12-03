package Vehiculo;

/**
 *
 * @author Maria Gabriela
 */
//Molina: Consultar al profe si las estructuras están limitadas a las que indica 
//el enunciado o si se puede usar cualquiera de las vistas en el curso ya que 
//de ser limitado es necesario actualizar esta lista a circular
public class Lista {

    //Atributos 
    Nodo cabeza;

    //Molina: La lista inserta los elementos en el orden deseado; sin embargo,
    //duplica el primer elemento que se ingresa en la lista por lo que es necesario 
    //solventarlo para darlo por corregido
    //Si la lista está vacía 
    public void inserta(Vehiculo v) {
        if (cabeza == null) { //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new Nodo(v);
        } else if (v.getAno() < cabeza.getDato().getAno()) {//Sí existe un nodo 
            //adentro y el nodo a agregar tiene un id menor al nodo que ya existe 
            Nodo aux = new Nodo(v); //Creo el nodo aux con v de parámetro
            aux.setNext(cabeza);   //Coloco aux a la izq de la cabeza 
            cabeza = aux;     //Cabeza ahora hace referencia al nuevo elemento 
            //Este else if funciona si la lista ya tiene un solo elemento 
        } else if (cabeza.getNext() == null) {
            //Caso:3 Si debo insertar a la derecha de la cabeza valido que no 
            //haya nada ahí 
            cabeza.setNext(new Nodo(v));
        }
        //Este método lo usamos para insertar al medio y al final de la lista 
        Nodo aux = cabeza;
        while (aux.getNext() != null && aux.getNext().getDato().getAno() < v.getAno()) {
            aux = aux.getNext();
        }
        //ya ubicado se procede a realizar los enlaces (medio) 
        Nodo temp = new Nodo(v);//Creo temp para crear el nodo p 
        temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
        aux.setNext(temp); //Enlazo el siguiente de aux al temp 
    }

    //Molina: Funcional
    //Consulta vehículo por numero de placa 
    public boolean existe(String NumPlaca) {
        boolean esta = false; //Busca en la lista y retorna true si un
        //Vehiculo tiene ese número de placa 
        if (cabeza != null) {
            //Si hay algo en la lista busca
            Nodo aux = cabeza;
            //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            while (aux != null && aux.getDato().getNumPlaca() != NumPlaca) {
                aux = aux.getNext(); //avanzo en la lista 
            }
            esta = (aux != null && aux.getDato().getNumPlaca() == NumPlaca);
        }
        return esta;
    }

    //Molina: Ampliar el método para modificar todos los datos excepto la placa
    //Método para modificar datos excepto NumPlaca
    public void modifica(Vehiculo v) {
        //Busca si hay un vehículo con ese numPlaca y modifica sus datos excepto
        //el número de Placa 
        if (cabeza != null) {
            //Si hay algo en la lista buscamos
            Nodo aux = cabeza; //Utilizo aux como indice 
            //Mientras no se acabe la lista y el elemento de la lista sea 
            //diferente del buscado
            //Molina: Se cambia el operador de "==" a "!=" ya que si son 
            //iguales el método no ejecuta cambios
            while (aux != null && aux.getDato().getNumPlaca() != v.getNumPlaca()) {
                aux = aux.getNext(); //avanzo en la lista 
            }//Si lo encuentra hago el cambio de datos
            if (aux != null && aux.getDato().getNumPlaca() == v.getNumPlaca()) {
                //Cambia la marca 
                aux.getDato().setMarca(v.getMarca());
                if (aux != null && aux.getDato().getNumPlaca() == v.getNumPlaca()) {
                    //Cambia la marca 
                    aux.getDato().setAno(v.getAno());
                    //Poner los demás atributos :) 

                }
            }
        }

    }

    //Molina: Funcional
    //Busca un vehículo por NumPlaca y lo elimina 
    public void elimina(String NumPlaca) {
        //Buscamos el vehículo por num plac, si lo encuentra lo elimina
        if (cabeza != null) {//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getNumPlaca() == NumPlaca) {
                cabeza = cabeza.getNext();
            } else {
                Nodo aux = cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                while (aux.getNext() != null && aux.getNext().getDato().getNumPlaca() != NumPlaca) {
                    aux = aux.getNext();
                }//Avanzo en la lista
                //Si es el de adelante lo borro
                if (aux.getNext() != null && aux.getNext().getDato().getNumPlaca() == NumPlaca) {
                    aux.setNext(aux.getNext().getNext());//Cambio las referencias 
                }
            }

        }
    }

    @Override
    public String toString() {
        Nodo aux = cabeza;
        String s = "Lista: ";
        while (aux != null) {
            s += aux + ", ";
            aux = aux.getNext();
        }
        return s;
    }

}
