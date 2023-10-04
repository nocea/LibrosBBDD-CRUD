package LibrosBBDD.Servicios;
import java.util.ArrayList;
import java.sql.Connection;
import LibrosBBDD.Dtos.*;
public interface CrudInterfaz {
	public ArrayList<Libros> SelectLibros(Connection conexion);
	public void UpdateLibros(Connection conexion);
	public void InsertLibros(Connection conexion);
}
