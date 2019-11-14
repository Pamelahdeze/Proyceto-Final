package logico;

import java.util.ArrayList;

public class Diseñador extends Trabajador {
	
	private String tipo;
	private ArrayList<String> idProyectos;

	public Diseñador(String nombre, String apellido, String direccion, boolean sexo, int edad, float salario,
			String nombreProyecto, String eval, double precioHora, String tipo, int id) {
		super(nombre, apellido, direccion, sexo, edad, salario, nombreProyecto, eval, precioHora, id);
		this.tipo = tipo;
	}
	
	public Diseñador(String nombre, int id) {
		super(nombre, "Sanchez", "a", false, 15, 45, "A", "qda", 20,id);
		this.tipo = "hoflda";
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public ArrayList<String> getIdProyectos() {
		return idProyectos;
	}

	public void setIdProyectos(ArrayList<String> idProyectos) {
		this.idProyectos = idProyectos;
	}
	
	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
