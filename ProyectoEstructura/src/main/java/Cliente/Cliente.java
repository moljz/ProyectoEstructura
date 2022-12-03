package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author jafet
 */
public class Cliente {

    //Molina: Este atributo debe tener validaciones para que sea única, no 
    //pueden existir duplicados
    private String cedula;
    private String nomCompleto;
    //Molina: Es necesario determinar el formato a utilizar ya que al ser int se
    //limita cualquier carácter distinto a un número (Considerar mejor formulación)
    private int fechaNac;
    private String correo;
    //Molina: Validar si vale la pena utilizar un enum para encapsular las 
    //categorías que ya se encuentran definidas
    private String categoria;

    public Cliente(String cedula, String nomCompleto, int fechaNac, String correo,
            String categoria) {
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

        this.cedula = JOptionPane.showInputDialog("Digite la cedula");

        this.nomCompleto = JOptionPane.showInputDialog("Digite el nombre"
                + " completo: ");
        this.fechaNac = Integer.parseInt(JOptionPane.showInputDialog("Digite la"
                + "fecha de nacimiento: "));
        this.correo = JOptionPane.showInputDialog("Digite su correo: ");
        this.categoria = JOptionPane.showInputDialog("Digite su categoria: ");

    }

}
