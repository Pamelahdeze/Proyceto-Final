package logico;

import java.util.ArrayList;

import logico.Contrato;
import logico.Trabajador;

public class Empresa {

	private ArrayList<Contrato> misContratos;
	private ArrayList<Trabajador> misTrabajadores;
	
	public Empresa(ArrayList<Contrato> misContratos, ArrayList<Trabajador> misTrabajadores) {
		super();
		this.misContratos = misContratos;
		this.misTrabajadores = misTrabajadores;
	}

	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}

	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}

	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}

	public void setMisTrabajadores(ArrayList<Trabajador> misTrabajadores) {
		this.misTrabajadores = misTrabajadores;
	}
	
	public void RegistrarTrabajador(Trabajador aux) {
		misTrabajadores.add(aux);
		
	}
}
