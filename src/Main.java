import java.util.Scanner;

import Usuario.Persona;

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
		
		
		
	}
	
//	FUNCION RETORNA VALOR DEL MENU
	public static char menu () {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("BIENVENIDO A CALLAO-CAR\n1. \n2. \n3. \n4.");
		char opcionUsuario = sc.nextLine().charAt(0);
		
		return opcionUsuario;
	}

}
