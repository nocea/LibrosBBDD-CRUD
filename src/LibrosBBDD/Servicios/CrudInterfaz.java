package LibrosBBDD.Servicios;
import java.util.ArrayList;
import java.sql.Connection;
import LibrosBBDD.Dtos.*;
public interface CrudInterfaz {
	/**
	 * Método que devuelve un array para mostrar los libros que existen
	 * en la base de datos
	 * @param conexion
	 * */
	public void MostrarLibros(Connection conexion);
	/**
	 * Método para actualizar los datos de un registro de la base de datos
	 * @param conexion
	 * */
	public void ActualizarLibros(Connection conexion);
	/**
	 * Método para crear un nuevo registro en la base de datos
	 * @param conexion
	 * */
	public void CrearLibros(Connection conexion);
	/**
	 * Método para borrar un registro de la base de datos
	 * @param conexion
	 * */
	public void BorrarLibros(Connection conexion);
}
