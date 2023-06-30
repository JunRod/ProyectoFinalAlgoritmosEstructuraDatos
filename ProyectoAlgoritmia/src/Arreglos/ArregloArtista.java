package Arreglos;

import Clases.Artista;
import Clases.Genero;
import Clases.Usuario;
import libreria.ayudantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ArregloArtista {
	
	//  Atributos privados
	private ArrayList <Artista> artistas;
	//  Constructor
	public ArregloArtista() {
		artistas = new ArrayList <Artista> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Artista x) {
		artistas.add(x);
		grabar();
	}
	public int tamano() {
		return artistas.size();
	}
	public Artista obtener(int i) {
		return artistas.get(i);
	}
	public Artista buscar(String id) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdArtista().equals(id))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Artista x) {
		artistas.remove(x);
		grabar();
	}
	public void actualizarArchivo() {
		grabar();
	}
	private void grabar() {
		try {
			PrintWriter pw;
			String linea;
			Artista artista;
			pw = new PrintWriter(new FileWriter("./src/artista.txt"));
			for(int i=0; i<tamano(); i++) {
				artista = obtener(i);
				linea = artista.getIdArtista() + ";" +
						artista.getNombreArtistico() + ";" +
						artista.getGenero() + ";" +
						artista.getFechaRegistroFormateada() + ";" +
						artista.isEstado();
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
			
			br = new BufferedReader(new FileReader("./src/artista.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				
				idArtista = ArrayDePalabras[0].trim();
				nombreArtistico = ArrayDePalabras[1].trim();
				idGenero = ArrayDePalabras[2].trim();
				fechaRegistro = ayudantes.StringToDateExample(ArrayDePalabras[3].trim());
				estado = Boolean.parseBoolean(ArrayDePalabras[4].trim());

				adicionar(new Artista(idArtista, nombreArtistico, idGenero, fechaRegistro, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "ART" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdArtista().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "ART" + String.format("%04d", (Numero + 1));
	    }
	}
	
}