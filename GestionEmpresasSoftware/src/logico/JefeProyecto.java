package logico;

import java.util.Date;

public class JefeProyecto extends Trabajador {
    private int cantidadMaxTrabajadores;
	public JefeProyecto(String identificador, String nombre, String apellido, String direccion, int edad, String sexo, float salario, String evaluacion, double precioHora, int cantMaxTrabajadores) {
		super(identificador, nombre, apellido, direccion, edad, sexo, salario, evaluacion, precioHora);
		this.cantidadMaxTrabajadores = cantMaxTrabajadores;
	}
	
	public int getCantidadTrabajadores(Proyecto proyecto) {
		return proyecto.getTrabajadores().size();
	}

	public int getCantidadTrabajadores() {
		return cantidadMaxTrabajadores;
	}

	public void setCantidadTrabajadores(int cantidadTrabajadores) {
		this.cantidadMaxTrabajadores = cantidadTrabajadores;
	}
	
}
