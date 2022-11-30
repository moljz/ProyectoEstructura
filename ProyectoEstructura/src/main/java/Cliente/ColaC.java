/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author jafet
 */
public class ColaC {
private Nodo frente;
    private Nodo ultimo;
    private int largo; //Lleva el tamaño de la cola

    //No es necesario ponerlo


    public void encola(Nodo d) {
        if (frente == null) {  // significa que la cola esta vacia
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
        largo++;
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = frente;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s;

    }
}

