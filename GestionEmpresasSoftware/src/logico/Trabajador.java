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
    
	

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public void setSalario(float salario) {
		this.salario = salario;
	}



	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}



	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
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
