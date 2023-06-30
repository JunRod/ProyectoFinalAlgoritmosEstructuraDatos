package Arreglos;

import Clases.Piqueo;
import Clases.Piqueo;
import Clases.Genero;
import Clases.Piqueo;
import Clases.Usuario;
import libreria.ayudantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ArregloPiqueo {
	
	//  Atributos privados
	private ArrayList <Piqueo> piqueos;
	//  Constructor
	public ArregloPiqueo() {
		piqueos = new ArrayList <Piqueo> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Piqueo x) {
		piqueos.add(x);
		grabar();
	}
	public int tamano() {
		return piqueos.size();
	}
	public Piqueo obtener(int i) {
		return piqueos.get(i);
	}
	public Piqueo buscar(String id) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdPiqueo().equals(id))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Piqueo x) {
		piqueos.remove(x);
		grabar();
	}
	public void actualizarArchivo() {
		grabar();
	}
	private void grabar() {
		try {
			PrintWriter pw;
			String linea;
			Piqueo Piqueo;
			pw = new PrintWriter(new FileWriter("./src/piqueo.txt"));
			
			for(int i=0; i<tamano(); i++) {
				
				Piqueo = obtener(i);
				linea = Piqueo.getIdPiqueo() + ";" +
						Piqueo.getNombre() + ";" +
						Piqueo.getTipoPiqueo() + ";" +
						Piqueo.getPrecio() + ";" +
						Piqueo.isEstado();
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
			String idPiqueo, nombre;
			int tipoPiqueo;
			double precio;
			boolean estado;
			
			br = new BufferedReader(new FileReader("./src/piqueo.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				
				idPiqueo = ArrayDePalabras[0].trim();
				nombre = ArrayDePalabras[1].trim();
				tipoPiqueo = Integer.parseInt(ArrayDePalabras[2].trim());
				precio = Double.parseDouble(ArrayDePalabras[3].trim());
				estado = Boolean.parseBoolean(ArrayDePalabras[4].trim());

				adicionar(new Piqueo(idPiqueo, nombre, tipoPiqueo, precio, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "PIQ" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdPiqueo().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "PIQ" + String.format("%04d", (Numero + 1));
	    }
	}
	
}