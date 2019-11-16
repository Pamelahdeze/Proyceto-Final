package logico;

import java.util.Date;

public class JefeProyecto extends Trabajador {

	public JefeProyecto(String identificador, String nombre, String apellido, String direccion, boolean sexo,
			Date fechaNacimiento, float salario, String evaluacion, double precioHora) {
		super(identificador, nombre, apellido, direccion, sexo, fechaNacimiento, salario, evaluacion, precioHora);
	}
	
	public int getCantidadTrabajadores(Proyecto proyecto) {
		return proyecto.getTrabajadores().size();
	}
}
