package Arreglos;

import Clases.Bebida;
import Clases.Cancion;
import Clases.Pedido;
import Clases.Piqueo;
import libreria.Diccionario;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class ArregloPedido {

    // Atributos privados
    private ArrayList<Pedido> pedidos;

    // Constructor
    public ArregloPedido() {
        pedidos = new ArrayList<>();
        cargarPedidos();
    }

    // Operaciones públicas básicas
    public void adicionar(Pedido x) {
        pedidos.add(x);
        grabar();
    }

    public int tamano() {
        return pedidos.size();
    }

    public Pedido obtener(int i) {
        return pedidos.get(i);
    }

    public Pedido buscar(String id) {
        for (int i = 0; i < tamano(); i++) {
            if (obtener(i).getIdPedido().equals(id))
                return obtener(i);
        }
        return null;
    }

    public void eliminar(Pedido x) {
        pedidos.remove(x);
        grabar();
    }

    public void actualizarArchivo() {
        grabar();
    }

    private void grabar() {
        try {
            PrintWriter pw;
            String linea;
            Pedido pedido;

            pw = new PrintWriter(new FileWriter("./src/pedido.txt"));
            for (int i = 0; i < tamano(); i++) {
                pedido = obtener(i);
                linea = pedido.getIdPedido() + ";" +
                        pedido.getFechaPedido().toString() + ";" +
                        pedido.getIdUsuario() + ";" +
                        pedido.getIdCliente() + ";" +
                        pedido.traerIdCancionesSeleccionadas() + ";" +
                        pedido.getBebidas().toString() + ";" +
                        pedido.getPiqueos().toString() + ";" +
                        pedido.getEstado();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void cargarPedidos() {
        try {
            BufferedReader br;
            String linea;
            String[] ArrayDePalabras;

            String idPedido, idUsuario, idCliente = null;
            Date fechaPedido;
            String canciones;
            String bebidas;
            String piqueos;
            int estado;
            
            ArrayList<Cancion> cancionesList;
            ArrayList<Bebida> bebidasList = null;
            ArrayList<Piqueo> piqueosList = null;
            
            //Array de canciones cortadas en "." itero sobre cd una y traigo cd una de las canciones 
            br = new BufferedReader(new FileReader("./src/pedido.txt"));
            while ((linea = br.readLine()) != null) {
                ArrayDePalabras = linea.split(";");
                idPedido = ArrayDePalabras[0].trim();
                fechaPedido = new Date(ArrayDePalabras[1].trim());
                idUsuario = ArrayDePalabras[2].trim();
                canciones = ArrayDePalabras[3].trim();
                bebidas = ArrayDePalabras[4].trim();
                piqueos = ArrayDePalabras[5].trim();
                estado = Integer.parseInt(ArrayDePalabras[6].trim());
                
                cancionesList = ArrayListCanciones(canciones);
                
                adicionar(new Pedido(idPedido, fechaPedido, idUsuario, idCliente, cancionesList, bebidasList, piqueosList, estado));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cancion> ArrayListCanciones (String IdCancionesString) {
    	String[] ArrayDePalabras;
    	ArrayList<Cancion> canciones = new ArrayList<>();;
    	
    	ArrayDePalabras = IdCancionesString.split(".");
    	
    	for (String elemento : ArrayDePalabras) {
    		Cancion cancion = ArregloCancion.buscar(elemento.trim());
    		Cancion newCancion = new Cancion(cancion.getIdCancion(), cancion.getNombre(), cancion.getArtista(), cancion.getAlbum(), cancion.getFechaRegistro(), cancion.getNumeroReproducciones(), cancion.isEstado());
    		canciones.add(newCancion);
    	}
    	return canciones; 
    }

    // Operaciones públicas complementarias
    public String numeroCorrelativo() {
        if (tamano() == 0)
            return "PED" + String.format("%04d", 1);
        else {
            String NumeroEnCadena = obtener(tamano() - 1).getIdPedido().substring(3);
            int Numero = Integer.parseInt(NumeroEnCadena);
            return "PED" + String.format("%04d", (Numero + 1));
        }
    }
}