package MedioDeTransporte;

import Usuario.Propietario;

public class Coche extends Vehiculo {

//	ATRIBUTO
	private String marca;
	private String modelo;
	
//	CONSTRUCTORES
	public Coche () {
		
	}
	public Coche (String matricula, double kmsRecorridos, Propietario titular, String marca, String modelo) {
		super(matricula, kmsRecorridos, titular);
		this.marca = marca;
		this.modelo = modelo;
	}
	
//	GETTERS SETTERS
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
//	METODOS
	@Override
	public void mostrarVehiculo() {

		System.out.println("\n==============================");
		System.out.println("Matricula -> " + matricula);
		System.out.println("kmsRecorrido -> " + kmsRecorridos);
		System.out.println("Titular -> " + titular);
		System.out.println("Marca -> " + marca);
		System.out.println("Modelo -> " + modelo);
		System.out.println("==============================\n");
		
	}
}
