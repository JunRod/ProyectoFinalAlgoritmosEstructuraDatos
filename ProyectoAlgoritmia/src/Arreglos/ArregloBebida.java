package Arreglos;

import Clases.Bebida;
import Clases.Bebida;
import Clases.Bebida;
import Clases.Genero;
import Clases.Bebida;
import Clases.Usuario;
import libreria.ayudantes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ArregloBebida {
	
	//  Atributos privados
	private ArrayList <Bebida> bebidas;
	//  Constructor
	public ArregloBebida() {
		bebidas = new ArrayList <Bebida> ();
		cargarUsuarios();
	}
	//  Operaciones p�blicas b�sicas
	public void adicionar(Bebida x) {
		bebidas.add(x);
		grabar();
	}
	public int tamano() {
		return bebidas.size();
	}
	public Bebida obtener(int i) {
		return bebidas.get(i);
	}
	public Bebida buscar(String id) {
		for (int i=0; i<tamano(); i++) {
			if (obtener(i).getIdBebida().equals(id))
				return obtener(i);
		}
		return null;
	}
	public void eliminar(Bebida x) {
		bebidas.remove(x);
		grabar();
	}
	public void actualizarArchivo() {
		grabar();
	}
	private void grabar() {
		try {
			PrintWriter pw;
			String linea;
			Bebida Bebida;
			pw = new PrintWriter(new FileWriter("./src/bebida.txt"));
			
			for(int i=0; i<tamano(); i++) {
				
				Bebida = obtener(i);
				linea = Bebida.getIdBebida() + ";" +
						Bebida.getNombre() + ";" +
						Bebida.getTipoBebida() + ";" +
						Bebida.getMarca() + ";" +
						Bebida.getPrecio() + ";" +
						Bebida.isEstado();
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
			String idBebida, nombre, marca;
			int tipoBebida;
			double precio;
			boolean estado;
			
			br = new BufferedReader(new FileReader("./src/bebida.txt"));
			while ((linea=br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				
				idBebida = ArrayDePalabras[0].trim();
				nombre = ArrayDePalabras[1].trim();
				marca = ArrayDePalabras[2].trim();
				tipoBebida = Integer.parseInt(ArrayDePalabras[3].trim());
				precio = Double.parseDouble(ArrayDePalabras[4].trim());
				estado = Boolean.parseBoolean(ArrayDePalabras[5].trim());

				adicionar(new Bebida(idBebida, nombre, tipoBebida, marca, precio, estado));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	//  Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
	    if (tamano() == 0)
	        return "BEB" + String.format("%04d", 1);
	    else {
	        String NumeroEnCadena = obtener(tamano() - 1).getIdBebida().substring(3);
	        int Numero = Integer.parseInt(NumeroEnCadena);
	        return "BEB" + String.format("%04d", (Numero + 1));
	    }
	}
	
}