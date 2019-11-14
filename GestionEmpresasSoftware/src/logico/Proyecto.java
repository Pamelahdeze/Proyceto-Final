package logico;

public class Proyecto {

	private String estado;
	private String nombre;
	private String lenguaje;
	
	public Proyecto(String estado, String nombre, String lenguaje) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.lenguaje = lenguaje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
}