package Vehiculo;

import Extras.Cola;
import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela
 */
public class Vehiculo {
    //Atributos 

    private int ano;
    private String marca;
    private String modelo;
    private String numPlaca;
    private String color;
    private int NumPasajeros;
    private String combustible;
    private EstadoVehiculo estado;
    private double precioDia;
    private int cilindrada;
    private Cola extras;
    //Este atributo define si ha sido o no alquilado el vehículo
    private boolean alquilado = false;

    //Constructor default 
    public Vehiculo() {
        try {
            this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite el "
                    + "año del vehículo: "));
            this.marca = JOptionPane.showInputDialog("Digite la marca del "
                    + "vehículo: ");
            this.modelo = JOptionPane.showInputDialog("Digite el modelo del"
                    + " vehículo: ");
            this.numPlaca = JOptionPane.showInputDialog("Digite el número de placa:"
                    + " ");
            this.color = JOptionPane.showInputDialog("Digite el color del vehículo:"
                    + " ");
            this.NumPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                    + " la cantidad de pasajeros del vehículo"));
            this.combustible = JOptionPane.showInputDialog("Digite el tipo de"
                    + " combustible: ");
            this.estado = definirEstado();
            this.precioDia = Double.parseDouble(JOptionPane.showInputDialog("Digite"
                    + " el precio por día del vehículo: "));
            this.cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                    + " la cilindrada del vehículo"));
            this.extras = encolarExtras(JOptionPane.showInputDialog("Ingrese "
                    + "las extras del vehículo, estas deben estar separadas por "
                    + "una coma (,)"));
            this.alquilado = alquilado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los datos");
        }

    }

    //Get and Sets 
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public int getNumPasajeros() {
        return NumPasajeros;
    }

    public void setNumPasajeros(int NumPasajeros) {
        this.NumPasajeros = NumPasajeros;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Cola getExtras() {
        return extras;
    }

    public void setExtras(Cola extras) {
        this.extras = extras;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public EstadoVehiculo definirEstado() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Indique una opción:\n1. Disponible.\n2.Alquilado.\n3. En reparacion.\n4. Fuera de circulacion"));
        switch (opcion) {
            case 1:
                this.estado = EstadoVehiculo.Disponible;
                break;
            case 2:
                this.estado = EstadoVehiculo.Alquilado;
                break;
            case 3:
                this.estado = EstadoVehiculo.En_reparacion;
                break;
            case 4:
                this.estado = EstadoVehiculo.Fuera_Circulacion;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Inserte una opción valida");
        }
        return this.estado;
    }

    //Este método convierte una cadena de texto separada por coma en una cola
    public Cola encolarExtras(String extras) {
        //Genera la cola a retornar
        Cola colaExtras = new Cola();
        //Crea un arreglo para almacenar las palabras
        String[] nodos = new String[extras.length()];
        //Recorre toda la cadena de texto
        for (int i = 0; i < nodos.length; i++) {
            //Separa la cadena por comas
            nodos = extras.split(",");
            //Encola cada nodo
            colaExtras.encola(new Extras.Nodo(nodos[i]));
        }
        //Retorna la cola
        return colaExtras;
    }

}
