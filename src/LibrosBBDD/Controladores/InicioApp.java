package LibrosBBDD.Controladores;
import java.sql.Connection;
import java.util.ArrayList;

import LibrosBBDD.Dtos.*;
import LibrosBBDD.Servicios.*;

public class InicioApp {

	public static void main(String[] args) {
		int opcion;
		InicioAppInterfaz inicioAppInterfaz=new InicioAppImplementacion();
		ConexionInterfaz conexionInterfaz=new ConexionImplementacion();
		CrudInterfaz crudInterfaz=new CrudImplementación();
		ArrayList<Libros> listaLibros=new ArrayList<>();
		try {
		Connection conexion=conexionInterfaz.Conectar();
		do {
			opcion=inicioAppInterfaz.Menu();
			switch(opcion) {
			//Insertar libros
			case 1:
				//Prueba Cambio rama Develop
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
		}catch(Exception e) {
			System.out.println("[ERROR-InicioApp]-Ha ocurrido al ejecutar la aplicación");
		}
	}

}
