package Solicitudes;

import Cliente.Categoria;
import Cliente.Cliente;
import Cliente.ListaCliente;
import Extras.Cola;
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
    private Cola extras; //Este parametro debe asociarse a la misma que manejen los 
    //vehículos
    private EstadoSolicitud estado = EstadoSolicitud.Registrada;
    //Mediante este atributo se define la asociación con el cliente
    private Cliente cliente;
    private String placaVehiculo;
    private double montoTotal;

    public Solicitud(ListaCliente lista) {
        this.fecha = JOptionPane.showInputDialog("Ingrese la fecha de la "
                + "solicitud");
        this.cantDias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese"
                + " la cantidad de días de su solicitud"));
        this.minPasajeros = Integer.parseInt(JOptionPane
                .showInputDialog("Indique la cantidad de pasajeros mímina del"
                        + " vehículo"));
        this.marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo");
        this.modelo = JOptionPane.showInputDialog("Ingrese el modelo del"
                + " dispositivo");
        this.ano = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año"
                + " del vehículo"));
        this.extras = encolarExtras(JOptionPane.showInputDialog("Ingrese "
                + "las extras del vehículo, estas deben estar separadas por "
                + "una coma (,)"));
        this.estado = EstadoSolicitud.Registrada;
        this.cliente = lista.traerPersonaCedula(JOptionPane
                .showInputDialog("Ingrese la cedula de la persona a la que se"
                        + " le registra la solicitud."));
        ajustarCategoriaDias();
    }

    public Solicitud(String fecha, int cantDias, int minPasajeros, String marca,
            String modelo, int ano, Cola extras, EstadoSolicitud estado, 
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

    public Cola getExtras() {
        return extras;
    }

    public void setExtras(Cola extras) {
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
    
    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    //Este método se encarga de revisar la cantidad de días que se solicita de 
    //alquiler, de acuerdo a esto verifica si se cambia la categoría del cliente
    //o no
    public void ajustarCategoriaDias(){
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
        } 
    }
    
    public void ajustarCategoriaMonto(){
        if (this.getMontoTotal()>= 70000) {
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
        } 
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

