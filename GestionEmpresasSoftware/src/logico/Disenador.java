package logico;

import java.util.Date;

public class Disenador extends Trabajador {
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Disenador(String identificador, String nombre, String apellido, String direccion, boolean sexo,
			Date fechaNacimiento, float salario, String evaluacion, double precioHora, String tipo) {
		super(identificador, nombre, apellido, direccion, sexo, fechaNacimiento, salario, evaluacion, precioHora);
		this.tipo = tipo;
	}
}
