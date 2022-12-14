package Solicitudes;

import Cliente.Categoria;
import Cliente.Cliente;
import Vehiculo.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Carlos
 */
//Esta clase tiene como finalidad definir los parámetros de las solicitudes
public class Solicitud {

    private String fecha;
    private int cantDias;
    private int minPasajeros;
    private String marca;
    private String modelo;
    private int ano;
    private String extras; //Este parametro debe asociarse a la misma que manejen los 
    //vehículos
    private EstadoSolicitud estado;
    //Mediante este atributo se define la asociación con el cliente
    private Cliente cliente;
    private String placaVehiculo;

    public Solicitud() {
    }

    public Solicitud(String fecha, int cantDias, int minPasajeros, String marca,
            String modelo, int ano, String extras, EstadoSolicitud estado, 
            Cliente cliente) {
        this.fecha = fecha;
        this.cantDias = cantDias;
        this.minPasajeros = minPasajeros;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.extras = extras;
        this.estado = estado;
        this.cliente = cliente;
        //QUITAR COMENTARIO
        //ajustarCategoria();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getMinPasajeros() {
        return minPasajeros;
    }

    public void setMinPasajeros(int minPasajeros) {
        this.minPasajeros = minPasajeros;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
    
    //Este método se encarga de revisar la cantidad de días que se solicita de 
    //alquiler, de acuerdo a esto verifica si se cambia la categoría del cliente
    //o no
    public void ajustarCategoria(){
        if (this.getCantDias() >= 30) {
            if (this.getCliente().getCategoria() != null) switch 
                    (this.getCliente().getCategoria()) {
                case Bronce -> {
                    this.getCliente().setCategoria(Categoria.Plata);
                    JOptionPane.showMessageDialog(null, "La nueva categoría es:"
                            + " " + this.getCliente().getCategoria());
                }
                case Plata -> {
                    this.getCliente().setCategoria(Categoria.Oro);
                    JOptionPane.showMessageDialog(null, "La nueva categoría es:"
                            + " " + this.getCliente().getCategoria());
                }
                case Oro -> {
                    this.getCliente().setCategoria(Categoria.Zafiro);
                    JOptionPane.showMessageDialog(null, "La nueva categoría es:"
                            + " " + this.getCliente().getCategoria());
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Este cliente ya tiene"
                            + " la categoría máxima");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se modificó la categoría.");
        }
    }

}
