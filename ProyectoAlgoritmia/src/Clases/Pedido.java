package Clases;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	    private String idPedido;
	    private Date fechaPedido;
	    private Usuario usuario;
	    private Cliente cliente;
	    private ArrayList<Cancion> canciones;
	    private ArrayList<Bebida> bebidas;
	    private ArrayList<Piqueo> piqueos;
	    private int estado;

	    public Pedido(String idPedido, Date fechaPedido, Usuario usuario, Cliente cliente) {
	        this.idPedido = idPedido;
	        this.fechaPedido = fechaPedido;
	        this.usuario = usuario;
	        this.cliente = cliente;
	        this.canciones = new ArrayList<>();
	        this.bebidas = new ArrayList<>();
	        this.piqueos = new ArrayList<>();
	        this.estado = 0; 
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

	    
	    public Usuario getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(Usuario usuario) {
	        this.usuario = usuario;
	    }

	    
	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	    }

	    
	    public void agregarCancion(Cancion cancion) {
	        canciones.add(cancion);
	    }

	    public void eliminarCancion(Cancion cancion) {
	        canciones.remove(cancion);
	    }

	    public ArrayList<Cancion> getCanciones() {
	        return canciones;
	    }

	    
	    public void agregarBebida(Bebida bebida) {
	        bebidas.add(bebida);
	    }

	    public void eliminarBebida(Bebida bebida) {
	        bebidas.remove(bebida);
	    }

	    public ArrayList<Bebida> getBebidas() {
	        return bebidas;
	    }

	    
	    public void agregarPiqueo(Piqueo piqueo) {
	        piqueos.add(piqueo);
	    }

	    public void eliminarPiqueo(Piqueo piqueo) {
	        piqueos.remove(piqueo);
	    }

	    public ArrayList<Piqueo> getPiqueos() {
	        return piqueos;
	    }

	    
	    public int getEstado() {
	        return estado;
	    }

	    public void setEstado(int estado) {
	        this.estado = estado;
	    }
	}
