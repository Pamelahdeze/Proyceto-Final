package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logico.Contrato;
import logico.Trabajador;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import logico.Contrato;
import logico.Trabajador;

public class Empresa {

	private ArrayList<Contrato> misContratos;
	private ArrayList<Trabajador> misTrabajadores;
	private ArrayList<Cliente> misClientes;
    private ArrayList<Usuario> misUsuarios;
	private static Empresa miEmpresa=null;
	public static Proyecto proyectoCreacion = null;
	public static ArrayList<Trabajador> trabajadoresProyectoCreacion = new ArrayList<Trabajador>();
	public Usuario usuarioLogeado;
	
	public Empresa() {
		this.misContratos= new ArrayList<Contrato>();
		this.misTrabajadores = new ArrayList<Trabajador>();
                this.misClientes = new ArrayList<Cliente>();
                this.misUsuarios = new ArrayList<Usuario>();
                this.obtenerDatos();
                if(misUsuarios.isEmpty()){
                   Usuario admin = new Usuario("administrador","admin","admin123");
                   misUsuarios.add(admin);
                   this.escribirDatos();
                }
	}

	public ArrayList<Contrato> getMisContratos() {
		return misContratos;
	}

	public void setMisContratos(ArrayList<Contrato> misContratos) {
		this.misContratos = misContratos;
	}
	
	public void RegistrarContrato(Contrato contrato) {
		misContratos.add(contrato);
	}
	public Contrato obtenerContrator(String id) {
		Contrato ContratoResultante = null;
		for (Contrato contrato : this.misContratos) {
			 if(contrato.getIdentificadorContrato().equals(id)) {
				 ContratoResultante = contrato;
				 break;
			 }
		}
		return ContratoResultante;
	}
	
	public void eliminarContrato(Contrato contrato) {
		misContratos.remove(contrato);
		escribirDatos();
	}

