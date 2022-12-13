package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class Cliente {


    private String cedula;
    private String nomCompleto;
    private String fechaNac;
    private String correo;
    private Categoria categoria;


    public Cliente(String cedula, String nomCompleto, String fechaNac, String correo,
            Categoria categoria) {


            this.cedula = cedula;
            this.nomCompleto = nomCompleto;
            this.fechaNac = fechaNac;
            this.correo = correo;
            this.categoria = categoria;
        

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void pedir_dato() {

        this.cedula = JOptionPane.showInputDialog("Digite la cedula");

        this.nomCompleto = JOptionPane.showInputDialog("Digite el nombre"
                + " completo: ");
        this.fechaNac = JOptionPane.showInputDialog("Digite la"
                + "fecha de nacimiento: ");
        this.correo = JOptionPane.showInputDialog("Digite su correo: ");

        this.categoria =Categoria.valueOf(JOptionPane.showInputDialog
        ("Digite su categoría de cliente"));
    }

}
