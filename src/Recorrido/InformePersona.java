package Recorrido;

import java.util.ArrayList;

import Usuario.Persona;

public class InformePersona implements Informe {

//	ATRIBUTOS
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	
//	CONSTRUCTORES
	public InformePersona () {
		
	}
	public InformePersona (ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
//	GETTERS SETTERS
	public ArrayList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
//	METODOS
	@Override
	public void mostrarInforme() {

		
		
	}

}
