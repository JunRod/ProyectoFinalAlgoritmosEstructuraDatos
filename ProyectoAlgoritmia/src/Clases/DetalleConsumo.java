package Clases;

public class DetalleConsumo {
	
	    private String codigoConsumo;
	    private String codigoProducto;
	    private Bebida bebida; 
	    private Piqueo piqueo; 
	    private int cantidad;
	    private double subtotal;
	    
	    
	    public DetalleConsumo(String codigoConsumo, String codigoProducto, int cantidad, double subtotal) {
	        this.codigoConsumo = codigoConsumo;
	        this.codigoProducto = codigoProducto;
	        this.cantidad = cantidad;
	        this.subtotal = subtotal;
	    }
	    
	    
	    public String getCodigoConsumo() {
	        return codigoConsumo;
	    }
	    
	    public void setCodigoConsumo(String codigoConsumo) {
	        this.codigoConsumo = codigoConsumo;
	    }
	    
	    public String getCodigoProducto() {
	        return codigoProducto;
	    }
	    
	    public void setCodigoProducto(String codigoProducto) {
	        this.codigoProducto = codigoProducto;
	    }
	    
	    public Bebida getBebida() {
	        return bebida;
	    }
	    
	    public void setBebida(Bebida bebida) {
	        this.bebida = bebida;
	    }
	    
	    public Piqueo getPiqueo() {
	        return piqueo;
	    }
	    
	    public void setPiqueo(Piqueo piqueo) {
	        this.piqueo = piqueo;
	    }
	    
	    public int getCantidad() {
	        return cantidad;
	    }
	    
	    public void setCantidad(int cantidad) {
	        this.cantidad = cantidad;
	    }
	    
	    public double getSubtotal() {
	        return subtotal;
	    }
	    
	    public void setSubtotal(double subtotal) {
	        this.subtotal = subtotal;
	    }
	}
