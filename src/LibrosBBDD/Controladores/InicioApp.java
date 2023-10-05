package LibrosBBDD.Controladores;

import java.sql.Connection;
import java.util.ArrayList;
import LibrosBBDD.Dtos.*;
import LibrosBBDD.Servicios.*;
import java.util.Scanner;

public class InicioApp {
/**
 * Procedimiento de mi proyecto.
 * @author Mario Nocea Cabrera
 * */
	public static void main(String[] args) {
		//Declaraciones e Instancias de interfaces.
		Integer opcion;
		long id_libro;
		InicioAppInterfaz inicioAppInterfaz = new InicioAppImplementacion();
		ConexionInterfaz conexionInterfaz = new ConexionImplementacion();
		CrudInterfaz crudInterfaz = new CrudImplementación();
		ArrayList<Libros> listaLibros = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		Connection conexion=null;
		try {
			do {
				conexion = conexionInterfaz.Conectar();//Abro la conexión cada vez que vuelvo al menú
				opcion = inicioAppInterfaz.Menu();//Muestro el menú
				switch (opcion) {
				case 1:
					if (conexion != null) {
						crudInterfaz.MostrarLibros(conexion);
					}
					break;
				case 2:
					break;
				case 3:
					if (conexion != null)
						crudInterfaz.ActualizarLibros(conexion);
					break;
				case 4:
					crudInterfaz.CrearLibros(conexion);
					break;
				case 5:
					if(conexion!=null)
						crudInterfaz.BorrarLibros(conexion);
					break;
				}
			} while (opcion != 0);
			conexion.close();//La cierro antes de salir de la app
		} catch (Exception e) {
			System.out.println("[ERROR-InicioApp]-Ha ocurrido al ejecutar la aplicación");
		}
	}

}
