package LibrosBBDD.Controladores;

import java.sql.Connection;
import java.util.ArrayList;
import LibrosBBDD.Dtos.*;
import LibrosBBDD.Servicios.*;
import java.util.Scanner;

public class InicioApp {

	public static void main(String[] args) {
		Integer opcion;
		long id_libro;
		InicioAppInterfaz inicioAppInterfaz = new InicioAppImplementacion();
		ConexionInterfaz conexionInterfaz = new ConexionImplementacion();
		CrudInterfaz crudInterfaz = new CrudImplementación();
		ArrayList<Libros> listaLibros = new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		try {
			do {
				Connection conexion = conexionInterfaz.Conectar();
				opcion = inicioAppInterfaz.Menu();
				switch (opcion) {
				case 1:// Mostrar todos los libros
					if (conexion != null) {
						listaLibros = crudInterfaz.SelectLibros(conexion);
						for (int i = 0; i < listaLibros.size(); i++) {
							System.out.println(listaLibros.get(i).toString());
						}
					}
					break;
				case 2:// Mostrar un solo libro
						if(conexion!=null) {
							listaLibros=crudInterfaz.SelectLibros(conexion);
							for (int i = 0; i <listaLibros.size(); i++) {
								System.out.println(listaLibros.get(i).getId_libro()+"."+listaLibros.get(i).getTitulo());
							}
						System.out.println("Introduce el id del libro que quiera mostrar:");
						id_libro=scan.nextLong();
						for (int i = 0; i <listaLibros.size(); i++) {
							if(listaLibros.get(i).getId_libro()==id_libro)
								System.out.println(listaLibros.get(i).toString());
						}
						}
					break;
				case 3:// Cambiar libros
					crudInterfaz.UpdateLibros(conexion);
					break;
				// Eliminar Libros
				case 4:
					crudInterfaz.InsertLibros(conexion);
					break;
				case 5:
					System.out.println("Eliminar libro/s");
					break;
				}
			} while (opcion != 0);
		} catch (Exception e) {
			System.out.println("[ERROR-InicioApp]-Ha ocurrido al ejecutar la aplicación");
		}
	}

}
