package Arreglos;

import Clases.Cliente;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import libreria.ayudantes;

public class ArregloCliente {

	// Atributos privados
	private ArrayList<Cliente> clientes;

	// Constructor
	public ArregloCliente() {
		clientes = new ArrayList<Cliente>();
		cargarUsuarios();
	}

	// Operaciones p�blicas b�sicas
	public void adicionar(Cliente x) {
		clientes.add(x);
		grabarClientes();
	}

	public int tamano() {
		return clientes.size();
	}

	public Cliente obtener(int i) {
		return clientes.get(i);
	}

	public Cliente buscar(String IdCliente) {
		for (int i = 0; i < tamano(); i++) {
			if (obtener(i).getIdCliente().equals(IdCliente)) {
				return obtener(i);
			}
		}
		return null;
	}

	public void eliminar(Cliente x) {
		clientes.remove(x);
		grabarClientes();
	}

	public void actualizarArchivo() {
		grabarClientes();
	}

	private void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente cliente;
			pw = new PrintWriter(new FileWriter("./src/clientes.txt"));
			for (int i = 0; i < tamano(); i++) {
				cliente = obtener(i);
				linea = cliente.getIdCliente() + ";" + cliente.getApellidoPaterno() + ";" + cliente.getApellidoMaterno()
						+ ";" + cliente.getNombres() + ";" + cliente.getDireccion() + ";"
						+ cliente.getFechaNacimientoFormateada() + ";" + cliente.getFechaAfiliacionFormateada() + ";"
						+ cliente.getEstadoCivil() + ";" + cliente.getTelefono() + ";" + cliente.getDni() + ";"
						+ cliente.getTipoDeCliente();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	private void cargarUsuarios() {
		try {
			BufferedReader br;
			String linea;
			String[] ArrayDePalabras;
			String idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion, estadoCivil, telefono, dni;
			Date fechaNacimiento, fechaAfiliacion; 
			int tipoDeCliente;

			br = new BufferedReader(new FileReader("./src/clientes.txt"));
			while ((linea = br.readLine()) != null) {
				ArrayDePalabras = linea.split(";");
				idCliente = ArrayDePalabras[0].trim();
				apellidoPaterno = ArrayDePalabras[1].trim();
				apellidoMaterno = ArrayDePalabras[2].trim();
				nombres = ArrayDePalabras[3].trim();
				direccion = ArrayDePalabras[4].trim();
				fechaNacimiento = ayudantes.StringToDateExample(ArrayDePalabras[5].trim());
				fechaAfiliacion = ayudantes.StringToDateExample(ArrayDePalabras[6].trim());
				estadoCivil = ArrayDePalabras[7].trim();
				telefono = ArrayDePalabras[8].trim();
				dni = ArrayDePalabras[9].trim();
				tipoDeCliente = Integer.parseInt(ArrayDePalabras[10].trim());

				adicionar(new Cliente(idCliente, apellidoPaterno, apellidoMaterno, nombres, direccion, fechaNacimiento, fechaAfiliacion,
						estadoCivil, telefono, dni, tipoDeCliente));
			}
			br.close();
		} catch (Exception e) {
		}
	}

	// Operaciones p�blicas complementarias
	public String numeroCorrelativo() {
		if (tamano() == 0)
			return "CLI" + String.format("%04d", 1);
		else {
			String NumeroEnCadena = obtener(tamano() - 1).getIdCliente().substring(3);
			int Numero = Integer.parseInt(NumeroEnCadena);
			return "CLI" + String.format("%04d", (Numero + 1));
		}
	}

}