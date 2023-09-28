package LibrosBBDD.Servicios;

import java.sql.Connection;
/**
 * Clase para realizar la conexión con la base de datos
 * 
 * */
public interface ConexionInterfaz {
	/**
	 * Conexion con la base de datos a partir de un .properties
	 * */
	public Connection conectar();
}
