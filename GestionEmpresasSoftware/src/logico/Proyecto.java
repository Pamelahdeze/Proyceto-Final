package logico;

import java.util.ArrayList;

public class Proyecto {

	private String identificador;
	private String nombre;
	private String lenguaje;
	private ArrayList<Trabajador> trabajadores;
	private String estado;
	
	public Proyecto(String identificador, String nombre, String lenguaje, String estado) {
		this.identificador = identificador;
		this.estado = estado;
		this.nombre = nombre;
		this.lenguaje = lenguaje;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	public ArrayList<Trabajador> getTrabajadores() {
		return trabajadores;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;		
	}
	
	public boolean agregarProgramador(Programador programador) {
		int programadoresActuales = 0;
		
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador.getClass().equals(programador.getClass()))
				programadoresActuales++;
		}
		
		if (programadoresActuales <= 2) {
			this.trabajadores.add(programador);
			return true;
		}
		
		return false;
	}
	
	public boolean agregarJefeProyecto (JefeProyecto jefeProyecto) {
		int jefesActuales = 0;
		
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador.getClass().equals(jefeProyecto.getClass()))
				jefesActuales++;
		}
		if (jefesActuales <= 1) {
			this.trabajadores.add(jefeProyecto);
			return true;
		}
		return false;
	}
	
	public boolean agregarPlanificador(Planificador planificador) {
		int planificadoresActuales = 0;
		
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador.getClass().equals(planificador.getClass()))
				planificadoresActuales++;
		}
		
		if (planificadoresActuales <= 3) {
			this.trabajadores.add(planificador);
			return true;
		}
		
		return false;
	}
	
	public boolean agregarDisenador(Disenador disenador) {
		int disenadoresActuales = 0;
		
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador.getClass().equals(disenador.getClass()))
				disenadoresActuales++;
		}
		
		if (disenadoresActuales <= 3) {
			this.trabajadores.add(disenador);
			return true;
		}
		
		return false;
	}

	public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}
	
	
}