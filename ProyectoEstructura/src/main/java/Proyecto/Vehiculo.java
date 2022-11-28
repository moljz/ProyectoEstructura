
package Proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Maria Gabriela
 */
public class Vehiculo {
    //Atributos 
    private int año; 
    private String marca; 
    private String modelo; 
    private String numPlaca; 
    private int NumPasajeros; 
    private String combustible; 
    private double precioDia; 
    private int cilindrada;
    
    //Constructor 

    public Vehiculo(int año, String marca, String modelo, String numPlaca, int NumPasajeros, String combustible, double precioDia, int cilindrada) {
        this.año = año;
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.NumPasajeros = NumPasajeros;
        this.combustible = combustible;
        this.precioDia = precioDia;
        this.cilindrada = cilindrada; 
    }
    //Constructor default 

    public Vehiculo() {
    }
    
    //Get and Sets 

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
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
    
     public void pedir_dato(){
         
        this.año = Integer.parseInt(JOptionPane.showInputDialog("Digite el "
                + "año del vehículo: "));
        this.marca= JOptionPane.showInputDialog("Digite la marca del vehículo: ");
        this.modelo=JOptionPane.showInputDialog("Digite el modelo del vehículo: ");
        this.numPlaca= JOptionPane.showInputDialog("Digite su nombre: ");
        this.NumPasajeros=Integer.parseInt(JOptionPane.showInputDialog("Digite"
                 + " su número de vuelo "));
        this.combustible= JOptionPane.showInputDialog("Digite su nombre: ");
        this.precioDia=Double.parseDouble(JOptionPane.showInputDialog("Digite"
                 + " su número de vuelo "));
        this.cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite"
                 + " su edad: "));
        
}  
     
  
    
  
    
    
}
