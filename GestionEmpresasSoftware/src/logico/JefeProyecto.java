package logico;

import java.util.ArrayList;

import logico.Diseñador;
import logico.Programador;
import logico.Trabajador;

public class JefeProyecto extends Trabajador {
	public JefeProyecto(String nombre, String apellido, String direccion, boolean sexo, int edad, float salario,
			String nombreProyecto, String eval, double precioHora, int id) {
		super(nombre, apellido, direccion, sexo, edad, salario, nombreProyecto, eval, precioHora, id);
	}

	public JefeProyecto(String nombre, int id) {
		super(nombre, "Sanchez", "a", false, 15, 45, "A", "qda", 20,id);
	}
	
	public int getCantTrabajador() {
		int cantTrabajador = 0;
		Diseñador dis = new Diseñador("Pedro", 1);
		Programador prg = new Programador("Julio", 2);
		//Se necesita una conexión a la Base de Datos.
		ArrayList <Trabajador> trabajadores = new ArrayList<Trabajador>();
		trabajadores.add(dis);
		trabajadores.add(prg);
		
		
		for (Trabajador trabajador : trabajadores) {
			if (trabajador.getNombreProyecto() == this.getNombreProyecto()) {
				cantTrabajador++;
			}
		}
		return cantTrabajador;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

}
