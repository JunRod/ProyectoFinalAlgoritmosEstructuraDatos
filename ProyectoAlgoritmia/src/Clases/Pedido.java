package Clases;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private String idPedido;
    private Date fechaPedido;
    private String idUsuario;
    private String idCliente;
    private ArrayList<Cancion> canciones;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Piqueo> piqueos;
    private int estado;

    public Pedido(String idPedido, Date fechaPedido, String idUsuario, String idCliente,
                  ArrayList<Cancion> canciones, ArrayList<Bebida> bebidas, ArrayList<Piqueo> piqueos, int estado) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.canciones = canciones;
        this.bebidas = bebidas;
        this.piqueos = piqueos;
        this.estado = estado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Piqueo> getPiqueos() {
        return piqueos;
    }

    public void setPiqueos(ArrayList<Piqueo> piqueos) {
        this.piqueos = piqueos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int tamano() {
        return canciones.size();
    }

    public String traerIdCancionesSeleccionadas() {
    	String IdCancionesSeleccionadas = "";
    	
        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.get(i);
            String id = cancion.getIdCancion();
            IdCancionesSeleccionadas = id + ".";
        }
        return IdCancionesSeleccionadas;
    }
}
