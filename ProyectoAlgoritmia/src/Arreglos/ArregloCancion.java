package Arreglos;

import Clases.Cancion;
import Clases.Cancion;
import Clases.Genero;
import Clases.Usuario;
import libreria.ayudantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ArregloCancion {
	
	//  Atributos privados
	private static ArrayList <Cancion> canciones;
	//  Constructor
	public ArregloCancion() {
		canciones = new ArrayList <Cancion> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Cancion x) {
		canciones.add(x);
		grabar();
	}
	public static int tamano() {
		return canciones.size();
	}
	public static Cancion obtener(int i) {
		return canciones.get(i);
	}
	public static Cancion buscar(String id) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdCancion().equals(id))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Cancion x) {
		canciones.remove(x);
		grabar();
	}
	public void actualizarArchivo() {
		grabar();
	}
	private void grabar() {
		try {
			PrintWriter pw;
			String linea;
			Cancion Cancion;
			pw = new PrintWriter(new FileWriter("./src/Cancion.txt"));
			
			for(int i=0; i<tamano(); i++) {
				
				Cancion = obtener(i);
				linea = Cancion.getIdCancion() + ";" +
						Cancion.getNombre() + ";" +
						Cancion.getArtista() + ";" +
						Cancion.getAlbum() + ";" +
						Cancion.getFechaRegistro() + ";" +
						Cancion.getNumeroReproducciones() + ";" +
						Cancion.isEstado();
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
			String idArtista, nombreArtistico, idGenero;
			Date fechaRegistro;
			boolean estado;
			
			br = new BufferedReader(new FileReader("./src/Cancion.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				
				idArtista = ArrayDePalabras[0].trim();
				nombreArtistico = ArrayDePalabras[1].trim();
				idGenero = ArrayDePalabras[2].trim();
				fechaRegistro = ayudantes.StringToDateExample(ArrayDePalabras[3].trim());
				estado = Boolean.parseBoolean(ArrayDePalabras[4].trim());

				adicionar(new Cancion(linea, nombreArtistico, idArtista, idGenero, fechaRegistro, 0, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "CAN" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdCancion().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "CAN" + String.format("%04d", (Numero + 1));
	    }
	}
	
}