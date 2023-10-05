package LibrosBBDD.Dtos;
/**
 * Dto de la entidad Libros
 * */
public class Libros {
	//Atributos
	private long id_libro;
	private String titulo;
	private String autor;
	private String isbn;
	private int edicion;
	//Constructor de libros con todos los parámetros
	public Libros(long id_libro, String titulo, String autor, String isbn, int edicion) {
		super();
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicion = edicion;
	}
	//Constructor para usar en el insert ya que no tengo que introducir "id_libro"
	public Libros(String titulo, String autor, String isbn, int edicion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicion = edicion;
	}
	//Getters & Setters
	public long getId_libro() {
		return id_libro;
	}
	public void setId_libro(long id_libro) {
		this.id_libro = id_libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getEdicion() {
		return edicion;
	}
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	//To String
	@Override
	public String toString() {
		return "Libros [id_libro=" + id_libro + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn
				+ ", edicion=" + edicion + "]";
	}
	
}
