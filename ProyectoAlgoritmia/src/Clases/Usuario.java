package Clases;

public class Usuario {
	    private String idUsuario;
	    private String apellidoPaterno;
	    private String apellidoMaterno;
	    private String nombres;
	    private int tipoEmpleado;
	    private String login;
	    private String password;
	    private String turno;

	    public Usuario(String idUsuario, String apellidoPaterno, String apellidoMaterno, String nombres, int tipoEmpleado, String login, String password, String turno) {
	        this.idUsuario = idUsuario;
	        this.apellidoPaterno = apellidoPaterno;
	        this.apellidoMaterno = apellidoMaterno;
	        this.nombres = nombres;
	        this.tipoEmpleado = tipoEmpleado;
	        this.login = login;
	        this.password = password;
	        this.turno = turno;
	    }

	    public String getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(String idUsuario) {
	        this.idUsuario = idUsuario;
	    }

	    public String getApellidoPaterno() {
	        return apellidoPaterno;
	    }

	    public void setApellidoPaterno(String apellidoPaterno) {
	        this.apellidoPaterno = apellidoPaterno;
	    }

	    public String getApellidoMaterno() {
	        return apellidoMaterno;
	    }

	    public void setApellidoMaterno(String apellidoMaterno) {
	        this.apellidoMaterno = apellidoMaterno;
	    }

	    public String getNombres() {
	        return nombres;
	    }

	    public void setNombres(String nombres) {
	        this.nombres = nombres;
	    }

	    public int getTipoEmpleado() {
	        return tipoEmpleado;
	    }

	    public void setTipoEmpleado(int tipoEmpleado) {
	        this.tipoEmpleado = tipoEmpleado;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getTurno() {
	        return turno;
	    }

	    public void setTurno(String turno) {
	        this.turno = turno;
	    }
	}
