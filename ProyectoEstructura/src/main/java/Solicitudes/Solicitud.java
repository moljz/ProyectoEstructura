package Solicitudes;

/**
 *
 * @author Juan Carlos
 */

//Esta clase tiene como finalidad definir los parámetros de las solicitudes
public class Solicitud {
    
    private int cantDias;
    private int minPasajeros;
    private String marca;
    private String modelo;
    private int ano;
    private String extras; //Este parametro debe asociarse a la misma que manejen los 
    //vehículos
    private Estado estado;
    //Es necesario evaluar la mejor manera de asociar la cola con la categoría
    //del cliente

    public Solicitud() {
    }

    public Solicitud(int cantDias, int minPasajeros, String marca, 
            String modelo, int ano, String extras, Estado estado) {
        this.cantDias = cantDias;
        this.minPasajeros = minPasajeros;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.extras = extras;
        this.estado = Estado.Registrada;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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
    
    
}
