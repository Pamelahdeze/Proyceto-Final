package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
	private String indentificador;
	private String nombre;
	private String direccion;
	
	public Cliente(String indentificador, String nombre, String direccion) {
		this.indentificador = indentificador;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getIndentificador() {
		return indentificador;
	}

	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getCantidadProyectos(ArrayList<Contrato> contratos) {
		int cantidadProyectos = 0;
		
		for (Contrato contrato : contratos) {
			if (contrato.getIdentificadorCliente() == this.indentificador)
				cantidadProyectos++;
		}
		
		return cantidadProyectos;
	}
}
