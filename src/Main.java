import java.util.ArrayList;
import java.util.Scanner;

import MedioDeTransporte.Coche;
import MedioDeTransporte.Vehiculo;
import Recorrido.InformePersona;
import Recorrido.InformeVehiculo;
import Usuario.Persona;
import Usuario.Propietario;

public class Main {

	public static void main(String[] args) {

		ArrayList<Persona> personas = InformePersona.getPersonas();
		ArrayList<Vehiculo> vehiculos = InformeVehiculo.getVehiculos();
		char opcionUsuario;
		
		do {
		
			opcionUsuario = menu();
			
			switch (opcionUsuario) {
			case '1':
				
				planificarViaje(personas, vehiculos);
				break;
			
			case '2':
				
				break;
				
			case '3':
				
				break;
				
			default:
				
				System.out.println("Introduce un carácter válido\n");
				
			}
		
		} while (opcionUsuario != '7');
		
	}
	
	
//	FALTAN CREAR TODAS LOS PASAJEROS MENOS EL PROPE
//	FALTAN CREAR TODAS LOS PASAJEROS MENOS EL PROPE
//	FALTAN CREAR TODAS LOS PASAJEROS MENOS EL PROPE
//	FALTAN CREAR TODAS LOS PASAJEROS MENOS EL PROPE
	public static void planificarViaje (ArrayList<Persona> personas, ArrayList<Vehiculo> vehiculos) {
		
//		Variables necesarias
		Scanner sc = new Scanner (System.in);
		boolean personasCreada = false;
		boolean viajePlanificado = false;
		ArrayList<Persona> pasajeros = new ArrayList<Persona>();
		Propietario propeAux = null;
		Vehiculo cocheViaje = null;
		Vehiculo furgoViaje = null;
		
//		Bucle en busca de errores
		do {

//			Datos del viaje
			System.out.println("De donde partirá el viaje:");
			String origenViaje = sc.nextLine();
			System.out.println("Cúal es el destino de este:");
			String destinoViaje = sc.nextLine();
			System.out.println("Dime la distancia entre ambos:");
			double kmsViaje = sc.nextDouble();
			System.out.println("Cuanto gastará cada pasajero:");
			double gastoPorPasajero = sc.nextDouble();
			
//			Datos de las personas
			do {

				System.out.println("Dime el nombre del propietario ->");
				String nombrePrope = sc.nextLine();
				System.out.println("De donde es el propietario ->");
				String localidadPrope = sc.nextLine();
				System.out.println("Dime su telefono para contactar con el ->");
				String telefonoPrope = sc.nextLine();

//				Chequeo
				if (telefonoPrope.length() != 9) {

					System.out.println("Introduce un teléfono valido");
					break;

				}

				System.out.println("Y por ultimo dime su experiencia de conduccion");
				String expePrope = sc.nextLine();

//				-- En el ArrayList de 'Pasajeros' lo añadimos especificamente a ese viaje
				propeAux = new Propietario(nombrePrope, localidadPrope, telefonoPrope, expePrope);
				pasajeros.add(propeAux);

//				-- En el ArrayList de 'Personas' lo añadimos globalmente a todas las personas
				personas.add(propeAux);
				personasCreada = true;
			
			} while (!personasCreada);

//			Datos del transporte (Termina la planificación del viaje)
			System.out.println("Que vehiculo usarán (Coche/Furgoneta):");
			String respuesta = sc.nextLine();

			if (respuesta.equalsIgnoreCase("Coche")) {

				System.out.println("Vamos a recoger los datos del coche ->\nDigame su matricula:");
				String matriculaCoche = sc.nextLine();

//				Chequeo
				if (matriculaCoche.length() != 7) {

					System.out.println("Introduce una matricula válida");
					break;

				}
				
				System.out.println("Que kms a recorrido el vehiculo");
				double kmsCoche = sc.nextDouble();
				Propietario titularCoche = propeAux;
				System.out.println("Dime la marca del coche:");
				String marcaCoche = sc.nextLine();
				System.out.println("Dime el modelo del coche:");
				String modeloCoche = sc.nextLine();
				
				vehiculos.add(new Coche(matriculaCoche, kmsCoche, titularCoche, marcaCoche, modeloCoche));

			} else if (respuesta.equalsIgnoreCase("Furgoneta")) {


			} else {

				System.out.println("Introduce un transporte válido.");

			}

		} while (!viajePlanificado);

	}
	
//	FUNCION RETORNA VALOR DEL MENU
	public static char menu () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("BIENVENIDO A CALLAO-CAR\n1. Planificar Viaje\n2. \n3. \n4.");
		char opcionUsuario = sc.nextLine().charAt(0);
		
		return opcionUsuario;
	}

}
