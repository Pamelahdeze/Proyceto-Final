package logico;

public class Programador extends Trabajador{

	private String lenguajeProg;

	public Programador(String nombre, String apellido, String direccion, boolean sexo, int edad, float salario,
			String nombreProyecto, String eval, double precioHora, String lenguajeProg, int id) {
		super(nombre, apellido, direccion, sexo, edad, salario, nombreProyecto, eval, precioHora, id);
		this.lenguajeProg = lenguajeProg;
	}
	
	public Programador(String nombre, int id) {
		super(nombre, "Sanchez", "a", false, 15, 45, "B", "qda", 20,id);
		this.lenguajeProg= "hoflda";
	}
	

	public String getLenguajeProg() {
		return lenguajeProg;
	}

	public void setLenguajeProg(String lenguajeProg) {
		this.lenguajeProg = lenguajeProg;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}
}