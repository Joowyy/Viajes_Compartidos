package Recorrido;

import java.util.ArrayList;

import Usuario.Persona;

public class InformePersona implements Informe {

//	ATRIBUTOS
	private static ArrayList<Persona> personas = new ArrayList<Persona>();
	
//	CONSTRUCTORES
	public InformePersona () {
		
	}
	public InformePersona (ArrayList<Persona> personas) {
		InformePersona.personas = personas;
	}
	
//	GETTERS SETTERS
	public static ArrayList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(ArrayList<Persona> personas) {
		InformePersona.personas = personas;
	}
	
//	METODOS
	@Override
	public void mostrarInforme() {

		System.out.println("==============================");
		System.out.println("\t> PERSONAS <");
		
		for (Persona p1 : personas) {
			
			p1.mostrarPersona();
			
		}
		
		System.out.println("==============================");
		
	}

}
