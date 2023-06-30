package libreria;

import java.util.Arrays;

import Arreglos.ArregloArtista;
import Arreglos.ArregloGenero;
import Clases.Artista;
import Clases.Genero;

public class Diccionario {
	
	static ArregloGenero arregloGenero = new ArregloGenero();
	static ArregloArtista arregloArtistas = new ArregloArtista();
	
	public static String[] tipoEmpleado = { "Administrador", "Supervisor", "Mozo" };
	public static String[] turno = { "Tarde", "Noche"};
	
	public static String[] estadoCivil = { "Soltero", "Casado", "Viudo", "Divorciado", "No especifica"};
	public static String[] tipoDeCliente = { "Estandar", "Bronce", "Plata", "Oro", "Diamante"};
	public static String[] estado = { "Inhabilitado", "Habilitado"};
	public static String[] tipoPiqueo = { "Frios", "Calientes", "Snacks"};
	public static String[] tipoBebida = { "Cerveza",  "Vinos", "Whisky", "Ron", "Frutado", "Conbinacion preparada",  "Agua embotellada"};
	
	public static String[] IdGeneros;
	public static String[] IdArtistas;
	
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
	
	
	
	
	
	
	
}
