package LibrosBBDD.Servicios;

import java.util.Scanner;


public class InicioAppImplementacion implements InicioAppInterfaz {

	@Override
	public int Menu() {
		int opcion;
		Scanner scan=new Scanner(System.in);
		System.out.println("1-->Mostrar Todos Los Libros");
		System.out.println("2-->Mostrar un Libro");
		System.out.println("3-->Cambiar Dato/s de Libro/s");
		System.out.println("4-->Insertar Libro/s");
		System.out.println("5-->Eliminar Libro/s");
		System.out.println("0-->Salir de la APP");
		System.out.print("Introduzca una de las siguientes opciones:");	
			do {
			opcion=scan.nextInt();
			if(opcion<0||opcion>5)
				System.out.println("Esa opción no está en el menú");
			}while(opcion<0||opcion>5);
		return opcion;
	}
}
