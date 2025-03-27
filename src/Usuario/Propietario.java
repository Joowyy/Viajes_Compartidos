package Usuario;

public class Propietario extends Persona {

//	ATRIBUTOS
	private String experienciaConduccion;
	
	//	CONSTRUCTORES
	public Propietario () {
		
	}
	public Propietario (String nombre, String localidad, String telefono, String experienciaConduccion) {
		super (nombre, localidad, telefono);
		this.experienciaConduccion = experienciaConduccion;
	}
	public Propietario (String nombre, String localidad, String telefono, double gasto, double ingreso, String experienciaConduccion) {
		super (nombre, localidad, telefono, gasto, ingreso);
		this.experienciaConduccion = experienciaConduccion;
	}
	
//	GETTERS SETTERS
	public String getExperienciaConduccion() {
		return experienciaConduccion;
	}
	public void setExperienciaConduccion(String experienciaConduccion) {
		this.experienciaConduccion = experienciaConduccion;
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
		System.out.println("Experiencia -> " + experienciaConduccion);
		System.out.println("==============================\n");
		
	}
	
	public String toString () {
		
		return nombre;
		
	}
	
}
