package LibrosBBDD.Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LibrosBBDD.Dtos.Libros;
import LibrosBBDD.Util.ADto;

public class CrudImplementación implements CrudInterfaz {
	@Override
	public void MostrarLibros(Connection conexion) {
		int opcion;
		long id_libro;
		ArrayList<Libros> listaLibrosSelect = new ArrayList<>();
		Statement declaracion = null;
		ResultSet resultado = null;
		Scanner scan = new Scanner(System.in);
		ADto aDto = new ADto();
		try {
			declaracion = conexion.createStatement();
			resultado = declaracion
					.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros\r\n" + "ORDER BY id_libro ASC ");
			listaLibrosSelect = aDto.ResultadosLibros(resultado);
			declaracion.close();
			resultado.close();
			conexion.close();
			System.out.print("Introduce 1 para mostrar todos los libros y 2 para mostrar un libro concreto-->");
			opcion = scan.nextInt();

			if (opcion == 1) {
				System.out.println("---LISTA DE LIBROS---");
				for (int i = 0; i < listaLibrosSelect.size(); i++) {
					System.out.println(listaLibrosSelect.get(i).toString());
				}
			} else if (opcion == 2) {
				for (int i = 0; i < listaLibrosSelect.size(); i++) {
					System.out.println(
							listaLibrosSelect.get(i).getId_libro() + "." + listaLibrosSelect.get(i).getTitulo());
				}
				System.out.print("Introduce el id del libro que quiera mostrar-->");
				id_libro = scan.nextLong();
				System.out.println("---LIBRO SELECCIONADO---");
				for (int i = 0; i < listaLibrosSelect.size(); i++) {
					if (listaLibrosSelect.get(i).getId_libro() == id_libro)
						System.out.println(listaLibrosSelect.get(i).toString());
				}
			}
		} catch (SQLException sqle) {
			System.out.println("[ERROR-CrudImplementación-SelectLibros()]-No se ha podido acceder a la base de datos.");
		}
	}

	@Override
	public void ActualizarLibros(Connection conexion) {
		ArrayList<Libros> listaLibrosUpdate = new ArrayList<>();
		Statement declaracion = null;
		ResultSet resultado = null;
		PreparedStatement ps = null;
		ADto aDto = new ADto();
		Scanner scan = new Scanner(System.in);
		long id_libro;
		int edicion;
		String titulo, autor, isbn;
		try {
			declaracion = conexion.createStatement();
			resultado = declaracion
					.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros\r\n" + "ORDER BY id_libro ASC ");
			listaLibrosUpdate = aDto.ResultadosLibros(resultado);
			for (int i = 0; i < listaLibrosUpdate.size(); i++) {
				System.out.println(listaLibrosUpdate.get(i).getId_libro() + "." + listaLibrosUpdate.get(i).getTitulo());
			}
			System.out.print("Introduzca el id del libro del que quiera editar sus datos--> ");
			id_libro = scan.nextLong();
			System.out.print("Actualiza el titulo-->");
			titulo = scan.next();
			System.out.print("Actualiza el autor-->");
			autor = scan.next();
			System.out.print("Actualiza el isbn-->");
			isbn = scan.next();
			System.out.print("Actualiza la edición-->");
			edicion = scan.nextInt();
			ps = conexion.prepareStatement(
					"UPDATE gbp_almacen.gbp_alm_cat_libros SET titulo = ?,autor= ?,isbn= ?,edicion= ? WHERE id_libro = ?;");
			ps.setString(1, titulo);
			ps.setString(2, autor);
			ps.setString(3, isbn);
			ps.setInt(4, edicion);
			ps.setLong(5, id_libro);
			ps.executeUpdate();
			ps.close();
			declaracion.close();
			resultado.close();
			conexion.close();
			System.out.println("[INFO-CrudImplementación-ActualizarLibros()]-Se han actualizado los datos del libro");
		} catch (SQLException sqle) {
			System.out.println("[ERROR-CrudImplementación-UpdateLibros()]-No se ha podido acceder a la base de datos.");
		}

	}

