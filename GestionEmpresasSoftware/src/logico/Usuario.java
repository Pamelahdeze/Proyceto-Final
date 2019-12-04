package logico;

import java.io.Serializable;

public class Usuario implements Serializable {
   private String nombre;
   private String tipo;
   private String contrase�a;
   
	public Usuario(String nombre, String tipo, String contrase�a) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.contrase�a = contrase�a;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
}
