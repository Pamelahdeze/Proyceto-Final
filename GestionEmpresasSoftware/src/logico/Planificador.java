package logico;

import java.util.Date;

import logico.Trabajador;

public class Planificador extends Trabajador {

	private int frecPlanificacionTareas;

	public Planificador(String identificador, String nombre, String apellido, String direccion, int edad, String sexo, float salario, String evaluacion, double precioHora, int frecPlanificacionTareas) {
		super(identificador, nombre, apellido, direccion, edad, sexo, salario, evaluacion, precioHora);
		this.frecPlanificacionTareas = frecPlanificacionTareas;
	}

	public int getFrecPlanificacionTareas() {
		return frecPlanificacionTareas;
	}

	public void setFrecPlanificacionTareas(int frecPlanificacionTareas) {
		this.frecPlanificacionTareas = frecPlanificacionTareas;
	}
}