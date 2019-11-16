package logico;

import java.util.Date;

public abstract class Trabajador {

	protected String identificador;
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected boolean sexo;
	protected Date fechaNacimiento;
	protected float salario;
	protected String evaluacion;
	protected double precioHora;
	
	public Trabajador(String identificador, String nombre, String apellido, String direccion, boolean sexo, Date fechaNacimiento,
			float salario, String evaluacion, double precioHora) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		this.evaluacion = evaluacion;
		this.precioHora = precioHora;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public boolean isSexo() {
		return sexo;
	}

	public int getEdad() {
		Date fechaActual = new Date();
		
		// TODO: return date difference instead
		return fechaActual.getYear() - this.fechaNacimiento.getYear();
	}

	public float getSalario() {
		return salario;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public double getPrecioHora() {
		return precioHora;
	}	
}