	//Métodos trabajadores
	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}

	public void setMisTrabajadores(ArrayList<Trabajador> misTrabajadores) {
		this.misTrabajadores = misTrabajadores;
	}
	
	public void RegistrarTrabajador(Trabajador aux) {
		misTrabajadores.add(aux);
		escribirDatos();
	}
	
	public ArrayList<Trabajador> obtenerTrabajadoresPorTipo(String clase){
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		for (Trabajador trabajador : this.misTrabajadores) {
			 if(trabajador.getClass().getSimpleName().equals(clase) ) {
				 trabajadores.add(trabajador);
			 }
		}
		return trabajadores;
	}
	
	public void eliminarTrabajador(Trabajador trabajador) {
		misTrabajadores.remove(trabajador);
		escribirDatos();
	}
	
	public boolean existeIdTrabajador(String Id) {
		 boolean existeId = false;
		 for (Trabajador trabajador : this.misTrabajadores) {
			 if(trabajador.getIdentificador().equals(Id)) {
				 existeId = true;
				 break;
			 }
		}
		 return existeId;
	}
	public boolean validarJefe(Trabajador trabajador) {
		boolean jefeApto = true;
		int cantidadProyectos = 0;
		for(Contrato contrato:misContratos) {
			if(contrato.getProyecto().getTrabajadores().contains(trabajador)) {
				cantidadProyectos++;
			}
		}
		if(cantidadProyectos > 1) {
			jefeApto = false;
		}
		return jefeApto;
	}
	//Métodos para el manejo de clientes
	
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	
	public void RegistrarCliente(Cliente cliente) {
		misClientes.add(cliente);
		this.escribirDatos();
	}
	
	public Cliente obtenerCliente(String id) {
		Cliente clienteResultante = null;
		for (Cliente cliente : this.misClientes) {
			 if(cliente.getIndentificador().equals(id)) {
				 clienteResultante = cliente;
				 break;
			 }
		}
		return clienteResultante;
	}
	
	public void eliminarCliente(Cliente cliente) {
		misClientes.remove(cliente);
		escribirDatos();
	}
	
	public boolean existeIdCliente(String Id) {
		 boolean existeId = false;
		 for (Cliente cliente : this.misClientes) {
			 if(cliente.getIndentificador().equals(Id)) {
				 existeId = true;
			 }
		 }
		 return existeId;
	}
	
	//Métodos para el manejo de usuarios

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public void setMisUsuarios(ArrayList<Usuario> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public void RegistrarUsuario(Usuario usuario) {
		misUsuarios.add(usuario);
		this.escribirDatos();
	}
	
	public Usuario obtenerUsuario(String nombre) {
		Usuario usuarioResultante = null;
		for (Usuario usuario : this.misUsuarios) {
			 if(usuario.getNombre().equals(nombre)) {
				 usuarioResultante = usuario;
				 break;
			 }
		}
		return usuarioResultante;
	}
	
	public boolean existeUsuario(String name) {
		 boolean existeUsuario = false;
		 for (Usuario usuario : this.misUsuarios) {
			 if(usuario.getNombre().equals(name)) {
				 existeUsuario = true;
			 }
		 }
		 return existeUsuario;
	}
	
	public void eliminarUsuario(Usuario usuario) {
		misUsuarios.remove(usuario);
		escribirDatos();
	}
        
	public boolean IniciarSesion(String usuario, String password){
            for (Usuario user : this.misUsuarios) {
				if (user.getNombre().equals(usuario) && user.getContraseña().equals(password)) {
					usuarioLogeado = user;
					return true;
				}
            }
            return false;
    }

	public void updateEvalacion(ArrayList<Proyecto> proyectos ) {
		//verifica cant de proyectos atrazados y actualiza evaluacion
		
	}
	
	public void penalizar(Trabajador trabajador) {
		//modifica salario
	}
	
	public static Empresa getInstance() {
		if (miEmpresa == null) {
			miEmpresa = new Empresa();
		}
		return miEmpresa; 
	}
	
	public void obtenerDatos() {
		FileInputStream ficontrato, fitrabajador, ficliente, fiusuario;
		ObjectInputStream oicontratos, oitrabajador, oicliente, oiusuario;
		try {
			ficontrato = new FileInputStream(new File("contratos.dat"));
			oicontratos = new ObjectInputStream(ficontrato);
			misContratos = (ArrayList<Contrato>)oicontratos.readObject();
			
			fitrabajador = new FileInputStream(new File("trabajadores.dat"));
			oitrabajador = new ObjectInputStream(fitrabajador);
			misTrabajadores = (ArrayList<Trabajador>)oitrabajador.readObject();
			
			ficliente = new FileInputStream(new File("clientes.dat"));
			oicliente = new ObjectInputStream(ficliente);
			misClientes = (ArrayList<Cliente>)oicliente.readObject();
			
			fiusuario = new FileInputStream(new File("usuarios.dat"));
			oiusuario= new ObjectInputStream(fiusuario);
			misUsuarios = (ArrayList<Usuario>)oiusuario.readObject();
			
			oitrabajador.close();
			oicontratos.close();
			oicliente.close();
            oiusuario.close();       
			
		} catch (FileNotFoundException e) {
			this.escribirDatos();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void escribirDatos() {
		try {
			FileOutputStream fcontratos = new FileOutputStream ("contratos.dat");
			FileOutputStream ftrabajadores = new FileOutputStream ("trabajadores.dat");
			FileOutputStream fclientes = new FileOutputStream ("clientes.dat");
			FileOutputStream fusuarios = new FileOutputStream ("usuarios.dat");
			ObjectOutputStream ocontratos 	= new ObjectOutputStream (fcontratos);
			ObjectOutputStream otrabajadores 	= new ObjectOutputStream (ftrabajadores);
			ObjectOutputStream oclientes = new ObjectOutputStream(fclientes);
			ObjectOutputStream ousuarios = new ObjectOutputStream(fusuarios);
			ocontratos.writeObject(misContratos);
			otrabajadores.writeObject(misTrabajadores);
			oclientes.writeObject(misClientes);
			ousuarios.writeObject(misUsuarios);
			ocontratos.close();
			otrabajadores.close();
			oclientes.close();
			ousuarios.close();
		} catch (FileNotFoundException ex) {
			System.err.println("Error "+ex);
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error "+e);
			e.printStackTrace();
		}
	}
}
