package LibrosBBDD.Servicios;

import java.sql.Connection;

public class ConexionImplementacion implements ConexionInterfaz {

	@Override
	public Connection conectar() {
		//Declaro la conexión a null para que si hay un fallo poder saber donde
		Connection conexion=null;
		//Guardo los datos de conexion en un array de string
		String []propiedades=DatosConexion();
		return null;
	}
	private String[] DatosConexion() {
		String []propiedades=null;//Array que devuelvo
		String url,usuario,password;
		return propiedades;
	}

}
