package Clases;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cancion {

	    private String idCancion;
	    private String nombre;
	    private String artista;
	    private String album;
	    private Date fechaRegistro;
	    private int numeroReproducciones;
	    private boolean estado;
	    
		public Cancion(String idCancion, String nombre, String artista, String album, Date fechaRegistro,
				int numeroReproducciones, boolean estado) {
			super();
			this.idCancion = idCancion;
			this.nombre = nombre;
			this.artista = artista;
			this.album = album;
			this.fechaRegistro = fechaRegistro;
			this.numeroReproducciones = numeroReproducciones;
			this.estado = estado;
		}
		public String getIdCancion() {
			return idCancion;
		}
		public void setIdCancion(String idCancion) {
			this.idCancion = idCancion;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getArtista() {
			return artista;
		}
		public void setArtista(String artista) {
			this.artista = artista;
		}
		public String getAlbum() {
			return album;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		public Date getFechaRegistro() {
			return fechaRegistro;
		}
		public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}
		public int getNumeroReproducciones() {
			return numeroReproducciones;
		}
		public void setNumeroReproducciones(int numeroReproducciones) {
			this.numeroReproducciones = numeroReproducciones;
		}
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		
		public String getFechaRegistroFormateada() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(fechaRegistro);
		}
	    
	
	}

