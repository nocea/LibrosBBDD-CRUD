package LibrosBBDD.Controladores;
import LibrosBBDD.Servicios.*;

public class InicioApp {

	public static void main(String[] args) {
		int opcion;
		InicioAppInterfaz inicioAppInterfaz=new InicioAppImplementacion();
		ConexionInterfaz conexionInterfaz=new ConexionImplementacion();
		do {
			opcion=inicioAppInterfaz.Menu();
			switch(opcion) {
			//Insertar libros
			case 1:
				System.out.println("Insertar libros");
				break;
			//Mostrar libros
			case 2:
				System.out.println("Mostrar libros");
				break;
			//Cambiar libros
			case 3:
				System.out.println("Cambiar libros");
				break;
			//Eliminar Libros
			case 4:
				System.out.println("Eliminar libros");
				break;
			}
		}while(opcion!=0);

	}

}
