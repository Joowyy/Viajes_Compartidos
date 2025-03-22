package MedioDeTransporte;

import Usuario.Propietario;

public abstract class Vehiculo {

//	ATRIBUTOS
	protected String matricula;
	protected double kmsRecorridos;
	protected Propietario titular;
	
//	CONSTRUCTOR
	public Vehiculo () {
		
	}
	public Vehiculo (String matricula, double kmsRecorridos, Propietario titular) {
		this.matricula = matricula;
		this.kmsRecorridos = kmsRecorridos;
		this.titular = titular;
	}
	
//	GETTERS SETTERS
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public double getKmsRecorridos() {
		return kmsRecorridos;
	}
	public void setKmsRecorridos(double kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}
	
	public Propietario getTitular() {
		return titular;
	}
	public void setTitular(Propietario titular) {
		this.titular = titular;
	}
	
//	METODOS
	public double incrementarKms (double cantidad) {
		
		this.kmsRecorridos = this.kmsRecorridos + cantidad;
		System.out.println("El coche tiene ahora -> " + this.kmsRecorridos + " kms recorridos.");
		
		return this.kmsRecorridos;
	}
	
	public double disminuirKms (double cantidad) {
		
		this.kmsRecorridos = this.kmsRecorridos - cantidad;
		System.out.println("El coche tiene ahora -> " + this.kmsRecorridos + " kms recorridos.");
		
		return this.kmsRecorridos;
	}
	
	public abstract void mostrarVehiculo ();
	
}