	@Override
	public void CrearLibros(Connection conexion) {
		int numLibrosCreados, edicion = 0;
		long id_libro;
		String titulo = "", autor = "", isbn = "";
		Scanner scan = new Scanner(System.in);
		PreparedStatement ps = null;
		ArrayList<Libros> listaLibrosCrear = new ArrayList<>();
		System.out.print("Introduzca el numero de libros que quiere crear-->");
		numLibrosCreados = scan.nextInt();
		System.out.println("--Iniciando creación de libros--");
		System.out.println("(Si no quiere crear más libros introduzca 0 en el campo de titulo)");
		for (int i = 0; i < numLibrosCreados; i++) {
			System.out.println("--------Libro: " + (i + 1) + "--------");
			System.out.print("Introduce el titulo del nuevo libro-->");
			titulo = scan.next();
			if (titulo.equals("0"))
				break;
			System.out.print("Introduce el autor del nuevo libro-->");
			autor = scan.next();
			System.out.print("Introduce el isbn del nuevo libro-->");
			isbn = scan.next();
			System.out.print("Introduce la edición del nuevo libro-->");
			edicion = scan.nextInt();
			listaLibrosCrear.add(new Libros(titulo, autor, isbn, edicion));
		}
		try {
			for (int i = 0; i < listaLibrosCrear.size(); i++) {
				ps = conexion
						.prepareStatement("INSERT INTO gbp_almacen.gbp_alm_cat_libros (titulo,autor,isbn,edicion)\r\n"
								+ "VALUES (?,?,?,?);");
				ps.setString(1, listaLibrosCrear.get(i).getTitulo());
				ps.setString(2, listaLibrosCrear.get(i).getAutor());
				ps.setString(3, listaLibrosCrear.get(i).getIsbn());
				ps.setInt(4, listaLibrosCrear.get(i).getEdicion());
				ps.executeUpdate();
			}
			ps.close();
			conexion.close();
			System.out.println(
					"[INFO-CrudImplementación-InsertLibros]-Se han guardado todos los libros en la base de datos");
		} catch (SQLException sqle) {
			System.out.println("[ERROR-CrudImplementación-InsertLibros()]-No se ha podido acceder a la base de datos.");
		}
	}

	@Override
	public void BorrarLibros(Connection conexion) {
		int idLibroBorrado = -1;
		Statement declaracion = null;
		ResultSet resultado = null;
		PreparedStatement ps = null;
		ArrayList<Libros> listaLibrosBorrar = new ArrayList<>();
		ADto aDto = new ADto();
		Scanner scan = new Scanner(System.in);
		try {
			declaracion = conexion.createStatement();
			resultado = declaracion
					.executeQuery("SELECT * FROM gbp_almacen.gbp_alm_cat_libros\r\n" + "ORDER BY id_libro ASC ");
			listaLibrosBorrar = aDto.ResultadosLibros(resultado);
			for (int i = 0; i < listaLibrosBorrar.size(); i++) {
				System.out.println(listaLibrosBorrar.get(i).getId_libro() + "." + listaLibrosBorrar.get(i).getTitulo());
			}
			System.out.print("Introduzca el id del libro que quiere borrar-->");
			idLibroBorrado = scan.nextInt();
			declaracion.close();
			resultado.close();
		} catch (SQLException sqle) {
			System.out.println("[ERROR-CrudImplementación-BorrarLibros()]-No se ha podido acceder a la base de datos.");
		}
		try {
			ps = conexion.prepareStatement("DELETE FROM gbp_almacen.gbp_alm_cat_libros\r\n" + "WHERE id_libro = ?");
			ps.setInt(1, idLibroBorrado);
			ps.executeUpdate();
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("[ERROR-CrudImplementación-BorrarLibros()]-No se ha podido borrar el registro.");
		}

	}
}
