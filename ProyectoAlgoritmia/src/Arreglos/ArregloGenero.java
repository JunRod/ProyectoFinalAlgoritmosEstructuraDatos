package Arreglos;

import Clases.Genero;
import libreria.Diccionario;
import Clases.Genero;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArregloGenero {
	
	//  Atributos privados
	private ArrayList <Genero> generos;
	//  Constructor
	public ArregloGenero() {
		generos = new ArrayList <Genero> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Genero x) {
		generos.add(x);
		grabar();
	}
	public int tamano() {
		return generos.size();
	}
	public Genero obtener(int i) {
		return generos.get(i);
	}
	public Genero buscar(String id) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdGenero() == id)
				System.out.println(id + "\n" + obtener(i)); //Nosé porque sin esto no funciona
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Genero x) {
		generos.remove(x);
		grabar();
	}
	public void actualizarArchivo() {
		grabar();
	}
	private void grabar() {
		try {
			PrintWriter pw;
			String linea;
			Genero generos;
			pw = new PrintWriter(new FileWriter("./src/generos.txt"));
			for(int i=0; i<tamano(); i++) {
				generos = obtener(i);
				linea = generos.getIdGenero() + ";" +
						generos.getDescripcion() + ";" +
						generos.getEpoca() + ";" +
						generos.isEstado();
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
			String idGenero, descripcion, epoca;
			boolean estado;
			
			br = new BufferedReader(new FileReader("./src/generos.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				idGenero = ArrayDePalabras[0].trim();
				descripcion = ArrayDePalabras[1].trim();
				epoca = ArrayDePalabras[2].trim();
				estado = Boolean.parseBoolean(ArrayDePalabras[3].trim());

				adicionar(new Genero(idGenero, descripcion, 0, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "GEN" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdGenero().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "GEN" + String.format("%04d", (Numero + 1));
	    }
	}
	
}