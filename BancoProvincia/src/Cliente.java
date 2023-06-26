
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cliente implements Serializable {
	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	public Cliente() {};
	
	public Cliente(int dni, String nombre, String apellido, String telefono) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
	};
	
	public String nombreCompleto() {
		// Devuelve nombre en formato "APELLIDO, Nombre"
		return getApellido().toUpperCase() + ", " + getNombre();
	}
	
	// Agrega una cuenta a la lista de cuentas, con numero de cuenta aleatorio
	public void abrirCuenta(int tipoCuenta, int clave) {
		ArrayList<Cuenta> ac = getCuentas();
		if(tipoCuenta == 0) {
			ac.add(new CAhorro(ThreadLocalRandom.current().nextInt(0, 99999999 + 1), clave));
		} else if (tipoCuenta == 1) {
			ac.add(new CCte(ThreadLocalRandom.current().nextInt(0, 99999999 + 1), clave, new Interes()));
		}
		setCuentas(ac);
	}
	
	// Elimina una cuenta de la lista de cuentas
	// Detalle: Permite eliminar cuentas con intereses sin consecuencia alguna
	public boolean cerrarCuenta(int indCuenta, int clave) {
		boolean exito = false;
		ArrayList<Cuenta> ac = getCuentas();
		Cuenta c = ac.get(indCuenta);
		if(c.getClave() == clave) {
			ac.remove(indCuenta);
			setCuentas(ac);
			exito = true;
		}
		return exito;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}