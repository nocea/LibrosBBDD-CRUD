package LibrosBBDD.Servicios;

import java.util.Scanner;


public class InicioAppImplementacion implements InicioAppInterfaz {

	@Override
	public int Menu() {
		int opcion;
		Scanner scan=new Scanner(System.in);
		System.out.println("1-->Mostrar Libro/s");
		System.out.println("2-->Cambiar Dato/s de Libro/s");
		System.out.println("3-->Insertar Libro/s");
		System.out.println("4-->Eliminar Libro/s");
		System.out.println("0-->Salir de la APP");
		System.out.print("Introduzca una de las siguientes opciones:");	
			do {
			opcion=scan.nextInt();
			if(opcion<0||opcion>4)
				System.out.println("Esa opción no está en el menú");
			}while(opcion<0||opcion>4);
		return opcion;
	}
}
