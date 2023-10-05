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
		InicioAppInterfaz inicioAppInterfaz = new InicioAppImplementacion();
		ConexionInterfaz conexionInterfaz = new ConexionImplementacion();
		CrudInterfaz crudInterfaz = new CrudImplementación();
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
					if (conexion != null)
						crudInterfaz.ActualizarLibros(conexion);
					break;
				case 3:
					if (conexion != null)
					crudInterfaz.CrearLibros(conexion);
					break;
				case 4:
					if(conexion!=null)
						crudInterfaz.BorrarLibros(conexion);
					break;
				}
			} while (opcion != 0);
			conexion.close();//La cierro antes de salir de la app
			System.out.println("[INFO-InicioApp]-Ha salido de la aplicación");
		} catch (Exception e) {
			System.out.println("[ERROR-InicioApp]-Ha ocurrido al ejecutar la aplicación");
		}
	}

}
