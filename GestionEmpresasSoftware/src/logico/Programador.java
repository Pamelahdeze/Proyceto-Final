package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Programador extends Trabajador{

	private ArrayList<String> lenguajesProgramacion;

	public Programador(String identificador, String nombre, String apellido, String direccion, int edad, String sexo, float salario, String evaluacion, double precioHora, ArrayList<String> lenguajesProgramacion) {
		super(identificador, nombre, apellido, direccion, edad, sexo, salario, evaluacion, precioHora);

		this.lenguajesProgramacion = lenguajesProgramacion;
	}

	public ArrayList<String> getLenguajesProgramacion() {
		return lenguajesProgramacion;
	}

	public void setLenguajesProgramacion(ArrayList<String> lenguajesProgramacion) {
		this.lenguajesProgramacion = lenguajesProgramacion;
	}	
}