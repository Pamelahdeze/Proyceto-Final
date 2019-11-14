package logico;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {

	private ArrayList<Cliente> misClientes;
	private ArrayList<Trabajador> misTrabajadores;
	private Date fechaInicio;
	private Date fechaEntrega;
	private String identificadorContrato;
	private String identificadorCliente;
	private Date fechaProrroga;
	
	public Contrato(ArrayList<Cliente> misClientes, ArrayList<Trabajador> misTrabajadores, Date fechaInicio, Date fechaEntrega, String identificadorContrato,
			String identificadorCliente, Date fechaProrroga) {
		super();
		this.misClientes = misClientes;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.identificadorContrato = identificadorContrato;
		this.identificadorCliente = identificadorCliente;
		this.fechaProrroga = fechaProrroga;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
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

	public String getIdentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(String identificadorContrato) {
		this.identificadorContrato = identificadorContrato;
	}

	public String getIdentificadorCliente() {
		return identificadorCliente;
	}

	public void setIdentificadorCliente(String identificadorCliente) {
		this.identificadorCliente = identificadorCliente;
	}

	public Date getFechaProrroga() {
		return fechaProrroga;
	}

	public void setFechaProrroga(Date fechaProrroga) {
		this.fechaProrroga = fechaProrroga;
	}
	
	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}

	public void setMisTrabajadores(ArrayList<Trabajador> misTrabajadores) {
		this.misTrabajadores = misTrabajadores;
	}
	
}