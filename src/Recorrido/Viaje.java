package Recorrido;

import java.util.ArrayList;

import MedioDeTransporte.Vehiculo;
import Usuario.Persona;
import Usuario.Propietario;

public class Viaje {

//	ATRIBUTOS
	private String origenViaje;
	private String destinoViaje;
	private double kmsViaje;
	private double gastoPorPasajero;
	private ArrayList<Persona> pasajeros = new ArrayList<Persona>();
	private Vehiculo transporte;
	
//	CONSTRUCTORES
	public Viaje () {
		
	}
	public Viaje (String origenViaje, String destinoViaje, double kmsViaje, double gastoPorPasajero, ArrayList<Persona> pasajeros, Vehiculo transporte) {
		this.origenViaje = origenViaje;
		this.destinoViaje = destinoViaje;
		this.kmsViaje = kmsViaje;
		this.gastoPorPasajero = gastoPorPasajero;
		this.pasajeros = pasajeros;
		this.transporte = transporte;
	}
	
//	GETTERS SETTERS
	public String getOrigenViaje() {
		return origenViaje;
	}
	public void setOrigenViaje(String origenViaje) {
		this.origenViaje = origenViaje;
	}
	public String getDestinoViaje() {
		return destinoViaje;
	}
	public void setDestinoViaje(String destinoViaje) {
		this.destinoViaje = destinoViaje;
	}
	public double getKmsViaje() {
		return kmsViaje;
	}
	public void setKmsViaje(double kmsViaje) {
		this.kmsViaje = kmsViaje;
	}
	public double getGastoPorPasajero() {
		return gastoPorPasajero;
	}
	public void setGastoPorPasajero(double gastoPorPasajero) {
		this.gastoPorPasajero = gastoPorPasajero;
	}
	public ArrayList<Persona> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(ArrayList<Persona> pasajeros) {
		this.pasajeros = pasajeros;
	}
	public Vehiculo getTransporte() {
		return transporte;
	}
	public void setTransporte(Vehiculo transporte) {
		this.transporte = transporte;
	}
	
//	METODOS
	public void mostrarViaje () {
		
		System.out.println("\n==============================");
		System.out.println("Origen -> " + origenViaje);
		System.out.println("Destino -> " + destinoViaje);
		System.out.println("Distancia kms -> " + kmsViaje);
		System.out.println("Gasto p/pasajero -> " + gastoPorPasajero);
		System.out.println("Transporte -> " + transporte);
		System.out.println("Pasajeros -> " + pasajeros);
		System.out.println("==============================\n");
		
	}

}
