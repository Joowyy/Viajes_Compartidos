import java.util.ArrayList;
import java.util.Scanner;

import MedioDeTransporte.Coche;
import MedioDeTransporte.Furgoneta;
import MedioDeTransporte.Vehiculo;
import Recorrido.InformePersona;
import Recorrido.InformeVehiculo;
import Usuario.Persona;
import Usuario.Propietario;
import Usuario.Viajero;

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
				
				//mostrarInformePersonas(personas, vehiculos);
				break;
				
			case '3':
				
				//mostrarInformeVehiculos(personas, vehiculos);
				break;
				
			default:
				
				System.out.println("Introduce un carácter válido\n");
				
			}
		
		} while (opcionUsuario != '7');
		
	}
	
	public static void planificarViaje (ArrayList<Persona> personas, ArrayList<Vehiculo> vehiculos) {
		
//		Variables necesarias
		Scanner sc = new Scanner (System.in);
		boolean personasCreada = false;
		boolean viajePlanificado = false;
		ArrayList<Persona> pasajeros = new ArrayList<Persona>();
		double ingresosPrope = 0.0;
		double gastoPorPasajero = 0.0;
		String telefonoPasa = null;
		Viajero pasaAuxEx = new Viajero();
		Propietario propeAux = new Propietario();
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
			gastoPorPasajero = sc.nextDouble();
			
//			Datos de las personas
//			> Propietario <
			System.out.println("Dime el nombre del propietario ->");
			propeAux.setNombre(sc.nextLine());
			sc.nextLine();
			System.out.println("De donde es el propietario ->");
			propeAux.setLocalidad(sc.nextLine());
			System.out.println("Dime su telefono para contactar con el ->");
			propeAux.setTelefono(sc.nextLine());
			
//			Chequeo
			if (propeAux.getTelefono().length() != 9) {

				System.out.println("Introduce un teléfono valido");
				break;

			}
			
			System.out.println("\nEste tendrá también el gasto incluido -> " + gastoPorPasajero);
			propeAux.setGasto(propeAux.incrementarGasto(gastoPorPasajero));
			System.out.println("Mas tarde calcularemos los ingresos del propietario");
			System.out.println("Y por ultimo dime su experiencia de conduccion:");
			propeAux.setExperienciaConduccion(sc.nextLine());

//			> Pasajeros <
			System.out.println("Cuantos pasajeros va a llevar (Max 4):");
			int numPasajeros = sc.nextInt();
			sc.nextLine();
			
			for (int i = 0; i < numPasajeros; i++) {
				Viajero pasaAux = new Viajero();
				
				System.out.println("Dime el nombre del pasajero num" + (i+1) + ":");
				pasaAux.setNombre(sc.nextLine());
				System.out.println("Digame ahora la localidad si es tan amable:");
				pasaAux.setLocalidad(sc.nextLine());
				System.out.println("No olvida indicarme su numero de telefono:");
				pasaAux.setTelefono(sc.nextLine());
				pasaAuxEx.setTelefono(pasaAux.getTelefono());
				
				if (pasaAux.getTelefono().length() != 9) {
					
					System.out.println("Introduce un telefono válido porfavor");
					break;
					
				}
				
				System.out.println("El gasto será lo indicado por el propietario -> " + gastoPorPasajero);
				pasaAux.setGasto(pasaAux.incrementarGasto(gastoPorPasajero));
				System.out.println("Al ser pasajero no sacarás beneficio");
				System.out.println("\nDigame su punto de recogida pref. lo tendremos en cuenta:");
				pasaAux.setPuntoRecogidaPreferido(sc.nextLine());
				
				pasajeros.add(pasaAux);
				personas.add(pasaAux);
				
			}
			
			if (pasaAuxEx.getTelefono().length() != 9) {
				
				System.out.println("Introduce un telefono válido porfavor");
				break;
				
			}
			
			ingresosPrope = gastoPorPasajero * numPasajeros;
			propeAux.incrementarIngreso(ingresosPrope);
			
//			-- En el ArrayList de 'Pasajeros' lo añadimos especificamente a ese viaje
			pasajeros.add(propeAux);

//			-- En el ArrayList de 'Personas' lo añadimos globalmente a todas las personas
			personas.add(propeAux);

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
				viajePlanificado = true;

				vehiculos.add(new Coche(matriculaCoche, kmsCoche, titularCoche, marcaCoche, modeloCoche));

			} else if (respuesta.equalsIgnoreCase("Furgoneta")) {

				System.out.println("Vamos a recoger los datos de la furgo ->\nDigame su matricula:");
				String matriculaFurgo = sc.nextLine();

//				Chequeo
				if (matriculaFurgo.length() != 7) {

					System.out.println("Introduce una matricula válida");
					break;

				}

				System.out.println("Que kms a recorrido la furgo");
				double kmsFurgo = sc.nextDouble();
				sc.nextLine();
				Propietario titularFurgo = propeAux;
				System.out.println("Dime la capacidad de la furgo:");
				String capacidadFurgo = sc.nextLine();
				viajePlanificado = true;

				vehiculos.add(new Furgoneta(matriculaFurgo, kmsFurgo, titularFurgo, capacidadFurgo));

			} else {

				System.out.println("Introduce un transporte válido.");

			}

		} while (!viajePlanificado);

	}
	
	public static void mostrarInformePersonas () {
		
	}
	
	public static void mostrarInformeVehiculos () {
		
	}
	
//	FUNCION RETORNA VALOR DEL MENU
	public static char menu () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("BIENVENIDO A CALLAO-CAR\n1. Planificar Viaje\n2. \n3. \n4.");
		char opcionUsuario = sc.nextLine().charAt(0);
		
		return opcionUsuario;
	}

}
