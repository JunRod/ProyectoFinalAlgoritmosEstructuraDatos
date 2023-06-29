package Clases;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Artista {

	    private String idArtista;
	    private String nombreArtistico;
	    private String genero;
	    private Date fechaRegistro;
	    private boolean estado;
	    
	    

		public Artista(String idArtista, String nombreArtistico, String genero, Date fechaRegistro, boolean estado) {
			super();
			this.idArtista = idArtista;
			this.nombreArtistico = nombreArtistico;
			this.genero = genero;
			this.fechaRegistro = fechaRegistro;
			this.estado = estado;
		}

		public String getIdArtista() {
			return idArtista;
		}

		public void setIdArtista(String idArtista) {
			this.idArtista = idArtista;
		}

		public String getNombreArtistico() {
			return nombreArtistico;
		}

		public void setNombreArtistico(String nombreArtistico) {
			this.nombreArtistico = nombreArtistico;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public Date getFechaRegistro() {
			return fechaRegistro;
		}

		public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
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

