
import java.lang.Math;

public class CCte extends Cuenta{
	private Interes interes;
	
	CCte(double numCuenta, int clave, Interes interes){
		super(numCuenta, clave);
		this.interes = interes;
	}
	
	public boolean extraccion(float monto, int clave) {
		boolean exito = false;
		monto = Math.abs(monto);
		float saldoActual = getSaldo();
		float resto = saldoActual - monto;
		if(condicionesDeExtraccion(monto, saldoActual, clave)) {
			// El cliente extrae mas de lo disponible en la cuenta
			if(monto > saldoActual && resto >= -5000) {
				setSaldo(0);
				Interes i = getInteres();
				i.nuevoInteres(Math.abs(resto));
				setInteres(i);
				actualizarRetiroDiario(monto);
				exito = true;
				// El cliente extrae menos de lo disponible, o bien la totalidad de esto mismo
				} else if(monto <= saldoActual) {
					setSaldo(saldoActual - monto);
					actualizarRetiroDiario(monto);
					exito = true;
					}
			}
		return exito;
	}
	
	@Override
	public boolean deposito(float monto, int clave) {
		boolean exito = false;
		monto = Math.abs(monto);
		if(getClave() == clave) {
			// Interes no vigente
			if (!getInteres().getVigente()) {
				setSaldo(getSaldo() + monto);
				exito = true;
			// Caso contrario
			} else {
				Interes i = getInteres();
				/* Se le resta el interes al monto depositado, un resultado 
				 * negativo implica un nuevo sobregiro, uno positivo
				 * implica que el saldo subira de 0
				 */
				float dineroRestante = monto - i.calcularInteres();
				// En caso de que el interes implique un nuevo sobregiro
				if(dineroRestante < 0) {
					// Se utiliza el valor absoluto ya que este es el utilizado por el calculo de sobregiro
					i.nuevoInteres(Math.abs(dineroRestante));
				// En caso de que el interes no implique un nuevo sobregiro
				} else { 
					setSaldo(dineroRestante);
					i.finalizarInteres();
				}
				setInteres(i);
				exito = true;
				}
		}
		return exito;
	}
	
	private boolean debajoDelLimiteDiario(float monto) {
		return super.debajoDelLimiteDiario(monto, 50000); 
	}
	
	public void reiniciarCantExtracciones() {}
	
	/* Se establecen varias condiciones:
	 * 1. Que la clave sea correcta
	 * 2. Que no se haya sobrepasado el limite diario de retiro
	 * 3. Que el saldo actual sea mayor a 0
	 */
	private boolean condicionesDeExtraccion(float monto, float saldoActual, int clave) {
		return getClave() == clave && debajoDelLimiteDiario(monto) && saldoActual > 0;
	}
	
	public Interes getInteres() {
		return interes;
	}

	public void setInteres(Interes interes) {
		this.interes = interes;
	}

	
}
