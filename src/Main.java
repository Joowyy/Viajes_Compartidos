import java.util.Scanner;

import MedioDeTransporte.Coche;
import MedioDeTransporte.Vehiculo;
import Recorrido.Viaje;

public class Main {

	public static void main(String[] args) {

		
		char opcionUsuario;
		
		do {
		
			opcionUsuario = menu();
			
			switch (opcionUsuario) {
			case '1':
				
				planificarViaje();
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
	
	public static void planificarViaje () {
		Scanner sc = new Scanner (System.in);
		Vehiculo cocheViaje;
		Vehiculo furgoViaje;
		
		System.out.println("De donde partirá el viaje:");
		String origenViaje = sc.nextLine();
		System.out.println("Cúal es el destino de este:");
		String destinoViaje = sc.nextLine();
		System.out.println("Dime la distancia entre ambos:");
		double kmsViaje = sc.nextDouble();
		System.out.println("Cuanto gastará cada pasajero:");
		double gastoPorPasajero = sc.nextDouble();
		System.out.println("Que vehiculo usarán (Coche/Furgoneta):");
		String respuesta = sc.nextLine();
		
		if (respuesta.equalsIgnoreCase("Coche")) {
			
			cocheViaje = new Coche ("4893KRJ", 123.224, );
			
		} else if (respuesta.equalsIgnoreCase("Furgoneta")) {
			
		} else {
			
		}
		
		Viaje vNuevo = new Viaje ();
		
	}
	
//	FUNCION RETORNA VALOR DEL MENU
	public static char menu () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("BIENVENIDO A CALLAO-CAR\n1. \n2. \n3. \n4.");
		char opcionUsuario = sc.nextLine().charAt(0);
		
		return opcionUsuario;
	}

}
