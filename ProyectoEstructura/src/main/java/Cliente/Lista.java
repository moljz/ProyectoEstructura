/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author jafet
 */
public class Lista {
    
    private Nodo cabeza;
    
    public void inserta(Cliente c){
        if (cabeza == null){ //Si la lista está vacía solo asignamos nuevo nodo 
            cabeza = new Nodo (c);
            Nodo aux = new Nodo(c);
            aux.setNext(cabeza);
            cabeza=aux;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(new Nodo(c));
            
        }
        Nodo aux = (Nodo) cabeza;
        
        Nodo temp = new Nodo (c);//Creo temp para crear el nodo p 
        temp.setNext(aux.getNext()); //Enlazo temp al siguiente de aux
        aux.setNext(temp); //Enlazo el siguiente de aux al temp 
        }
        @Override
    public String toString() {
        Nodo aux = (Nodo) cabeza; 
        String s ="Lista: ";
        while (aux !=null) {
            s+=aux+", ";
            aux=aux.getNext();
        }
        return s;
    }
    public boolean existe (String Cedula){
            boolean esta = false; //Busca en la lista y retorna true si un
            //Vehiculo tiene ese número de placa 
            if (cabeza != null){
                //Si hay algo en la lista busca
                Nodo aux = (Nodo) cabeza; 
                //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
              while (aux != null && aux.getDato().getCedula()!= Cedula){
                  aux = aux.getNext(); //avanzo en la lista 
              }
              esta = (aux != null && aux.getDato().getCedula()== Cedula);
            }
            return esta; 
    }
    public void modifica (Cliente c){
        //Busca si hay un vehículo con ese numPlaca y modifica sus datos excepto
        //el número de Placa 
        if (cabeza != null){
            //Si hay algo en la lista buscamos
            Nodo aux = (Nodo) cabeza; //Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
                 while (aux != null && aux.getDato().getCedula()== c.getCedula()){
                  aux = aux.getNext(); //avanzo en la lista 
              }//Si lo encuentra hago el cambio de datos
                 if (aux != null && aux.getDato().getCedula()== c.getCedula()){
                     //Cambia la marca 
                     aux.getDato().setCorreo(c.getCorreo());
                 }
        
                 }
        }
    public void elimina (String cedula){
        //Buscamos el vehículo por num plac, si lo encuentra lo elimina
        if (cabeza != null){//Si hay algo en la lista buscamos 
            if (cabeza.getDato().getCorreo()== cedula){
                cabeza = cabeza.getNext();
            }else {
                Nodo aux = (Nodo) cabeza;//Utilizo aux como indice 
                //Mientras no se acabe la lista y el elemento de la lista sea 
                //diferente del buscado
               while (aux.getNext() != null && aux.getNext().getDato().getCorreo()!= cedula){
                   aux = aux.getNext();
               }//Avanzo en la lista
               //Si es el de adelante lo borro
               if (aux.getNext() != null && aux.getNext().getDato().getCorreo()== cedula){
                   aux.setNext(aux.getNext().getNext());//Cambio las referencias 
               }
            }
        }   
    }
    
    
}
