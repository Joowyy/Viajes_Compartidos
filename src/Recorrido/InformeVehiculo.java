package Recorrido;

import java.util.ArrayList;

import MedioDeTransporte.Vehiculo;

public class InformeVehiculo implements Informe {
	
//	ATRIBUTOS
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
//	CONSTRUCTORES
	public InformeVehiculo () {
		
	}
	public InformeVehiculo (ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
//	GETTERS SETTERS
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

//	METODOS
	@Override
	public void mostrarInforme() {

		System.out.println("==============================");
		System.out.println("\t> VEHICULOS <");
		
		for (Vehiculo v1 : vehiculos) {
			
			
			
		}
		
		System.out.println("==============================");
		
	}
	
}
