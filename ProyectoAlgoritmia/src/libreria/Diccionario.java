package libreria;

import java.util.Arrays;

import Arreglos.ArregloArtista;
import Arreglos.ArregloCancion;
import Arreglos.ArregloCliente;
import Arreglos.ArregloGenero;
import Arreglos.ArregloUsuario;
import Clases.Artista;
import Clases.Cancion;
import Clases.Cliente;
import Clases.Genero;
import Clases.Usuario;

public class Diccionario {
	
	static ArregloGenero arregloGenero = new ArregloGenero();
	static ArregloArtista arregloArtistas = new ArregloArtista();
	static ArregloCliente arregloClientes = new ArregloCliente();
	static ArregloUsuario arregloUsuarios = new ArregloUsuario();
	static ArregloCancion arregloCancion = new ArregloCancion();
	
	
	public static String[] tipoEmpleado = { "Administrador", "Supervisor", "Mozo" };
	public static String[] turno = { "Tarde", "Noche"};
	
	public static String[] estadoCivil = { "Soltero", "Casado", "Viudo", "Divorciado", "No especifica"};
	public static String[] tipoDeCliente = { "Estandar", "Bronce", "Plata", "Oro", "Diamante"};
	public static String[] estado = { "Inhabilitado", "Habilitado"};
	
	public static String[] tipoPiqueo = { "Frios", "Calientes", "Snacks"};
	public static String[] tipoBebida = { "Cerveza",  "Vinos", "Whisky", "Ron", "Frutado", "Conbinacion preparada",  "Agua embotellada"};
	
	public static String[] estadoPedido = { "Pendiente", "Atendido", "Anulado"};
	
	public static String[] IdGeneros;
	public static String[] IdArtistas;
	public static String[] IdClientes;
	public static String[] IdUsuarios;
	public static String[] IdCanciones;
	
    public static void generarTodosLosID() {
        Genero genero;
        IdGeneros = new String[arregloGenero.tamano()]; 
        for (int i = 0; i < arregloGenero.tamano(); i++) {
            genero = arregloGenero.obtener(i);
            String id = genero.getIdGenero();
            IdGeneros[i] = id;
        }
    }
    
    public static void generarTodosLosIDArtista() {
        Artista artista;
        IdArtistas = new String[arregloArtistas.tamano()]; 
        for (int i = 0; i < arregloArtistas.tamano(); i++) {
            artista = arregloArtistas.obtener(i);
            String id = artista.getIdArtista();
            IdArtistas[i] = id;
        }
    }
    
    public static void generarTodosLosIDUsuario() {
        Usuario usuarios;
        IdUsuarios = new String[arregloUsuarios.tamano()]; 
        for (int i = 0; i < arregloUsuarios.tamano(); i++) {
        	usuarios = arregloUsuarios.obtener(i);
            String id = usuarios.getIdUsuario();
            IdUsuarios[i] = id;
        }
    }
    
    public static void generarTodosLosIDCliente() {
        Cliente cliente;
        IdClientes = new String[arregloClientes.tamano()]; 
        for (int i = 0; i < arregloClientes.tamano(); i++) {
        	cliente = arregloClientes.obtener(i);
            String id = cliente.getIdCliente();
            IdClientes[i] = id;
        }
    }
    
    public static void generarTodosLosIDCanciones() {
        Cancion cancion;
        IdCanciones = new String[arregloCancion.tamano()]; 
        for (int i = 0; i < arregloCancion.tamano(); i++) {
        	cancion = arregloCancion.obtener(i);
            String id = cancion.getIdCancion();
            IdCanciones[i] = id;
        }
    }
    
    
    
	
	
	
	
	
	
	
}
