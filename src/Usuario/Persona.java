package Usuario;

public abstract class Persona {

//	ATRIBUTOS
	protected String nombre;
	protected String localidad;
	protected String telefono;
	protected double gasto;
	protected double ingreso;
	
//	CONSTRUCTORES
	public Persona () {
		
	}
	public Persona (String nombre, String localidad, String telefono) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.telefono = telefono;

	}
	public Persona (String nombre, String localidad, String telefono, double gasto, double ingreso) {
		this.nombre = nombre;
		this.localidad = localidad;
		this.telefono = telefono;
		this.gasto = gasto;
		this.ingreso = ingreso;
	}
	
//	GETTERS SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public double getGasto() {
		return gasto;
	}
	public void setGasto(double gasto) {
		this.gasto = gasto;
	}
	
	public double getIngreso() {
		return ingreso;
	}
	public void setIngreso(double ingreso) {
		this.ingreso = ingreso;
	}
	
//	METODOS
//	- Gastos -
	public double incrementarGasto (double cantidad) {
		
		this.gasto = this.gasto + cantidad;
		System.out.println("Tu nuevo gasto es de -> " + this.gasto + "€"); 
		
		return this.gasto;
	}
	
	public double disminuirGasto (double cantidad) {
		
		this.gasto = this.gasto - cantidad;
		System.out.println("Tu gasto se queda en -> " + this.gasto + "€"); 
		
		return this.gasto;
	}
	
//	- Ingresos -
	public double incrementarIngreso (double cantidad) {
		
		this.ingreso = this.ingreso + cantidad;
		System.out.println("Tendrás ahora un ingreso de -> " + this.ingreso + "€"); 
		
		return this.gasto;
	}
	
	public double disminuirIngreso (double cantidad) {
		
		this.ingreso = this.ingreso - cantidad;
		System.out.println("Tendrás un ingreso cargado con -> " + this.ingreso + "€"); 
		
		return this.gasto;
	}
	
	public abstract void mostrarPersona ();
	
}
