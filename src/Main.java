import java.util.ArrayList;
import java.util.Scanner;

import MedioDeTransporte.Coche;
import MedioDeTransporte.Furgoneta;
import MedioDeTransporte.Vehiculo;
import Recorrido.InformePersona;
import Recorrido.InformeVehiculo;
import Recorrido.Viaje;
import Usuario.Persona;
import Usuario.Propietario;
import Usuario.Viajero;

public class Main {

	public static void main(String[] args) {

		ArrayList<Persona> personas = InformePersona.getPersonas();
		ArrayList<Vehiculo> vehiculos = InformeVehiculo.getVehiculos();
		ArrayList<Viaje> viajes = new ArrayList<Viaje>();
		char opcionUsuario;

		do {
		
			opcionUsuario = menu();
			
			switch (opcionUsuario) {
			case '1':
				
				planificarViaje(personas, vehiculos, viajes);
				break;
			
			case '2':
				
				mostrarInformePersonas(personas, vehiculos, viajes);
				break;
				
			case '3':
				
				mostrarInformeVehiculos(personas, vehiculos, viajes);
				break;
				
			default:
				
				System.out.println("Introduce un carácter válido\n");
				
			}
		
		} while (opcionUsuario != '7');
		
	}
	
	public static void planificarViaje (ArrayList<Persona> personas, ArrayList<Vehiculo> vehiculos, ArrayList<Viaje> viajes) {
		
//		Variables necesarias
		Scanner sc = new Scanner (System.in);
		boolean viajePlanificado = false;
		ArrayList<Persona> pasajeros = new ArrayList<Persona>();
		double ingresosPrope = 0.0;
		double gastoPorPasajero = 0.0;
		Viajero pasaAuxEx = new Viajero();
		Propietario propeAux = new Propietario();
		Coche cocheViaje = new Coche();
		Furgoneta furgoViaje = new Furgoneta();
		
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
			sc.nextLine();
			
//			Datos de las personas
//			> Propietario <
			System.out.println("Dime el nombre del propietario ->");
			propeAux.setNombre(sc.nextLine());
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
				
//				Chequeo
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
			
//			Chequeo
			if (pasaAuxEx.getTelefono().length() != 9) {
				
				System.out.println("Introduce un telefono válido porfavor");
				break;
				
			}
			
//			Ingresos del propietario
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
				cocheViaje.setMatricula(sc.nextLine());

//				Chequeo
				if (cocheViaje.getMatricula().length() != 7) {

					System.out.println("Introduce una matricula válida");
					break;

				}

				System.out.println("Que kms a recorrido el vehiculo");
				cocheViaje.setKmsRecorridos(sc.nextDouble());
				sc.nextLine();
				
//				Titular del vehiculo
				cocheViaje.setTitular(propeAux);
				
				System.out.println("Dime la marca del coche:");
				cocheViaje.setMarca(sc.nextLine());
				System.out.println("Dime el modelo del coche:");
				cocheViaje.setModelo(sc.nextLine());
				viajePlanificado = true;

//				Agregamos el vehiculo al viaje
				vehiculos.add(cocheViaje);
				
				viajes.add(new Viaje(origenViaje, destinoViaje, kmsViaje, gastoPorPasajero, pasajeros, cocheViaje));

			} else if (respuesta.equalsIgnoreCase("Furgoneta")) {

				System.out.println("Vamos a recoger los datos de la furgo ->\nDigame su matricula:");
				furgoViaje.setMatricula(sc.nextLine());

//				Chequeo
				if (furgoViaje.getMatricula().length() != 7) {

					System.out.println("Introduce una matricula válida");
					break;

				}

				System.out.println("Que kms a recorrido la furgo");
				furgoViaje.setKmsRecorridos(sc.nextDouble());
				sc.nextLine();
				furgoViaje.setTitular(propeAux);
				System.out.println("Dime la capacidad de la furgo:");
				furgoViaje.setCapacidadCarga(sc.nextLine());
				viajePlanificado = true;

				vehiculos.add(furgoViaje);
				
				viajes.add(new Viaje(origenViaje, destinoViaje, kmsViaje, gastoPorPasajero, pasajeros, furgoViaje));

			} else {

				System.out.println("Introduce un transporte válido.");

			}

		} while (!viajePlanificado);

	}
	
	public static void mostrarInformePersonas (ArrayList<Persona> personas, ArrayList<Vehiculo> vehiculos, ArrayList<Viaje> viajes) {
		
		System.out.println("Estos son los viajes llevados a cabo ->");
		
		for (Viaje v1 : viajes) {
			
			v1.getClass();
			
		}
		
		InformePersona ip = new InformePersona();
		ip.mostrarInforme();
		
	}
	
	public static void mostrarInformeVehiculos (ArrayList<Persona> personas, ArrayList<Vehiculo> vehiculos, ArrayList<Viaje> viajes) {
		
		InformeVehiculo iv = new InformeVehiculo();
		iv.mostrarInforme();
		
	}
	
//	FUNCION RETORNA VALOR DEL MENU
	public static char menu () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("BIENVENIDO A CALLAO-CAR\n1. Planificar Viaje\n2. Informe Personas\n3. Informe Vehiculos \n4. Mostrar Viajes");
		char opcionUsuario = sc.nextLine().charAt(0);
		
		return opcionUsuario;
	}

}
