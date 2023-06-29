package Clases;

import java.util.Date;

public class Consumo {
	
	    private String codigoConsumo;
	    private Cliente cliente;
	    private Date fechaConsumo;
	    private double importeTotal;

	    public Consumo(String codigoConsumo, Cliente cliente, Date fechaConsumo, double importeTotal) {
	        this.codigoConsumo = codigoConsumo;
	        this.cliente = cliente;
	        this.fechaConsumo = fechaConsumo;
	        this.importeTotal = importeTotal;
	    }

	    
	    public String getCodigoConsumo() {
	        return codigoConsumo;
	    }

	    public void setCodigoConsumo(String codigoConsumo) {
	        this.codigoConsumo = codigoConsumo;
	    }

	   
	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	    }

	   
	    public Date getFechaConsumo() {
	        return fechaConsumo;
	    }

	    public void setFechaConsumo(Date fechaConsumo) {
	        this.fechaConsumo = fechaConsumo;
	    }

	    
	    public double getImporteTotal() {
	        return importeTotal;
	    }

	    public void setImporteTotal(double importeTotal) {
	        this.importeTotal = importeTotal;
	    }
	}

