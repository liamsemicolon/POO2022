
import java.io.Serializable;

public abstract class Cuenta implements Serializable{
	// Numero de cuenta
	private double numCuenta;
	// Clave de seguridad de la cuenta
	private int clave;
	// Saldo de la cuenta
	private float saldo;
	// Contador de retiro diario de la cuenta
	private float retiroDiario;
	
	
	Cuenta(double numCuenta, int clave){
		this.numCuenta = numCuenta;
		this.clave = clave;
	}	
	
	public boolean deposito(float monto, int clave) {
		monto = Math.abs(monto);
		boolean exito = false;
		if(getClave() == clave) {
			setSaldo(getSaldo() + monto);
			exito = true;
		}
		return exito;
	}
	
	// Suma el monto retirado al conteo de retiro diario
	protected void actualizarRetiroDiario(float monto) {
		setRetiroDiario(getRetiroDiario() + monto);
	}
	
	// Confirma si la extraccion esta debajo del limite diario de extracciones 
	protected boolean debajoDelLimiteDiario(float monto, float limite) {
		return getRetiroDiario() + monto <= limite; 
	}
	
	public abstract boolean extraccion(float monto, int clave);
	
	/* Es abstracto para que la operacion pueda hacerse desde un arreglo
	 * sin importar el tipo de cuenta
	 */
	public abstract void reiniciarCantExtracciones();
	
	public double getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(double numCuenta) {
		this.numCuenta = numCuenta;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	};
	
	public float getRetiroDiario() {
		return retiroDiario;
	}
	public void setRetiroDiario(float retiroDiario) {
		this.retiroDiario = retiroDiario;
	}
}
