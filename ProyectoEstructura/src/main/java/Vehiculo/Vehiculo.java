package Vehiculo;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela
 */
public class Vehiculo {

    //PENDIENTE cambiar extras, modificar ToStrings, añadir comentarios, consul
    //tar método Modifica de la lista 
    //Atributos 
    
    private int ano;
    private String marca;
    private String modelo;
    private String numPlaca;
    private String color;
    private int NumPasajeros;
    private String combustible;
    private Estado estado;
    private double precioDia;
    private int cilindrada;
    private String extras; //Molina: Cambiar este aributo a una estructura de 
    //datos ya que se deben almacenar varios

    //Constructor 
    public Vehiculo(int ano, String marca, String modelo, String numPlaca,
            String color, int NumPasajeros, String combustible,
            double precioDia, int cilindrada, String extras) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.color = color;
        this.NumPasajeros = NumPasajeros;
        this.combustible = combustible;
        this.precioDia = precioDia;
        this.cilindrada = cilindrada;
        this.extras = extras;
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

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public void pedir_dato() {

        this.ano = Integer.parseInt(JOptionPane.showInputDialog("Digite el "
                + "año del vehículo: "));
        this.marca = JOptionPane.showInputDialog("Digite la marca del vehículo: ");
        this.modelo = JOptionPane.showInputDialog("Digite el modelo del vehículo: ");
        this.numPlaca = JOptionPane.showInputDialog("Digite su nombre: ");
        this.NumPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " su número de vuelo "));
        this.combustible = JOptionPane.showInputDialog("Digite su nombre: ");
        this.precioDia = Double.parseDouble(JOptionPane.showInputDialog("Digite"
                + " su número de vuelo "));
        this.cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                + " su edad: "));

    }

}
