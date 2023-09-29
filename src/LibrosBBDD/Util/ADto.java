package LibrosBBDD.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LibrosBBDD.Dtos.Libros;

public class ADto {
	public ArrayList<Libros> resultadosLibros(ResultSet resultado){
		ArrayList<Libros> listaLibros=new ArrayList<>();
		try {
			while(resultado.next()) {
				listaLibros.add(new Libros(resultado.getLong("id_libro"),resultado.getString("titulo"),resultado.getString("autor"),resultado.getString("isbn"),resultado.getInt("edicion")));
			}
		}catch(SQLException sqle) {
			System.out.println("[ERROR-ADto-resultadosLibros]-No se ha podido leer el ResultSet");
		}
		return listaLibros;
	}
}
