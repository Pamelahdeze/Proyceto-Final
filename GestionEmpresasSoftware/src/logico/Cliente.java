package logico;

public class Cliente {

	private String indentificador;
	private String nombre;
	private String direccion;
	private int cantProyectos;
	
	public Cliente(String indentificador, String nombre, String direccion, int cantProyectos) {
		super();
		this.indentificador = indentificador;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cantProyectos = cantProyectos;
	}

	public String getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantProyectos() {
		return cantProyectos;
	}

	public void setCantProyectos(int cantProyectos) {
		this.cantProyectos = cantProyectos;
	}
	
}
