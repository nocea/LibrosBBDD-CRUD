package LibrosBBDD.Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.*;

public class ConexionImplementacion implements ConexionInterfaz {

	@Override
	public Connection Conectar() {
		//Declaro la conexión a null para que si hay un fallo poder saber donde
		Connection conexion=null;
		//Guardo los datos de conexion en un array de string
		String []propiedades=DatosConexion();
		if(!propiedades[2].isEmpty()) {//Si no esta vacío
			try {
			Class.forName("org.postgresql.Driver");//Instancia driver
			conexion=DriverManager.getConnection(propiedades[0],propiedades[1],propiedades[2]);
			if(!conexion.isValid(50000)) {//Si no da ping de conexion en ese tiempo no ha conectado
				conexion=null;//la declaro null
				System.out.println("[ERROR-ConexiónImplementacion-Conectar()]-No se ha realizado la conexión con la BBDD");
			}
			else {
				System.out.println("[INFO-ConexionImplementacion-Conectar()]-Se ha realizado la conexión con la BBDD");
			}
			return conexion;
			//Si da cualquier excepcion declaro la conexion como null.
			}catch(ClassNotFoundException clNoFo) {
				System.out.println("[ERROR-ConexionImplementacion-Conectar()]-No se ha encontrado la clase del driver");
				return conexion=null;
				
			}catch(SQLException sqle) {
				System.out.println("[ERROR-ConexionImplementacion-Conectar()]-No se ha podidio conectar con la BBDD");
				return conexion=null;
			}
			
		}
		else {//si esta vacío
			System.out.println("[ERROR-ConexionImplementacion-Conectar()]-No se han recibido las propiedades de conexion");
			return conexion;//Si entra aqui está null porque lo he inicializado null
		}
	}
	/**
	 * Método para obtener los datos de la conexión desde el archivo ".properties".
	 * */
	private String[] DatosConexion() {
		//Array que devuelvo
		String host,usuario="",contrasena="",baseDeDatos,url="",puerto;//Datos que quiero obtener del .properties
		Properties propiedadesCon=new Properties();//Propiedades
		try {
			//Cargo el ".properties" que está en la carpeta del proyecto.
			propiedadesCon.load(new FileInputStream("conexionBBDD.properties"));
			usuario=propiedadesCon.getProperty("usuario");
			contrasena=propiedadesCon.getProperty("contrasena");
			baseDeDatos=propiedadesCon.getProperty("bd");
			puerto=propiedadesCon.getProperty("puerto");
			host=propiedadesCon.getProperty("host");
			url="jdbc:postgresql://"+host+":"+puerto+"/"+baseDeDatos;
			//Se declara aqui porque solo se le pueden pasar datos en la inicialización.
			String []propiedades= {url,usuario,contrasena};
			return propiedades;
		}catch(Exception e) {
			System.out.println("[ERROR-ConexionImplementacion-DatosConexion()]-No se ha podidio acceder al archivo .properties");
			return null;
		}
	}

}
