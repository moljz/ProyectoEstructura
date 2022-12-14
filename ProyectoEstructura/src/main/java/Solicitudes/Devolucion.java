/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solicitudes;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class Devolucion {
    private String cedula;
    private String placa;
    private String condicion;

    public Devolucion(String cedula, String placa, String condicion) {
        this.cedula = cedula;
        this.placa = placa;
        this.condicion = condicion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    public void Solicitar_datos (){
        this.cedula = JOptionPane.showInputDialog("Digite la cedula");
        this.placa = JOptionPane.showInputDialog("Digite la placa");
        this.condicion = JOptionPane.showInputDialog("digite la condicion");
    }
    
}
