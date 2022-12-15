package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet araya
 */
public class Cliente {

    private String cedula;
    private String nomCompleto;
    private String fechaNac;
    private String correo;
    private Categoria categoria;

    
    public Cliente() {

        this.cedula = JOptionPane.showInputDialog("Digite la cedula");

        this.nomCompleto = JOptionPane.showInputDialog("Digite el nombre"
                + " completo: ");
        this.fechaNac = JOptionPane.showInputDialog("Digite la"
                + "fecha de nacimiento: ");
        this.correo = JOptionPane.showInputDialog("Digite su correo: ");

        this.categoria = definirCategoria();

    }

    public Cliente(String cedula, String nomCompleto, String fechaNac,
            String correo, Categoria categoria) {

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

    public Categoria definirCategoria() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                "Indique una opción:\n1. Zafiro.\n2.Oro.\n3. Plata.\n4. Bronce"));
        switch (opcion) {
            case 1:
                this.categoria = Categoria.Zafiro;
                break;
            case 2:
                this.categoria = Categoria.Oro;
                break;
            case 3:
                this.categoria = Categoria.Plata;
                break;
            case 4:
                this.categoria = Categoria.Bronce;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Inserte una opción valida");
        }
        return this.categoria;
    }

}
