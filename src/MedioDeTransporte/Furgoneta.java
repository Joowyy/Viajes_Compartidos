package MedioDeTransporte;

import Usuario.Propietario;

public class Furgoneta extends Vehiculo {

//	ATRIBUTOS
	private String capacidadCarga;

//	CONSTRUCTORES
	public Furgoneta () {
		
	}
	public Furgoneta (String matricula, double kmsRecorridos, Propietario titular, String capacidadCarga) {
		super(matricula, kmsRecorridos, titular);
		this.capacidadCarga = capacidadCarga;
	}
	
//	GETTERS SETTERS
	public String getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(String capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
//	METODOS
	@Override
	public void mostrarVehiculo() {

		System.out.println("\n==============================");
		System.out.println("Matricula -> " + matricula);
		System.out.println("kmsRecorrido -> " + kmsRecorridos);
		System.out.println("Titular -> " + titular);
		System.out.println("Capacidad C. -> " + capacidadCarga);
		System.out.println("==============================\n");
		
	}
	
}
