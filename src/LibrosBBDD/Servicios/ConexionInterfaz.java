package LibrosBBDD.Servicios;

import java.sql.Connection;
/**
 * Clase para realizar la conexión con la base de datos
 * */
public interface ConexionInterfaz {
	/**
	 * Método para conectar con la base de datos según los parametros de un archivo ".properties".
	 * */
	public Connection Conectar();
}
