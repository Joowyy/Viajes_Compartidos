package Usuario;

public class Viajero extends Persona {

//	ATRIBUTOS
	private String puntoRecogidaPreferido;

	//	CONSTRUCTORES
	public Viajero () {
		
	}
	public Viajero (String nombre, String localidad, String telefono, double gasto, double ingreso, String puntoRecogidaPreferido) {
		super(nombre, localidad, telefono, gasto, ingreso);
		this.puntoRecogidaPreferido = puntoRecogidaPreferido;
	}
	
//	GETTERS SETTERS
	public String getPuntoRecogidaPreferido() {
		return puntoRecogidaPreferido;
	}
	public void setPuntoRecogidaPreferido(String puntoRecogidaPreferido) {
		this.puntoRecogidaPreferido = puntoRecogidaPreferido;
	}
	
//	METODOS
	@Override
	public void mostrarPersona() {

		System.out.println("\n==============================");
		System.out.println("Nombre -> " + nombre);
		System.out.println("Localidad -> " + localidad);
		System.out.println("Telefono -> " + telefono);
		System.out.println("Gasto -> " + gasto);
		System.out.println("Ingreso -> " + ingreso);
		System.out.println("PuntoFav. -> " + puntoRecogidaPreferido);
		System.out.println("==============================\n");
		
	}
	
}
