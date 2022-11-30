/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class Cliente {
    
    private int cedula;
    private String nomCompleto;
    private int fechaNac;
    private String correo;
    private String categoria;

    public Cliente(int cedula, String nomCompleto, int fechaNac, String correo,
            String categoria) {
        this.cedula = cedula;
        this.nomCompleto = nomCompleto;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.categoria = categoria;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public int getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(int fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    public void pedir_dato() {

        this.cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite el "
                + "numero de cedula: "));
        this.nomCompleto = JOptionPane.showInputDialog("Digite el nombre"
                + " completo: ");
        this.fechaNac = Integer.parseInt(JOptionPane.showInputDialog("Digite la"
                + "fecha de nacimiento: "));
        this.correo = JOptionPane.showInputDialog("Digite su correo: ");
        this.categoria = JOptionPane.showInputDialog("Digite su categoria: ");

    }
    
    
}
