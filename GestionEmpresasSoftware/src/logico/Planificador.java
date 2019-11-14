package logico;

import java.util.ArrayList;
import logico.Trabajador;

public class Planificador extends Trabajador {

	private int cantDias;
	private ArrayList<String> idProyectos;

	public Planificador(String nombre, String apellido, String direccion, boolean sexo, int edad, float salario,
			String nombreProyecto, String eval, double precioHora, int cantDias, int id) {
		super(nombre, apellido, direccion, sexo, edad, salario, nombreProyecto, eval, precioHora, id);
		this.cantDias = cantDias;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
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