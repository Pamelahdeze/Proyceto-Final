package logico;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable{
	//private String identificador;
	private Proyecto proyecto;
	private Cliente cliente;
	private Date fechaInicio;
	private Date fechaEntrega;	
	private Date fechaProrroga;
	
	public Contrato(String identificador, Proyecto proyecto, Cliente cliente, Date fechaInicio, Date fechaEntrega, Date fechaProrroga) {
		//this.identificador = identificador;
		this.proyecto = proyecto;
		this.cliente = cliente;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.fechaProrroga = fechaProrroga;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

//	public String getIdentificadorContrato() {
//		return this.identificador;
//	}
//
//	public void setIdentificadorContrato(String identificadorContrato) {
//		this.identificador = identificadorContrato;
//	}

	public String getIdentificadorCliente() {
		return cliente.getIndentificador();
	}

	public Date getFechaProrroga() {
		return fechaProrroga;
	}

	public void setFechaProrroga(Date fechaProrroga) {
		this.fechaProrroga = fechaProrroga;
	}

	public String getNombreProyecto() {
		return proyecto.getNombre();
	}	
	
	public double calcularCosto() {
		double precioTrabajadores = 0;
		for (Trabajador trabajador : this.proyecto.getTrabajadores()) {
              precioTrabajadores += trabajador.precioHora;
     	}
		return precioTrabajadores * 8 * (fechaEntrega.getDay() - fechaInicio.getDay());
	}
	
	public double calcularGanancia() {
		double costo = calcularCosto();
		return costo + 0.15 * costo;
	}
}