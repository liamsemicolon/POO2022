
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class Banco implements Serializable{
	// Guarda el ultimo acceso al programa, lo cual servira para la logica del mismo
	LocalDate ultimoAcceso = LocalDate.of(0, 1, 1);
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public void actualizarDatos() {
		// Se obtienen los valores para comparar el ultimo acceso a la fecha actual
		LocalDate h = hoy();
		LocalDate d = getUltimoAcceso();
		YearMonth ymH = YearMonth.from(h);
		YearMonth ymD = YearMonth.from(d);
		// Si las fechas no son iguales
		if(!h.equals(d)) {
			for(Cliente c : getClientes()) {
				for(Cuenta b : c.getCuentas()) {
					// Se reinicia cada valor de retiro diario a 0
					b.actualizarRetiroDiario(0);
				}
			}
		}
		// Si el conjunto aaaa-mm (anio y mes) no es el mismo
		if(!ymH.equals(ymD)) {
			for(Cliente c : getClientes()) {
				for(Cuenta b : c.getCuentas()) {
					// Se reinicia la cantidad de extracciones mensuales a 0
					b.reiniciarCantExtracciones();
				}
			}
		}
	}
	
	public boolean asociarCliente(Cliente c) {
		// Asocia un nuevo cliente, devuelve true en caso de exito y false en caso de fallo
		boolean exito = false;
		ArrayList<Cliente> ac = getClientes();
		if(!clienteYaAsociado(c.getDni())) {
			ac.add(c);
			exito = true;
		}
		return exito;
	}
	
	private boolean clienteYaAsociado(int dni) {
		/* Se garantiza que no haya un cliente repetido, utilizando el
		 * numero de documento como factor a considerar
		 */
		for(Cliente c : getClientes()) {
			if(c.getDni() == dni) {
				return true;
			}
		}
		return false;
	}
	
	private LocalDate hoy() {
		return LocalDate.now();
	}
	
	public void actualizarUltimoAcceso() {
		setUltimoAcceso(hoy());
	}
	
	public LocalDate getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(LocalDate ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}
