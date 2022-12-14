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
    private String cadenaExtras; //Recibe las extras ingresadas en texto plano
    private Cola extras; //Molina: Cambiar este aributo a una estructura de 
    //datos ya que se deben almacenar varios

    //Constructor 
    public Vehiculo(int ano, String marca, String modelo, String numPlaca,
            String color, int NumPasajeros, String combustible, EstadoVehiculo estado,
            double precioDia, int cilindrada, String cadenaExtras) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.color = color;
        this.NumPasajeros = NumPasajeros;
        this.combustible = combustible;
        this.estado = estado;
        this.precioDia = precioDia;
        this.cilindrada = cilindrada;
        this.extras = encolarExtras(cadenaExtras);
    }

    //Constructor default 
    public Vehiculo() {
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
    
    public String getCadenaExtras() {
        return cadenaExtras;
    }

    public void setCadenaExtras(String cadenaExtras) {
        this.cadenaExtras = cadenaExtras;
    }

    //Molina: No gucci, revisar
    public void pedir_dato() {

        this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite el "
                + "año del vehículo: "));
        this.marca = JOptionPane.showInputDialog("Digite la marca del "
                + "vehículo: ");
        this.modelo = JOptionPane.showInputDialog("Digite el modelo del"
                + " vehículo: ");
        this.numPlaca = JOptionPane.showInputDialog("Digite su nombre: ");
        this.NumPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " su número de vuelo "));
        this.combustible = JOptionPane.showInputDialog("Digite su nombre: ");
        this.precioDia = Double.parseDouble(JOptionPane.showInputDialog("Digite"
                + " su número de vuelo "));
        this.cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " su edad: "));
    }
    
    public Cola encolarExtras(String extras){
//        String extras = "Vidrio polarizado, Aire acondicionado, Luces LED";
        Cola colaExtras = new Cola();
        String[] nodos = new String[extras.length()];
        for (int i = 0; i < nodos.length; i++) {
            nodos = extras.split(",");
            colaExtras.encola(new Extras.Nodo(nodos[i]));
        }
        return colaExtras;
    }

}
