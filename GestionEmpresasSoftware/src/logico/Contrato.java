package logico;

import java.util.Date;

public class Contrato {
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

	//public String getIdentificadorContrato() {
	//	return this.identificador;
	//}

	//public void setIdentificadorContrato(String identificadorContrato) {
	//	this.identificador = identificadorContrato;
	//}

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
		return 0;
	}
	
	public double calcularGanancia() {
		return 0;
	}
}
