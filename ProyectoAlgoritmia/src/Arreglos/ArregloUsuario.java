package Arreglos;

import Clases.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArregloUsuario {
	
	//  Atributos privados
	private ArrayList <Usuario> usuarios;
	//  Constructor
	public ArregloUsuario() {
		usuarios = new ArrayList <Usuario> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Usuario x) {
		usuarios.add(x);
		grabarUsuarios();
	}
	public int tamano() {
		return usuarios.size();
	}
	public Usuario obtener(int i) {
		return usuarios.get(i);
	}
	public Usuario buscar(String IdUsuario) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdUsuario() == IdUsuario)
				System.out.println(IdUsuario + "\n" + obtener(i)); //Nosé porque sin esto no funciona
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Usuario x) {
		usuarios.remove(x);
		grabarUsuarios();
	}
	public void actualizarArchivo() {
		grabarUsuarios();
	}
	private void grabarUsuarios() {
		try {
			PrintWriter pw;
			String linea;
			Usuario usuario;
			pw = new PrintWriter(new FileWriter("./src/usuario.txt"));
			for(int i=0; i<tamano(); i++) {
				usuario = obtener(i);
				linea = usuario.getIdUsuario() + ";" +
						usuario.getApellidoPaterno() + ";" +
						usuario.getApellidoPaterno() + ";" +
						usuario.getNombres() + ";" +
						usuario.getTipoEmpleado() + ";" +
						usuario.getLogin() + ";" +
						usuario.getPassword() + ";" +
						usuario.getTurno();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarUsuarios() {
		try {
			BufferedReader br;
			String linea;
			String[] ArrayDePalabras;
			String idUsuario, apellidoPaterno, apellidoMaterno, nombres, login, password, turno;
			int tipoEmpleado;
			br = new BufferedReader(new FileReader("./src/usuario.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				idUsuario = ArrayDePalabras[0].trim();
				apellidoPaterno = ArrayDePalabras[1].trim();
				apellidoMaterno = ArrayDePalabras[2].trim();
				nombres = ArrayDePalabras[3].trim();
				tipoEmpleado = Integer.parseInt(ArrayDePalabras[4].trim());
				login = ArrayDePalabras[5].trim();
				password = ArrayDePalabras[6].trim();
				turno = ArrayDePalabras[7].trim();

				adicionar(new Usuario(idUsuario, apellidoPaterno, apellidoMaterno, nombres, tipoEmpleado, login, password, turno));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "USU" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdUsuario().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "USU" + String.format("%04d", (Numero + 1));
	    }
	}
	
}