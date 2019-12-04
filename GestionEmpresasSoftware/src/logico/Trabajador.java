package logico;

import java.io.Serializable;
import java.util.Date;

public abstract class Trabajador implements Serializable {

	protected String identificador;
	protected String nombre;
	protected String apellido;
	protected String direccion;
	protected String sexo;
	protected float salario;
	protected String evaluacion;
	protected double precioHora;
	protected int edad;
	private static final long serialVersionUID = 1L;
	
	public Trabajador(String identificador, String nombre, String apellido, String direccion, int edad, String sexo,
			float salario, String evaluacion, double precioHora) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.sexo = sexo;
		this.salario = salario;
		this.evaluacion = evaluacion;
		this.precioHora = precioHora;
		this.edad = edad;
	}
    
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String isSexo() {
		return sexo;
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
